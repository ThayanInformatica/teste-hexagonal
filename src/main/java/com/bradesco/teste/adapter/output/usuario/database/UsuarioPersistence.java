
package com.bradesco.teste.adapter.output.usuario.database;

import com.bradesco.teste.adapter.input.usuario.api.dto.mapper.UsuarioMapper;
import com.bradesco.teste.adapter.output.usuario.database.entity.UsuarioEntity;
import com.bradesco.teste.adapter.output.usuario.database.repository.UsuarioRepository;
import com.bradesco.teste.domain.model.Usuario;
import com.bradesco.teste.port.output.ConsultarUsuarioPort;
import com.bradesco.teste.port.output.SalvarUsuarioPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Component
public class UsuarioPersistence implements ConsultarUsuarioPort,
        SalvarUsuarioPort {

    private final UsuarioRepository repository;
    private UsuarioMapper mapper;

    public UsuarioPersistence(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Usuario> consultaPorNome(String nome) {
        Objects.requireNonNull(nome, "nome não pode ser nulo");
        return repository.findByNome(nome)
                .map(usuarioEntity -> mapper.toUsuarioEntity(usuarioEntity));
    }

    @Override
    @Transactional
    public Usuario salvar(Usuario usuario) {
        Objects.requireNonNull(usuario, "Usuário não pode ser nula");
        UsuarioEntity usuarioEntity = mapper.toUsuario(usuario);
        return mapper.toUsuarioEntity(repository.save(usuarioEntity));
    }

}

