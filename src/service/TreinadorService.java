package service;

import Model.Treinador;
import persistencia.ArquivoTreinador;

import java.util.ArrayList;
import java.util.List;

public class TreinadorService {

    private List<Treinador> treinadores;
    private ArquivoTreinador arquivo;

    public TreinadorService() {
        this.arquivo = new ArquivoTreinador();
        this.treinadores = arquivo.carregar();
    }

    public void adicionarTreinador(Treinador t) {
        treinadores.add(t);
    }

    public boolean removerTreinador(String nome) {
        Treinador encontrado = buscarTreinadorPorNome(nome);
        if (encontrado != null) {
            treinadores.remove(encontrado);
            return true;
        }
        return false;
    }

    public List<Treinador> listarTreinadores() {
        return new ArrayList<>(treinadores);
    }

    public Treinador buscarTreinadorPorNome(String nome) {
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
        this.treinadores = arquivo.carregar();
    }
}
