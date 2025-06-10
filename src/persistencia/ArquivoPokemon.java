package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Model.Pokemon;
import Model.PokemonAgua;
import Model.PokemonFogo;

public class ArquivoPokemon {
    public static void salvarPokemons(List<Pokemon> lista, String caminho) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(caminho))) {
        for (Pokemon p : lista) {
            writer.println(p.getClass().getSimpleName() + ";" + p.getNome() + ";" + p.getNivel() + ";" + p.getExperiencia());
        }
    } catch (IOException e) {
        System.out.println("Erro ao salvar: " + e.getMessage());
    }
}

public static List<Pokemon> carregarPokemons(String caminho) {
    List<Pokemon> lista = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] partes = linha.split(";");
            String tipo = partes[0];
            String nome = partes[1];
            int nivel = Integer.parseInt(partes[2]);

            Pokemon p = switch (tipo) {
                case "PokemonFogo" -> new PokemonFogo(nome, nivel);
                case "PokemonAgua" -> new PokemonAgua(nome, nivel);
                default -> null;
            };

            if (p != null) lista.add(p);
        }
    } catch (IOException e) {
        System.out.println("Erro ao carregar: " + e.getMessage());
    }
    return lista;
}

}
