package persistencia;

import Model.Pokemon;
import Model.Treinador;
import Model.TreinadorRepository;
import Model.PokemonRepository;
import Model.Tipo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoPokemon {
    private static final String PATH = "pokemons.txt";

    public List<Pokemon> carregar() {
        List<Pokemon> lista = new ArrayList<>();
        File f = new File(PATH);
        if (!f.exists()) return lista;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length < 4) continue;
                Treinador t = TreinadorRepository.getOuCriar(p[0]);
                String    nome  = p[1];
                int       nivel = Integer.parseInt(p[2]);
                Tipo      tipo  = Tipo.valueOf(p[3]);
                lista.add(PokemonRepository.getOuCriar(nome, tipo, t));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void salvar(List<Pokemon> pokemons) {
        File f = new File(PATH);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (Pokemon p : pokemons) {
                String line = String.join(";",
                        p.getTreinador().getNome(),
                        p.getNome(),
                        String.valueOf(p.getNivel()),
                        p.getTipo().name()
                );
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
