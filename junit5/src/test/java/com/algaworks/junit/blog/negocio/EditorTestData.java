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

    public static Editor umEditorNovo() {

        return new Editor(null, "Fulano", "fulano@detal.com", BigDecimal.TEN, true);
    }

    public static Editor umEditorExistente() {

        return new Editor(1L, "Fulano", "fulano@detal.com", BigDecimal.TEN, true);
    }
}
