package com.orange.marvelapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CadastroCpfException extends Exception{

    private static final long serialVersionUID = 1L;

    public CadastroCpfException (String cpf) {

        super(String.format("CPF %s já está cadastrado no sistema.", cpf));

    }
}
