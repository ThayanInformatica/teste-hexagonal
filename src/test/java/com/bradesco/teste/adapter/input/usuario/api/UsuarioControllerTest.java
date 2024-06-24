package com.bradesco.teste.adapter.input.usuario.api;

import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioRequest;
import com.bradesco.teste.adapter.output.usuario.database.UsuarioPersistence;
import com.bradesco.teste.domain.model.Usuario;
import com.bradesco.teste.port.input.CriarUsuarioUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = UsuarioControllerTest.class)
@AutoConfigureMockMvc
class UsuarioControllerTest {
    @MockBean
    Logger LOGGER;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CriarUsuarioUseCase criarUsuarioUseCase;

    @MockBean
    UsuarioPersistence usuarioPersistence;

    @MockBean
    RestTemplate restTemplate;

    private static ObjectMapper objectMapper;

    @BeforeAll
    static void setUpBeforeClass() {
        objectMapper =
                new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Test
    void
    quando_criarUsuario_comUsuarioRequestPopulado
            () throws Exception {

        UsuarioRequest usuarioRequest = new
                UsuarioRequest("Teste 2123", 21);

        Usuario usuario = usuarioFromUsuarioRequest(usuarioRequest);

        when(criarUsuarioUseCase.executar(any(Usuario.class))).thenReturn
                (usuario);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/usuario")
                        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuarioRequest)))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @NotNull
    private Usuario
    usuarioFromUsuarioRequest(UsuarioRequest
                                      usuarioRequest) {
        return new Usuario(
                usuarioRequest.nome(), usuarioRequest.idade());
    }

}