package service;

import Model.Treinador;
import persistencia.ArquivoTreinador;

import java.util.ArrayList;
import java.util.List;

public class TreinadorService {
    private final List<Treinador> treinadores;
    private final ArquivoTreinador arquivo;

    public TreinadorService() {
        this.arquivo      = new ArquivoTreinador();
        this.treinadores = arquivo.carregar();
    }

    public Treinador cadastrarTreinador(String nome, int idade) {
        Treinador t = new Treinador(nome, idade);
        treinadores.add(t);
        return t;
    }

    public boolean removerTreinador(String nome) {
        Treinador t = buscarTreinador(nome);
        if (t != null) {
            treinadores.remove(t);
            return true;
        }
        return false;
    }

    public boolean atualizarTreinador(String nome, String novoNome, int novaIdade) {
        Treinador t = buscarTreinador(nome);
        if (t != null) {
            t.setNome(novoNome);
            t.setIdade(novaIdade);
            return true;
        }
        return false;
    }

    public List<Treinador> listarTreinadores() {
        return new ArrayList<>(treinadores);
    }

    public Treinador buscarTreinador(String nome) {
        for (Treinador t : treinadores) {
            if (t.getNome().equalsIgnoreCase(nome)) {
                return t;
            }
        }
        return null;
    }

    public void salvarTreinadores() {
        arquivo.salvar(treinadores);
    }

    public void carregarTreinadores() {
        treinadores.clear();
        treinadores.addAll(arquivo.carregar());
    }
}
