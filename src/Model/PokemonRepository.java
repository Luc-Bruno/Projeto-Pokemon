// src/Model/PokemonRepository.java
package Model;

import java.util.HashMap;
import java.util.Map;

public class PokemonRepository {
    private static final Map<String, Pokemon> MAPA = new HashMap<>();

    public static Pokemon getOuCriar(String nome, Tipo tipo, Treinador dono) {
        String key = dono.getNome() + "#" + nome + "#" + tipo;
        if (!MAPA.containsKey(key)) {
            Pokemon p;
            switch (tipo) {
                case FOGO:
                    p = new PokemonFogo(nome, 1, dono);
                    break;
                case AGUA:
                    p = new PokemonAgua(nome, 1, dono);
                    break;
                case PLANTA:
                    p = new PokemonGrama(nome, 1, dono);
                    break;
                default:
                    throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
            }
            dono.adicionarPokemon(p);
            MAPA.put(key, p);
        }
        return MAPA.get(key);
    }
}




