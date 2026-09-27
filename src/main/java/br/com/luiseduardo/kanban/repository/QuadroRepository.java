package br.com.luiseduardo.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiseduardo.kanban.model.Quadro;

public interface QuadroRepository extends JpaRepository<Quadro, Long>{
}
