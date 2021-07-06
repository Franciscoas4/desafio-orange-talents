package com.orange.marvelapi.controller;

import com.orange.marvelapi.dto.ComicDTO;
import com.orange.marvelapi.dto.MarvelComicDTO;
import com.orange.marvelapi.dto.data.WrapperData;
import com.orange.marvelapi.exceptions.ComicNaoEncontradoException;
import com.orange.marvelapi.exceptions.RegistroComicException;
import com.orange.marvelapi.service.ComicService;
import com.orange.marvelapi.service.MarvelClientService;
import com.orange.marvelapi.util.ComicsUtil;
import com.orange.marvelapi.util.DiasSemanaUtils;
import com.orange.marvelapi.util.MarvelSecurityUtil;
import com.orange.marvelapi.util.UtilIsbn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComicController {

    @Autowired
    private MarvelClientService marvelService;

    @Autowired
    private ComicService comicService;


    @GetMapping(value = "/v1/public/comics/{comicId}")
    public ResponseEntity<ComicDTO> getById(@PathVariable String comicId) throws RegistroComicException {

        String hash = MarvelSecurityUtil.gerarHash();
        String publicKey = MarvelSecurityUtil.getPublicKey();
        Integer diaSemana = DiasSemanaUtils.getDiaSemana();
        String nomeSemana = DiasSemanaUtils.getSemanaNome(diaSemana);

        WrapperData<MarvelComicDTO> marvelDto = marvelService.getById(comicId, publicKey, hash);
        ComicDTO comicDTO = new ComicDTO();

        for (MarvelComicDTO objMarvelDTO : marvelDto.getData().getResults()) {

            Integer diaSemanaIbsn = UtilIsbn.retornaIsbnDia(objMarvelDTO);
            String autorLista = ComicsUtil.converterListaCriadores(objMarvelDTO);
            Double preco = ComicsUtil.conveteListaPreco(objMarvelDTO);
            String titulo = ComicsUtil.limitarTamanhoString(objMarvelDTO.getTitle());
            String autor = ComicsUtil.limitarTamanhoString(autorLista);
            String descricao = ComicsUtil.limitarTamanhoString(objMarvelDTO.getDescription());

            if(diaSemanaIbsn == diaSemana) {

                preco -= preco*0.1;
                comicDTO.setDescontoAtivo(Boolean.TRUE);

            } else {

                comicDTO.setDescontoAtivo(Boolean.FALSE);
            }

            comicDTO.setComicId(objMarvelDTO.getId());
            comicDTO.setTitulo(titulo);
            comicDTO.setDesconto(nomeSemana);
            comicDTO.setCriadores(autor);
            comicDTO.setPreco(preco);
            comicDTO.setIsbn(objMarvelDTO.getIsbn());
            comicDTO.setDescricao(descricao);

            comicService.salvarComic(comicDTO);

        }

        return ResponseEntity.status(HttpStatus.CREATED).body(comicDTO);

    }

    @GetMapping(value = "/v1/public/comics")
    public WrapperData<MarvelComicDTO> findAll() {
        String hash = MarvelSecurityUtil.gerarHash();
        String publicKey = MarvelSecurityUtil.getPublicKey();
        Integer diaSemana = DiasSemanaUtils.getDiaSemana();
        String nomeSemana = DiasSemanaUtils.getSemanaNome(diaSemana);

        WrapperData<MarvelComicDTO> marvelDto = marvelService.getComics(publicKey, hash);

        return marvelDto;
    }
}
