package br.com.luiseduardo.kanban.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.luiseduardo.kanban.model.Usuario;
import br.com.luiseduardo.kanban.repository.UsuarioRepository;

@Service 
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(long id){
        return procurarUsuario(id);
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        usuario.setSenha(criptografaSenha(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario alterarUsuario(long id, Usuario novosDados){
        Usuario usuario = procurarUsuario(id);
        usuario.setNome(novosDados.getNome());
        usuario.setEmail(usuario.getEmail());

        return usuarioRepository.save(usuario);
    }

    private Usuario procurarUsuario(long id){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if(optionalUsuario.isEmpty()){
            throw new RuntimeException("Usuário Inexistente");
        }

        Usuario usuario = optionalUsuario.get();
        return usuario;
    }

    @Transactional
    public void deletarUsuario(long id){
        usuarioRepository.deleteById(id);
    }

    private String criptografaSenha(String senha){
        String hash = BCrypt.hashpw(senha, BCrypt.gensalt());
        return hash;
    }
}
