package persistencia;

import Model.Pokemon;
import Model.Treinador;
import Model.TreinadorRepository;
import Model.PokemonRepository;
import Model.Tipo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoPokemon {
    private static final String PATH = "pokemons.txt";

    public List<Pokemon> carregar() {
        List<Pokemon> lista = new ArrayList<>();
        File file = new File(PATH);
        if (!file.exists()) return lista;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 4) continue;
                String nomeTreinador = parts[0];
                String nome          = parts[1];
                int    nivel         = Integer.parseInt(parts[2]);
                Tipo   tipo          = Tipo.valueOf(parts[3]);
                Treinador t = TreinadorRepository.getOuCriar(nomeTreinador);
                Pokemon    p = PokemonRepository.getOuCriar(nome, tipo, t);
                lista.add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

