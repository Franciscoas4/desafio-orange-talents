package com.orange.marvelapi.service;

import com.orange.marvelapi.dto.MarvelComicDTO;
import com.orange.marvelapi.dto.data.WrapperData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://gateway.marvel.com/v1/public", name = "marvel")
public interface MarvelClientService {

    @GetMapping("/comics/{comicId}?ts=1&apikey={publicKey}&hash={hash}")
    public WrapperData<MarvelComicDTO> getById(
            @PathVariable("comicId") String comicId,
            @PathVariable("publicKey") String publicKey,
            @PathVariable("hash") String hash);

    @GetMapping("/comics?ts=1&apikey={publicKey}&hash={hash}")
    public WrapperData<MarvelComicDTO> getComics(
            @PathVariable("publicKey") String publicKey,
            @PathVariable("hash") String hash);
}
