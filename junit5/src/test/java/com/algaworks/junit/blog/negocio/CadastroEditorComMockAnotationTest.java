package com.algaworks.junit.blog.negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.modelo.Editor;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
// a anotação de mock só funcionou com essa anotação
@ExtendWith(MockitoExtension.class)
public class CadastroEditorComMockAnotationTest {

    Editor editor;

    @Mock
    // a instância é renovada a cada novo teste
    ArmazenamentoEditor armazenamentoEditor;

    @Mock
    GerenciadorEnvioEmail gerenciadorEnvioEmail;

    @InjectMocks
    CadastroEditor cadastroEditor;

    @BeforeEach
    void setup() {
        editor = new Editor(null, "Fulano", "fulano@detal.com", BigDecimal.TEN, true);

        // Mockito.when(armazenamentoEditor.salvar(editor))
        // .thenReturn(new Editor(1L, "fulano", "fulano@detal.com", BigDecimal.TEN,
        // true));

        // com o thenAnswer é possivel fazer uma customização do retorno
        when(armazenamentoEditor.salvar(any(Editor.class)))
                .thenAnswer(invocacao -> {
                    Editor editorPassado = invocacao.getArgument(0, Editor.class);
                    editorPassado.setId(1L);
                    return editorPassado;
                });

        when(armazenamentoEditor.encontrarPorEmail(ArgumentMatchers.anyString()))
                .thenReturn(Optional.empty());

    }

    @Test
    void Dado_um_editor_valido_Quando_criar_Entao_deve_retornar_um_id_de_cadastro() {
        Editor editorSalvo = cadastroEditor.criar(editor);
        assertEquals(1L, editorSalvo.getId());

    }

}
