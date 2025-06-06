package Model;

import java.util.ArrayList;

public class Treinador {
    private String nome;
    private int idade;
    private ArrayList<Pokemon> pokemons;

    public Treinador(String nome, int idade){
            this.nome = nome;
            this.idade = idade;
            this.pokemons = new ArrayList<>();
    }
    public void adicionarPokemon(Pokemon p){
        pokemons.add(p);
    }
    public void removerPokemon(Pokemon p){
        pokemons.remove(p);
    }
    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
