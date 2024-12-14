package com.algaworks.junit.blog.negocio;

import java.math.BigDecimal;

import com.algaworks.junit.blog.modelo.Editor;

/**
 * EditorTestData
 */
public class EditorTestData {

    // editor private não pode ser instanciada
    private EditorTestData() {
    };

    public static Editor.Builder umEditorNovo() {
        return Editor.builder()
                .comNome("Fulano")
                .comEmail("fulano@detal.com")
                .comValorPagoPorPalavra(BigDecimal.TEN)
                .comPremium(true);

    }

    public static Editor.Builder umEditorExistente() {
        return umEditorNovo().comId(1L);

    }

    public static Editor.Builder umEditorComIdInexistente() {
        return umEditorNovo().comId(99L);
    }
}
