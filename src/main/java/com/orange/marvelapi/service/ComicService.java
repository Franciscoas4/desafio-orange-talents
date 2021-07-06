package com.orange.marvelapi.service;

import com.orange.marvelapi.dto.ComicDTO;
import com.orange.marvelapi.exceptions.ComicNaoEncontradoException;
import com.orange.marvelapi.exceptions.RegistroComicException;
import com.orange.marvelapi.mappers.ComicMapper;
import com.orange.marvelapi.model.Comic;
import com.orange.marvelapi.repository.ComicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComicService {

    private ComicRepository comicRepository;

    private final ComicMapper comicMapper = ComicMapper.INSTANCE;

    @Autowired
    public ComicService(ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
    }

    public ComicService() {
    }

    public ComicDTO salvarComic(ComicDTO comicDTO) throws RegistroComicException {

        verificaLivroCadastrado(comicDTO.getComicId());

        Comic comic = comicMapper.toEntity(comicDTO);
        Comic comicCriado = comicRepository.save(comic);

        return comicMapper.toDTO(comicCriado);

    }

    public void verificaLivroCadastrado(Long comicId) throws RegistroComicException {

        Optional<Comic> comicCadastrado = comicRepository.findByComicId(comicId);

        if(comicCadastrado.isPresent()) {

            throw new RegistroComicException(comicId);
        }
    }

    public ComicDTO retornaComicDTO(Long comicId) throws ComicNaoEncontradoException {

        Optional<Comic> comicCadastrado = comicRepository.findByComicId(comicId);

        if(comicCadastrado.isPresent()) {

            Comic comic = new Comic();

            comic = comicRepository.getById(comicCadastrado.get().getCodigo());

            return comicMapper.toDTO(comic);

        }

        if(!comicCadastrado.isPresent()) {

            throw new ComicNaoEncontradoException(comicId);
        }

        return null;
    }
}
