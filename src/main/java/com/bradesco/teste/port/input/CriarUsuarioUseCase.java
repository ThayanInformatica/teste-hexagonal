package com.bradesco.teste.port.input;

import com.bradesco.teste.domain.model.Usuario;

public interface CriarUsuarioUseCase {
    Usuario executar(Usuario usuario);
}
