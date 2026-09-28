package br.com.luiseduardo.kanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luiseduardo.kanban.model.Cartao;
import br.com.luiseduardo.kanban.model.Coluna;
import br.com.luiseduardo.kanban.model.Quadro;
import br.com.luiseduardo.kanban.repository.CartaoRepository;
import br.com.luiseduardo.kanban.repository.ColunaRepository;
import br.com.luiseduardo.kanban.repository.QuadroRepository;

@Service
public class QuadroService {

    @Autowired
    QuadroRepository quadroRepository;
    ColunaRepository colunaRepository;
    CartaoRepository cartaoRepository;

    public List<Quadro> listarQuadros() {
        return quadroRepository.findAll();
    }

    public Quadro buscarPorId(Long id){
        return quadroRepository.findById(id).orElseThrow();
    }

    public Quadro salvarQuadro(Quadro quadro) {
        Quadro quadroSalvo = quadroRepository.save(quadro);

        for (Coluna coluna : quadro.getColunas()) {
            coluna.setQuadro(quadroSalvo);
            Coluna colunaSalva = colunaRepository.save(coluna);

            for (Cartao cartao : coluna.getCartoes()) {
                cartao.setColuna(colunaSalva);
                cartaoRepository.save(cartao);
            }
        }
        return quadroSalvo;
    }

    public Quadro atualizarQuadro(Long id, Quadro quadro) {
        Quadro quadroExistente = quadroRepository.findById(id).orElseThrow();

        quadroExistente.setNome(quadro.getNome());

        Coluna colunaParaSalvar;

        for (Coluna coluna : quadro.getColunas()) {
            if (coluna.getId() != 0) {
                Coluna colunaExistente = colunaRepository.findById(coluna.getId()).orElseThrow();
                colunaExistente.setNome(coluna.getNome());
                colunaExistente.setCartoes(coluna.getCartoes());
                colunaParaSalvar = colunaExistente;
                colunaRepository.save(colunaExistente);
            } else {
                coluna.setQuadro(quadroExistente);
                colunaParaSalvar = coluna;
                colunaRepository.save(coluna);
            }
            for (Cartao cartao : coluna.getCartoes()) {
                if (cartao.getId() != 0) {
                    Cartao cartaoExistente = cartaoRepository.findById(cartao.getId()).orElseThrow();
                    cartaoExistente.setTitulo(cartao.getTitulo());
                    cartaoExistente.setDescricao(cartao.getDescricao());
                    cartaoExistente.setUsuarioAtribuido(cartao.getUsuarioAtribuido());

                    cartaoRepository.save(cartaoExistente);
                } else {
                    cartao.setColuna(colunaParaSalvar);
                    cartaoRepository.save(cartao);
                }
            }
        }
        return quadroRepository.save(quadroExistente);
    }

    public void deletarQuadro(Long id){
        quadroRepository.deleteById(id);
    }
}