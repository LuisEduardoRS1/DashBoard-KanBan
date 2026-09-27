package br.com.luiseduardo.kanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luiseduardo.kanban.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    
}
