package persistencia;

import Model.Batalha;
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

public class ArquivoBatalha {
    private static final String PATH = "batalhas.txt";

    public List<Batalha> carregar() {
        List<Batalha> lista = new ArrayList<>();
        File f = new File(PATH);
        if (!f.exists()) return lista;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(";");
                if (p.length < 7) continue;
                Treinador t1 = TreinadorRepository.getOuCriar(p[0]);
                Tipo tipo1    = Tipo.valueOf(p[2]);
                Pokemon  pk1  = PokemonRepository.getOuCriar(p[1], tipo1, t1);
                Treinador t2 = TreinadorRepository.getOuCriar(p[3]);
                Tipo tipo2    = Tipo.valueOf(p[5]);
                Pokemon  pk2  = PokemonRepository.getOuCriar(p[4], tipo2, t2);
                Batalha  b    = new Batalha(pk1, pk2);
                b.setVencedor(p[6]);
                lista.add(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void salvar(List<Batalha> batalhas) {
        File f = new File(PATH);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
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
