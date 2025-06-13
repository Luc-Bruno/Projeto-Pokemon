package service;

import Model.Pokemon;
import Model.PokemonRepository;
import Model.Tipo;
import Model.Treinador;
import persistencia.ArquivoPokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonService {
    private final List<Pokemon> pokemons;
    private final ArquivoPokemon arquivo;

    public PokemonService() {
        this.arquivo  = new ArquivoPokemon();
        this.pokemons = arquivo.carregar();
    }

    public Pokemon criarPokemon(String nome, Tipo tipo, int nivel, Treinador dono) {
        Pokemon p = PokemonRepository.getOuCriar(nome, tipo, dono);
        if (p.getNivel() < nivel) {
            p.ganharExperiencia(nivel - p.getNivel());
        }
        pokemons.add(p);
        return p;
    }

    public boolean removerPokemon(String nome) {
        Pokemon p = buscarPokemonPorNome(nome);
        if (p != null) {
            pokemons.remove(p);
            return true;
        }
        return false;
    }

    public boolean atualizarNivel(String nome, int novoNivel) {
        Pokemon p = buscarPokemonPorNome(nome);
        if (p != null) {
            int delta = novoNivel - p.getNivel();
            if (delta > 0) p.ganharExperiencia(delta);
            return true;
        }
        return false;
    }

    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons);
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
        pokemons.clear();
        pokemons.addAll(arquivo.carregar());
    }
}
