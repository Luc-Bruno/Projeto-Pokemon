package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class TreinadorRepository {
    private static final Map<String, Treinador> MAPA = new HashMap<>();

    public static Treinador getOuCriar(String nome) {
        return MAPA.computeIfAbsent(nome, n -> new Treinador(n, 0));
    }

    public static List<Treinador> listarTreinadores() {
        return new ArrayList<>(MAPA.values());
    }

    public static boolean removerTreinador(String nome) {
        return MAPA.remove(nome) != null;
    }
}
