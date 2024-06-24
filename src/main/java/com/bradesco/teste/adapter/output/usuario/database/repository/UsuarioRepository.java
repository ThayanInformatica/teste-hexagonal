package com.bradesco.teste.adapter.output.usuario.database.repository;

import com.bradesco.teste.adapter.output.usuario.database.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID> {
    Optional<UsuarioEntity> findByNome(String nome);
}
	