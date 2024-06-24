package com.bradesco.teste.port.output;

import com.bradesco.teste.domain.model.Usuario;

import java.util.Optional;

public interface ConsultarUsuarioPort {
    Optional<Usuario> consultaPorNome(String nome);
}
