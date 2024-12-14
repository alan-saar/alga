package com.algaworks.junit.blog.negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.exception.EditorNaoEncontradoException;
import com.algaworks.junit.blog.exception.RegraNegocioException;
import com.algaworks.junit.blog.modelo.Editor;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// a anotação de mock só funcionou com essa anotação
@ExtendWith(MockitoExtension.class)
public class CadastroEditorComMockAnotationTest {

    @Spy
    // vai criar uma nova instancia a cada teste
    Editor editor = new Editor(null, "Fulano", "fulano@detal.com", BigDecimal.TEN, true);

    @Captor
    ArgumentCaptor<Mensagem> mensagemArgumentCaptor;

    @Mock
    // a instância é renovada a cada novo teste
    ArmazenamentoEditor armazenamentoEditor;

    @Mock
    GerenciadorEnvioEmail gerenciadorEnvioEmail;

    @InjectMocks
    CadastroEditor cadastroEditor;

    @BeforeEach
    void setup() {
        // editor = new Editor(null, "Fulano", "fulano@detal.com", BigDecimal.TEN,
        // true);

        // Mockito.when(armazenamentoEditor.salvar(editor))
        // .thenReturn(new Editor(1L, "fulano", "fulano@detal.com", BigDecimal.TEN,
        // true));

        // com o thenAnswer é possivel fazer uma customização do retorno
        lenient().when(armazenamentoEditor.salvar(any(Editor.class)))
                .thenAnswer(invocacao -> {
                    Editor editorPassado = invocacao.getArgument(0, Editor.class);
                    editorPassado.setId(1L);
                    return editorPassado;
                });

        lenient().when(armazenamentoEditor.encontrarPorEmail(ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());

    }

    @Test
    void Dado_um_editor_valido_Quando_criar_Entao_deve_retornar_um_id_de_cadastro() {
        Editor editorSalvo = cadastroEditor.criar(editor);
        assertEquals(1L, editorSalvo.getId());

    }

    @Test
    void Dado_um_editor_valido_Quando_criar_Entao_deve_chamar_metodo_salvar_do_armazenamento() {
        cadastroEditor.criar(editor);
        verify(armazenamentoEditor, times(1))
                .salvar(eq(editor));
    }

    @Test
    void Dado_um_editor_valido_Quando_criar_e_lancar_exception_ao_salvar_Entao_nao_deve_enviar_email() {
        // não aceita o any porque já usou num método anterior
        // when(armazenamentoEditor.salvar(any(Editor.class)))
        when(armazenamentoEditor.salvar(editor))
                .thenThrow(new RuntimeException());
        assertAll("Não deve enviar email quando lançar exception do armazenamento",
                () -> assertThrows(RuntimeException.class, () -> cadastroEditor.criar(editor)),
                // verifica se não houve nenhuma chamada ao método de envio de email
                () -> verify(gerenciadorEnvioEmail, never()).enviarEmail(any()));

    }

    @Test
    void Dado_um_editor_valido_Quando_cadastrar_Entao_deve_enviar_email_com_destino_ao_editor() {
        // preciso pegar o que foi enviado para mensagem, porque é um método que retorna
        // void

        // @formatter:off
        // Este mesmo argumentCaptor pode ser utilizado com anotacao @Captor
        // ArgumentCaptor<Mensagem> mensagemArgumentCaptor = ArgumentCaptor.forClass(Mensagem.class);
        // @formatter:on

        var editorSalvo = cadastroEditor.criar(editor);

        verify(gerenciadorEnvioEmail).enviarEmail(mensagemArgumentCaptor.capture());

        // mensagem passada quando o email foi enviado
        Mensagem mensagem = mensagemArgumentCaptor.getValue();

        // verifica se a mensagem passada é o mesmo do editor
        assertEquals(editorSalvo.getEmail(), mensagem.getDestinatario());

    }

    @Test
    // o spy serve para ver se um método real foi chamado no código de produção
    void Dado_um_editor_valido_Quando_cadastrar_Entao_deve_verificar_o_email() {
        // codigo para usar sem anotação
        // Editor editorSpy = spy(editor);
        // cadastroEditor.criar(editorSpy);
        // verify(editorSpy, atLeast(1)).getEmail();

        // codigo usando anotacao
        cadastroEditor.criar(editor);

        // o times(1) o teste não passa porque chama duas vezes
        verify(editor, atLeast(1)).getEmail();
    }

    @Test
    void Dado_um_editor_com_email_existente_Quando_cadastrar_Entao_deve_lancar_exception() {
        // issoo aqui é legal, quando o método for chamado a primeira vezes
        // vai retornar vazio.
        // na segunda vez vai retornar um objeto
        // significa que já foi cadastrado
        when(armazenamentoEditor.encontrarPorEmail("fulano@detal.com"))
                .thenReturn(Optional.empty())
                .thenReturn(Optional.of(editor));

        cadastroEditor.criar(editor);
        // Editor editorComEmailExistente = new Editor(null, "Fulano",
        // "fulano@detal.com", BigDecimal.TEN, true);
        // no lugar de ficar repetindo a criação de um novo editor, usa a classe
        // EditorTestData
        Editor editorComEmailExistente = EditorTestData.umEditorNovo();
        assertThrows(RegraNegocioException.class, () -> cadastroEditor.criar(editorComEmailExistente));
    }

    @Test
    void Dado_um_editor_valido_Quando_cadastrar_Entao_deve_enviar_email_apos_salvar() {
        cadastroEditor.criar(editor);
        // verifica a ordem das chamadas dos métodos
        // para saber se está salvando antes de enviar o email
        InOrder chamadas = inOrder(armazenamentoEditor, gerenciadorEnvioEmail);
        chamadas.verify(armazenamentoEditor, times(1)).salvar(editor);
        chamadas.verify(gerenciadorEnvioEmail, times(1)).enviarEmail(any(Mensagem.class));
    }

    // Esse méodo não roda por causa dos stubs feitos pelo mockito nos testes
    // anteriores.
    // para rodar tem que colocar os testes acima numa nested class
    // @Nested
    // class CadastroComEditorNull {
    // @Test
    // void Dado_um_editor_null_Quando_cadastrar_Entao_deve_lancar_exception() {
    // assertThrows(NullPointerException.class, () -> cadastroEditor.criar(null));
    // verify(armazenamentoEditor, never()).salvar(any());
    // verify(gerenciadorEnvioEmail, never()).enviarEmail(any());
    // }
    //
    // }

    // para esse tente rodar tem que colocar o lenient() para o mockito parar de
    // reclamar dos stubs
    @Test
    void Dado_um_editor_null_Quando_cadastrar_Entao_deve_lancar_exception() {
        assertThrows(NullPointerException.class, () -> cadastroEditor.criar(null));
        verify(armazenamentoEditor, never()).salvar(any());
        verify(gerenciadorEnvioEmail, never()).enviarEmail(any());
    }

    @Nested
    class EdicaoComEditorValido {
        @Spy
        Editor editor = new Editor(1L, "Fulano", "fulano@detal.com", BigDecimal.TEN, true);

        @BeforeEach
        void setup() {
            when(armazenamentoEditor.salvar(editor)).thenAnswer(
                    invocacao -> invocacao.getArgument(0, Editor.class));
            when(armazenamentoEditor.encontrarPorId(1L)).thenReturn(Optional.of(editor));
        }

        @Test
        void dado_um_editor_valido_Quando_editar_Entao_deve_alterar_editor_salvo() {
            // @formatter:off
            // Editor editorAtualizado = new Editor(1L, "Beltrano", "beltrano@detal.com", BigDecimal.ZERO, false);
            // @formatter:on
            Editor editorAtualizado = EditorTestData.umEditorExistente();
            editorAtualizado.setNome("Beltrano");
            editorAtualizado.setEmail("beltrano@detal.com");
            editorAtualizado.setValorPagoPorPalavra(BigDecimal.ZERO);
            editorAtualizado.setPremium(false);
            cadastroEditor.editar(editorAtualizado);
            verify(editor, times(1)).atualizarComDados(editorAtualizado);

            InOrder inOrder = inOrder(editor, armazenamentoEditor);
            inOrder.verify(editor).atualizarComDados(editorAtualizado);
            inOrder.verify(armazenamentoEditor).salvar(editor);
        }

    }

    @Nested
    class EdicaoComEditorInexistente {

        Editor editor = new Editor(99L, "Fulano", "fulano@detal.com", BigDecimal.TEN, true);

        @BeforeEach
        void setup() {
            when(armazenamentoEditor.encontrarPorId(99L)).thenReturn(Optional.empty());
        }

        @Test
        void Dado_um_editor_que_nao_exista_Quando_editar_Entao_deve_lancar_exception() {
            assertThrows(EditorNaoEncontradoException.class, () -> cadastroEditor.editar(editor));
            verify(armazenamentoEditor, never()).salvar(any());
        }
    }

}
