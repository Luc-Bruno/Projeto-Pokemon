// src/Model/TreinadorRepository.java
package Model;

import java.util.HashMap;
import java.util.Map;

public class TreinadorRepository {
    private static final Map<String, Treinador> MAPA = new HashMap<>();

    public static Treinador getOuCriar(String nome) {
        return MAPA.computeIfAbsent(nome, n -> new Treinador(n, 0));
    }
}
