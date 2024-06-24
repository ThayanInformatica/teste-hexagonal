package com.bradesco.teste.adapter.input.usuario.api;


import com.bradesco.teste.adapter.exception.handler.response.ApiErroResponse;
import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioRequest;
import com.bradesco.teste.adapter.input.usuario.api.dto.UsuarioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Usuario", description = "Operações para manter o cadastro de Usuário")
@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuario com Sucesso", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = UsuarioResponse.class))
        }),
        @ApiResponse(responseCode = "400", description = "Falha ao validar requisição", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErroResponse.class))
        })})
public interface UsuarioSwagger {

    @Operation(
            operationId = "criarUsuario",
            summary = "Endpoint responsável pela criação de usuário",
            description = "Cria um usuário com informações obrigatórias."
    )
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Created")})
    ResponseEntity<UsuarioResponse> criarUsuario(UsuarioRequest usuarioRequest) ;

}
