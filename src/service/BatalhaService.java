package service;

import Model.Batalha;
import Model.Pokemon;
import persistencia.ArquivoBatalha;

import java.util.ArrayList;
import java.util.List;

public class BatalhaService {
    private final List<Batalha> batalhas;
    private final ArquivoBatalha arquivo;

    public BatalhaService() {
        this.arquivo   = new ArquivoBatalha();
        this.batalhas = arquivo.carregar();
    }

    public Batalha realizarBatalha(Pokemon p1, Pokemon p2) {
        Batalha b = new Batalha(p1, p2);
        b.batalhar();
        batalhas.add(b);
        arquivo.salvar(batalhas);
        return b;
    }

    public List<Batalha> listarBatalhas() {
        return new ArrayList<>(batalhas);
    }

    public boolean removerBatalha(int idx) {
        if (idx >= 0 && idx < batalhas.size()) {
            batalhas.remove(idx);
            arquivo.salvar(batalhas);
            return true;
        }
        return false;
    }

    public Batalha atualizarBatalha(int idx, Batalha nova) {
        if (idx >= 0 && idx < batalhas.size()) {
            batalhas.set(idx, nova);
            arquivo.salvar(batalhas);
            return nova;
        }
        return null;
    }
}
