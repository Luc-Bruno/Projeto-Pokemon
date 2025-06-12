package Controller;

import Model.Treinador;
import persistencia.ArquivoTreinador;

import java.util.List;
import java.util.ArrayList;

public class TreinadorController {
    private final List<Treinador> treinadores;
    private final ArquivoTreinador arquivo;

    public TreinadorController() {
        this.arquivo     = new ArquivoTreinador();
        this.treinadores = arquivo.carregar();
    }

    /** Cadastra um treinador com nome e idade, persiste em arquivo */
    public void cadastrarTreinador(String nome, int idade) {
        Treinador t = new Treinador(nome, idade);
        treinadores.add(t);
        arquivo.salvar(treinadores);
        System.out.println("Treinador '" + nome + "' cadastrado com sucesso.");
    }

    /** Retorna cópia da lista para ser exibida pela View */
    public List<Treinador> listarTreinadores() {
        return new ArrayList<>(treinadores);
    }
}
