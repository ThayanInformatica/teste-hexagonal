package com.bradesco.teste.adapter.input.usuario.api;

import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioRequest;
import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioResponse;
import com.bradesco.teste.adapter.input.usuario.api.dto.mapper.UsuarioMapper;
import com.bradesco.teste.domain.model.Usuario;
import com.bradesco.teste.port.input.CriarUsuarioUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
        MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController implements UsuarioSwagger {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final UsuarioMapper mapper;

    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase, UsuarioMapper mapper) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @Override
    public ResponseEntity<UsuarioResponse> criarUsuario(@Valid @RequestBody final UsuarioRequest usuarioRequest) {

        Usuario executar = criarUsuarioUseCase
                .executar(mapper.toUsuarioRequest(usuarioRequest));

        UsuarioResponse response = mapper.toUsuarioResponse(executar);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

}
