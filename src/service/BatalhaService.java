package service;

import model.Batalha;
import model.Pokemon;
import persistencia.ArquivoBatalha;

import java.util.ArrayList;
import java.util.List;

public class BatalhaService {

    private List<Batalha> batalhas;
    private ArquivoBatalha arquivo;

    public BatalhaService() {
        this.arquivo = new ArquivoBatalha();
        this.batalhas = arquivo.carregar();
    }

    public Batalha realizarBatalha(Pokemon p1, Pokemon p2) {
        String resultado;
        if (p1.getAtaque() > p2.getAtaque()) {
            resultado = p1.getNome() + " venceu a batalha contra " + p2.getNome();
        } else if (p2.getAtaque() > p1.getAtaque()) {
            resultado = p2.getNome() + " venceu a batalha contra " + p1.getNome();
        } else {
            resultado = "A batalha entre " + p1.getNome() + " e " + p2.getNome() + " terminou em empate";
        }

        Batalha batalha = new Batalha(p1, p2, resultado);
        batalhas.add(batalha);
        return batalha;
    }

    public List<Batalha> listarBatalhas() {
        return new ArrayList<>(batalhas);
    }

    public void salvarBatalhas() {
        arquivo.salvar(batalhas);
    }

    public void carregarBatalhas() {
        this.batalhas = arquivo.carregar();
    }
}
