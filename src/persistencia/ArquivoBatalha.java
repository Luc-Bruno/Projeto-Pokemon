package persistencia;

import Model.Batalha;
import Model.Treinador;
import Model.TreinadorRepository;
import Model.Pokemon;
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

public class ArquivoBatalha {
    private static final String PATH = "batalhas.txt";

    public List<Batalha> carregar() {
        List<Batalha> lista = new ArrayList<>();
        File file = new File(PATH);
        if (!file.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length < 7) continue;

                String t1Nome   = parts[0];
                String p1Nome   = parts[1];
                Tipo   p1Tipo   = Tipo.valueOf(parts[2]);
                String t2Nome   = parts[3];
                String p2Nome   = parts[4];
                Tipo   p2Tipo   = Tipo.valueOf(parts[5]);
                String vencedor = parts[6];

                Treinador t1 = TreinadorRepository.getOuCriar(t1Nome);
                Pokemon    p1 = PokemonRepository.getOuCriar(p1Nome, p1Tipo, t1);

                Treinador t2 = TreinadorRepository.getOuCriar(t2Nome);
                Pokemon    p2 = PokemonRepository.getOuCriar(p2Nome, p2Tipo, t2);

                Batalha b = new Batalha(p1, p2);
                b.setVencedor(vencedor);
                lista.add(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void salvar(List<Batalha> batalhas) {
        File file = new File(PATH);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Batalha b : batalhas) {
                String line = String.join(";",
                        b.getTreinador1().getNome(),
                        b.getPokemon1().getNome(),
                        b.getPokemon1().getTipo().name(),
                        b.getTreinador2().getNome(),
                        b.getPokemon2().getNome(),
                        b.getPokemon2().getTipo().name(),
                        b.getVencedor()
                );
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
