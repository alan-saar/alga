package com.algaworks.junit.blog.negocio;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.algaworks.junit.blog.armazenamento.ArmazenamentoEditor;
import com.algaworks.junit.blog.modelo.Editor;

/**
 * ArmazenamentoEditorFixoEmMemoria
 */
public class ArmazenamentoEditorFixoEmMemoria implements ArmazenamentoEditor {

    public boolean chamouSalvar;

    @Override
    public Editor salvar(Editor editor) {
        this.chamouSalvar = true;
        if (editor.getId() == null) {
            editor.setId(1L);
        }
        return editor;
    }

    @Override
    public Optional<Editor> encontrarPorId(Long editor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encontrarPorId'");
    }

    @Override
    public Optional<Editor> encontrarPorEmail(String email) {
        if (email == "email.existe@email.com") {
            return Optional.of(new Editor(2l, "Fulano", "email.existe@email.com", BigDecimal.TEN, true));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Editor> encontrarPorEmailComIdDiferenteDe(String email, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encontrarPorEmailComIdDiferenteDe'");
    }

    @Override
    public void remover(Long editorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public List<Editor> encontrarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'encontrarTodos'");
    }

}
