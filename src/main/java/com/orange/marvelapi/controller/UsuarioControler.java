package com.orange.marvelapi.controller;

import com.orange.marvelapi.dto.ComicDTO;
import com.orange.marvelapi.dto.UsuarioDTO;
import com.orange.marvelapi.exceptions.CadastroCpfException;
import com.orange.marvelapi.exceptions.CadastroEmailException;
import com.orange.marvelapi.exceptions.ComicNaoEncontradoException;
import com.orange.marvelapi.exceptions.UsuarioNaoCadastradoException;
import com.orange.marvelapi.model.Usuario;
import com.orange.marvelapi.service.ComicService;
import com.orange.marvelapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioControler {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ComicService comicService;

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDTO> salvarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) throws CadastroCpfException, CadastroEmailException, ComicNaoEncontradoException {

        ComicDTO comicDTO = comicService.retornaComicDTO(usuarioDTO.getComic().getComicId());

        usuarioDTO.setComic(comicDTO);

        usuarioService.cadastrarUsuario(usuarioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioDTO);

    }

    @GetMapping("/encontrar/{codigo}")
    public Usuario listarUsuario(@PathVariable Long codigo) throws UsuarioNaoCadastradoException {

        return usuarioService.listarUsuario(codigo);

    }
}
