package br.com.luiseduardo.kanban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luiseduardo.kanban.model.Quadro;
import br.com.luiseduardo.kanban.service.QuadroService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api/quadros")
public class QuadroController {
    
    @Autowired 
    QuadroService quadroService;

    @GetMapping    
    public List<Quadro> listarQuadros(){
        return quadroService.listarQuadros();
    }

    @GetMapping("/{id}")
    public Quadro buscarPorId(@PathVariable Long id){
        return quadroService.buscarPorId(id);
    }

    @PostMapping
    public Quadro salvarQuadro(@RequestBody Quadro quadro){
        return quadroService.salvarQuadro(quadro);
    }

    @PutMapping("/{id}")
    public Quadro atualizarQuadro(@PathVariable Long id, @RequestBody Quadro quadro){
        return quadroService.atualizarQuadro(id, quadro);
    }

    @DeleteMapping("/{id}")
    public void deletarQuadro(@PathVariable Long id){
        quadroService.deletarQuadro(id);
    }


}
