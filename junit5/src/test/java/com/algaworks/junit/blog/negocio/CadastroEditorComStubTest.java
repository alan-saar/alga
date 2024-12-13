package com.algaworks.junit.blog.negocio;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.algaworks.junit.blog.exception.RegraNegocioException;
import com.algaworks.junit.blog.modelo.Editor;

/**
 * CadastroEditorTest
 */
public class CadastroEditorComStubTest {

    CadastroEditor cadastroEditor;
    ArmazenamentoEditorFixoEmMemoria armazenamentoEditor;
    Editor editor;

    @BeforeAll
    static void beforeAll() {
    }

    @BeforeEach
    void setup() {
        editor = new Editor(null, "Fulano", "fulano@detal.com", BigDecimal.TEN, true);
        cadastroEditor = new CadastroEditor(
                armazenamentoEditor = new ArmazenamentoEditorFixoEmMemoria(),
                // clase Anônima
                // Classe anônima nada mais é do que a herança de determinada classe em um local
                // exclusivo, ou seja, apenas naquele determinado ponto eu preciso redefinir
                // minha classe-pai.
                new GerenciadorEnvioEmail() {
                    @Override
                    void enviarEmail(Mensagem mensagem) {
                        System.out.println("Enviando mensagem: " + mensagem.getDestinatario());
                    }
                });
    }

    @Test
    void Dado_um_editor_valido_Quando_criar_Entao_deve_retornar_um_id_de_cadastro() {
        Editor editorSalvo = cadastroEditor.criar(editor);
        assertEquals(1L, editorSalvo.getId());
        assertTrue(armazenamentoEditor.chamouSalvar);
    }

    @Test
    void dado_um_editor_null_Quando_criar_entao_deve_retornar_exception() {
        assertThrows(NullPointerException.class, () -> cadastroEditor.criar(null));
        assertFalse(armazenamentoEditor.chamouSalvar);
    }

    @Test
    void Dado_um_editor_com_email_existente_Quando_criar_Entao_deve_lancar_exception() {
        editor.setEmail("email.existe@email.com");
        assertThrows(RegraNegocioException.class, () -> cadastroEditor.criar(editor));
        assertFalse(armazenamentoEditor.chamouSalvar);
    }

    @Test
    void Dado_um_editor_com_email_existente_Quando_criar_Entao_nao_deve_salvar() {
        editor.setEmail("email.existe@email.com");
        try {
            cadastroEditor.criar(editor);
        } catch (RegraNegocioException e) {
        }
        assertFalse(armazenamentoEditor.chamouSalvar);
    }

}
