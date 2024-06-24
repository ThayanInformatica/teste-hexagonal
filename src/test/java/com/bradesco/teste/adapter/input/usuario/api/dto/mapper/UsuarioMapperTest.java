package com.bradesco.teste.adapter.input.usuario.api.dto.mapper;

import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioRequest;
import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioResponse;
import com.bradesco.teste.adapter.input.usuario.api.dto.mapper.UsuarioMapper;
import com.bradesco.teste.adapter.output.usuario.database.entity.UsuarioEntity;
import com.bradesco.teste.domain.model.Usuario;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class UsuarioMapperTest {

    UsuarioMapper mapper = Mappers.getMapper(UsuarioMapper.class);

    @Test
    void passarUsuarioEntity_converterParaUsuario() {
        UsuarioEntity usuarioEntity = new UsuarioEntity(
                UUID.randomUUID(),
                "teste",
                18);
        Usuario usuario = mapper.toUsuarioEntity(usuarioEntity);
        assertThat(usuario).isNotNull();
    }

    @Test
    void passarsuarioRequest_converterParaUsuario() {
        UsuarioRequest usuarioRequest = new UsuarioRequest(
                "Ronney",
                18);
        Usuario usuario = mapper.toUsuarioRequest(usuarioRequest);
        assertThat(usuario).isNotNull();
    }

    @Test
    void passarUsuario_converterParaUsuarioEntity() {
        Usuario usuario = new Usuario(
                "Juca",
                22);
        UsuarioEntity usuarioEntity = mapper.toUsuario(usuario);
        assertThat(usuarioEntity).isNotNull();
    }

    @Test
    void passarUsuario_converterParaUsuarioResponse() {
        Usuario usuario = new Usuario(
                "Jorge",
                21);
        UsuarioResponse usuarioResponse = mapper.toUsuarioResponse(usuario);
        assertThat(usuarioResponse).isNotNull();
    }
}