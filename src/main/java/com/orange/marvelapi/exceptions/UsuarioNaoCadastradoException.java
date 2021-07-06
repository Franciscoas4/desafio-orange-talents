package com.orange.marvelapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioNaoCadastradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public UsuarioNaoCadastradoException(Long id) {

        super(String.format("Usuário %s não está cadastrado no sistema.", id));

    }
}
