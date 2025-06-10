package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Pokemon;

public class PokemonController {
    private List<Pokemon> pokemons = new ArrayList<>();
    public void adicionarPokemon(Pokemon p) {
    pokemons.add(p);
    System.out.println("Pokémon adicionado: " + p.getNome());
}

public List<Pokemon> listarPokemons() {
    return pokemons;
}

public Pokemon buscarPorNome(String nome) {
    for (Pokemon p : pokemons) {
        if (p.getNome().equalsIgnoreCase(nome)) return p;
    }
    return null;
}

public boolean atualizarNivel(String nome, int novoNivel) {
    Pokemon p = buscarPorNome(nome);
    if (p != null) {
        p.setNivel(novoNivel);
        return true;
    }
    return false;
}

public boolean removerPokemon(String nome) {
    return pokemons.removeIf(p -> p.getNome().equalsIgnoreCase(nome));
}

public List<Pokemon> getTodos() {
    return pokemons;
}


}
