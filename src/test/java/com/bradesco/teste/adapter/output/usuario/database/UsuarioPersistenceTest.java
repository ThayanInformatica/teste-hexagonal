package com.bradesco.teste.adapter.output.usuario.database;

import com.bradesco.teste.adapter.input.usuario.api.dto.mapper.UsuarioMapper;
import com.bradesco.teste.adapter.output.usuario.database.UsuarioPersistence;
import com.bradesco.teste.adapter.output.usuario.database.entity.UsuarioEntity;
import com.bradesco.teste.adapter.output.usuario.database.repository.UsuarioRepository;
import com.bradesco.teste.domain.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UsuarioPersistenceTest {

    @Mock
    private UsuarioRepository repository;

    @Mock
    private UsuarioMapper mapper;

    @InjectMocks
    private UsuarioPersistence persistence;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void consultaPorNomeTest() {

        Usuario usuario = new Usuario("Teste", 18);
        when(repository.findByNome(usuario.nome())).thenReturn(Optional.of(new UsuarioEntity()));
        when(mapper.toUsuarioEntity(any())).thenReturn(usuario);
        when(mapper.toUsuarioRequest(any())).thenReturn(usuario);

        Optional<Usuario> result = persistence.consultaPorNome(usuario.nome());

        verify(repository).findByNome(usuario.nome());
        verify(mapper).toUsuarioEntity(any());
        assertEquals(usuario, result.orElse(null));
    }

    @Test
    void consultaPorNomeTest_Null() {
        assertThrows(NullPointerException.class, () -> persistence.consultaPorNome(null));
    }

    @Test
    void salvarTest() {

        Usuario usuario = new Usuario("teste", 18);
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        when(mapper.toUsuario(any())).thenReturn(usuarioEntity);
        when(repository.save(any())).thenReturn(usuarioEntity);
        when(mapper.toUsuarioEntity(any())).thenReturn(usuario);

        Usuario result = persistence.salvar(usuario);

        verify(mapper).toUsuario(usuario);
        verify(repository).save(usuarioEntity);
        verify(mapper).toUsuarioEntity(usuarioEntity);
        assertEquals(usuario, result);
    }

    @Test
    void salvarTest_NullUsuario() {
        assertThrows(NullPointerException.class, () -> persistence.salvar(null));
    }

}