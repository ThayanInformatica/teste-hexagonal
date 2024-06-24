package com.bradesco.teste.domain.service;

import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioResponse;
import com.bradesco.teste.domain.model.Usuario;
import com.bradesco.teste.port.output.ConsultarUsuarioPort;
import com.bradesco.teste.port.output.SalvarUsuarioPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioEntityServiceTest {

    @Mock
    private ConsultarUsuarioPort consultarUsuarioPort;
    @Mock
    private SalvarUsuarioPort salvarUsuarioPort;

    private UsuarioService usuarioService;

    private Usuario usuario;


    @BeforeEach
    void init() {

        usuarioService = new UsuarioService(consultarUsuarioPort, salvarUsuarioPort);

        usuario = new Usuario("Teste", 23);
        UsuarioResponse usuarioResponse = new UsuarioResponse("Teste", 23);
    }

    @Test
    void retornaSucesso_QuandoCriaUsuario() {

        when(consultarUsuarioPort.consultaPorNome(any(String.class))).thenReturn(Optional.empty());
        when(salvarUsuarioPort.salvar(any(Usuario.class))).thenReturn(usuario);

        Usuario executado = usuarioService.executar(usuario);

        assertNotNull(executado);
    }

    @Test
    void retornaErro_QuandoUsuarioExiste() {

        when(consultarUsuarioPort.consultaPorNome(any(String.class))).thenReturn(Optional.of(usuario));

        Usuario executado = usuarioService.executar(usuario);

        assertNotNull(executado);
    }

}