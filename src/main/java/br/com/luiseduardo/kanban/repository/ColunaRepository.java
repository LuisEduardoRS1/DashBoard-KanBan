package br.com.luiseduardo.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiseduardo.kanban.model.Coluna;

public interface ColunaRepository extends JpaRepository<Coluna, Long> {
    
}
