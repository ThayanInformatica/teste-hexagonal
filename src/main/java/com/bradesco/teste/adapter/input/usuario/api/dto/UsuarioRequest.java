package com.bradesco.teste.adapter.input.usuario.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nome",
        "idade",
})
public record UsuarioRequest(
        @NotNull
        @JsonProperty("nome")
        String nome,
        @NotNull
        @JsonProperty("idade")
        Integer idade) {
}
