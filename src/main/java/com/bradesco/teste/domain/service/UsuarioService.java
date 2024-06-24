package com.bradesco.teste.domain.service;

import com.bradesco.teste.domain.model.Usuario;
import com.bradesco.teste.port.input.CriarUsuarioUseCase;
import com.bradesco.teste.port.output.ConsultarUsuarioPort;
import com.bradesco.teste.port.output.SalvarUsuarioPort;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements CriarUsuarioUseCase {

    private final ConsultarUsuarioPort consultarUsuarioPort;

    private final SalvarUsuarioPort salvarUsuarioPort;

    public UsuarioService(ConsultarUsuarioPort consultarUsuarioPort,
                          SalvarUsuarioPort salvarUsuarioPort) {
        this.consultarUsuarioPort = consultarUsuarioPort;
        this.salvarUsuarioPort = salvarUsuarioPort;
    }

    @Override
    public Usuario executar(Usuario usuario) {

        var entity = consultarUsuarioPort.consultaPorNome(usuario.nome());

        return entity.orElseGet(() -> salvarUsuarioPort.salvar(usuario));

    }
}
