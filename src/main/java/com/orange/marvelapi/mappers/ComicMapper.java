package com.orange.marvelapi.mappers;

import com.orange.marvelapi.dto.ComicDTO;
import com.orange.marvelapi.model.Comic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ComicMapper {

    ComicMapper INSTANCE = Mappers.getMapper(ComicMapper.class);

    Comic toEntity(ComicDTO comicDTO);

    ComicDTO toDTO(Comic comic);
}
