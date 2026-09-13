package br.com.luiseduardo.kanban.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luiseduardo.kanban.model.Usuario;
import br.com.luiseduardo.kanban.service.UsuarioService;

@RestController 
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario buscarPorId(@PathVariable long id){
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario){
        return usuarioService.cadastrarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public Usuario alterarUsuario(@PathVariable long id, @RequestBody Usuario usuario){
        return usuarioService.alterarUsuario(id,usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable long id){
        usuarioService.deletarUsuario(id);
    }
}
