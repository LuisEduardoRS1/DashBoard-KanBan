package br.com.luiseduardo.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiseduardo.kanban.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
