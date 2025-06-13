// src/Controller/TreinadorController.java
package Controller;

import Model.Treinador;
import persistencia.ArquivoTreinador;
import java.util.List;
import java.util.ArrayList;

public class TreinadorController {
    private final List<Treinador> treinadores;
    private final ArquivoTreinador arquivo;

    public TreinadorController() {
        this.arquivo    = new ArquivoTreinador();
        this.treinadores = arquivo.carregar();
    }

    public void adicionarTreinador(String nome) {
        cadastrarTreinador(nome, 0);
    }

    public void cadastrarTreinador(String nome, int idade) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: nome não pode ficar vazio.");
            return;
        }

        treinadores.add(new Treinador(nome, idade));
        arquivo.salvar(treinadores);
        System.out.println("Treinador \"" + nome + "\" cadastrado com sucesso.");
    }

    public List<Treinador> listarTreinadores() {
        return new ArrayList<>(treinadores);
    }

    public void removerTreinador(String nome) {
        Treinador t = buscarTreinador(nome);
        if (t != null) {
            treinadores.remove(t);
            arquivo.salvar(treinadores);
            System.out.println("Treinador \"" + nome + "\" removido.");
        } else {
            System.out.println("Treinador não encontrado.");
        }
    }

    public Treinador buscarTreinador(String nome) {
        for (Treinador t : treinadores) {
            if (t.getNome().equalsIgnoreCase(nome)) {
                return t;
            }
        }
        return null;
    }

    public void atualizarTreinador(String nomeAntigo, String novoNome, int novaIdade) {
        Treinador t = buscarTreinador(nomeAntigo);
        if (t == null) {
            System.out.println("Treinador não encontrado.");
            return;
        }
        t.setNome(novoNome);
        t.setIdade(novaIdade);
        arquivo.salvar(treinadores);
        System.out.println("Treinador \"" + novoNome + "\" atualizado com sucesso.");
    }
}
