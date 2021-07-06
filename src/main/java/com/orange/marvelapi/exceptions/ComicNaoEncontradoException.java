package com.orange.marvelapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ComicNaoEncontradoException extends Exception{

    private static final long serialVersionUID = 1L;

    public ComicNaoEncontradoException(Long comicId) {

        super(String.format("Comic %s não está cadastrado no sistema.", comicId));

    }
}
