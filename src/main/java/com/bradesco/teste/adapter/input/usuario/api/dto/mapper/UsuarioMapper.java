package com.bradesco.teste.adapter.input.usuario.api.dto.mapper;

import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioRequest;
import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioResponse;
import com.bradesco.teste.adapter.output.usuario.database.entity.UsuarioEntity;
import com.bradesco.teste.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mapping(target = "nome", source = "usuarioEntity.nome")
    @Mapping(target = "idade", source = "usuarioEntity.idade")
    Usuario toUsuarioEntity(UsuarioEntity usuarioEntity);

    @Mapping(target = "nome", source = "request.nome")
    @Mapping(target = "idade", source = "request.idade")
    Usuario toUsuarioRequest(UsuarioRequest request);

    @Mapping(target = "nome", source = "usuario.nome")
    @Mapping(target = "idade", source = "usuario.idade")
    @Mapping(target = "id", ignore = true)
    UsuarioEntity toUsuario(Usuario usuario);

    UsuarioResponse toUsuarioResponse(Usuario usuario);
}