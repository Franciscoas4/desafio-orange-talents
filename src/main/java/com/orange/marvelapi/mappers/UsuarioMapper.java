package com.orange.marvelapi.mappers;

import com.orange.marvelapi.dto.UsuarioDTO;
import com.orange.marvelapi.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "comic", target = "comic")
    Usuario toEntity(UsuarioDTO usuarioDTO);

    @Mapping(source = "comic", target = "comic")
    UsuarioDTO toDTO(Usuario usuario);
}
