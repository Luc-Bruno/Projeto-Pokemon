package persistencia;

import Model.Treinador;
import Model.TreinadorRepository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArquivoTreinador {
    private static final String PATH = "treinadores.txt";

    public List<Treinador> carregar() {
        List<Treinador> lista = new ArrayList<>();
        File f = new File(PATH);
        if (!f.exists()) return lista;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                lista.add(TreinadorRepository.getOuCriar(line.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void salvar(List<Treinador> treinadores) {
        File f = new File(PATH);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (Treinador t : treinadores) {
                bw.write(t.getNome());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
