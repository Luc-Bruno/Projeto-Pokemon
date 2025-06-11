package service;

import model.Pokemon;
import persistencia.ArquivoPokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonService {

    private List<Pokemon> pokemons;
    private ArquivoPokemon arquivo;

    public PokemonService() {
        this.arquivo = new ArquivoPokemon();
        this.pokemons = arquivo.carregar();
    }

    public void adicionarPokemon(Pokemon p) {
        pokemons.add(p);
    }

    public boolean removerPokemon(String nome) {
        Pokemon encontrado = buscarPokemonPorNome(nome);
        if (encontrado != null) {
            pokemons.remove(encontrado);
            return true;
        }
        return false;
    }

    public List<Pokemon> listarPokemons() {
        return new ArrayList<>(pokemons); // cópia da lista para segurança
    }


    public Pokemon buscarPokemonPorNome(String nome) {
        for (Pokemon p : pokemons) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }

    public void salvarPokemons() {
        arquivo.salvar(pokemons);
    }

    public void carregarPokemons() {
        this.pokemons = arquivo.carregar();
    }
}
