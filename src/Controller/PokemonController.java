package Controller;

import Model.Pokemon;
import Model.Tipo;
import Model.Treinador;
import service.PokemonService;

import java.util.List;

public class PokemonController {
    private final PokemonService service = new PokemonService();

    /** Retorna a lista para quem quiser trabalhar com ela */
    public List<Pokemon> getPokemons() {
        return service.getPokemons();
    }

    /** Imprime a lista formatada no console */
    public void listarPokemons() {
        List<Pokemon> lista = service.getPokemons();
        if (lista.isEmpty()) {
            System.out.println("Nenhum Pokémon cadastrado.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            Pokemon p = lista.get(i);
            System.out.printf(
                    "%d) %s | Tipo: %s | Nível: %d | Treinador: %s%n",
                    i,
                    p.getNome(),
                    p.getTipo(),
                    p.getNivel(),
                    p.getTreinador().getNome()
            );
        }
    }

    /** Cria e persiste um novo Pokémon */
    public void adicionarPokemon(String nome, Tipo tipo, int nivel, Treinador dono) {
        service.criarPokemon(nome, tipo, nivel, dono);
        System.out.println("Pokémon \"" + nome + "\" adicionado com sucesso.");
    }

    /** Remove pelo nome e persiste */
    public boolean removerPokemon(String nome) {
        boolean ok = service.removerPokemon(nome);
        if (ok) System.out.println("Pokémon \"" + nome + "\" removido.");
        return ok;
    }

    /** Atualiza o nível (ganha XP se subir) e persiste */
    public boolean atualizarNivel(String nome, int novoNivel) {
        boolean ok = service.atualizarNivel(nome, novoNivel);
        if (ok) {
            System.out.println("Nível do Pokémon \"" + nome + "\" atualizado para " + novoNivel + ".");
        }
        return ok;
    }
}
