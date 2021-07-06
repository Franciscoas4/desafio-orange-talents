package com.orange.marvelapi.exceptions;

public class CadastroEmailException extends Exception{

    private static final long serialVersionUID = 1L;

    public CadastroEmailException (String email) {

        super(String.format("E-mail %s já está cadastrado no sistema.", email));

    }
}
