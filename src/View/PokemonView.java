package View;

import Controller.PokemonController;
import Model.Pokemon;
import Model.Tipo;
import Model.Treinador;
import Model.TreinadorRepository;
import java.util.List;
import java.util.Scanner;

public class PokemonView {
    private final PokemonController controller;
    private final Scanner scanner = new Scanner(System.in);

    public PokemonView(PokemonController controller) {
        this.controller = controller;
    }

    public void mostrarMenu() {
        int opc;
        do {
            System.out.println("\n----- MENU POKÉMON -----");
            System.out.println("1. Adicionar Pokémon");
            System.out.println("2. Listar Pokémons");
            System.out.println("3. Atualizar nível do Pokémon");
            System.out.println("4. Remover Pokémon");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1 -> adicionarPokemon();
                case 2 -> listarPokemons();
                case 3 -> atualizarNivel();
                case 4 -> removerPokemon();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opc != 0);
    }

    private void adicionarPokemon() {
        System.out.print("Nome do treinador dono: ");
        String donoNome = scanner.nextLine().trim();
        Treinador dono = TreinadorRepository.getOuCriar(donoNome);

        System.out.print("Nome do Pokémon: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Tipo (FOGO, AGUA, PLANTA): ");
        Tipo tipo;
        try {
            tipo = Tipo.valueOf(scanner.nextLine().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo inválido, operação cancelada.");
            return;
        }

        System.out.print("Nível inicial: ");
        int nivel;
        try {
            nivel = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Nível inválido, operação cancelada.");
            return;
        }

        controller.adicionarPokemon(nome, tipo, nivel, dono);
    }

    private void listarPokemons() {
        List<Pokemon> lista = controller.getPokemons();
        if (lista.isEmpty()) {
            System.out.println("Nenhum Pokémon cadastrado.");
            return;
        }
        System.out.println("Pokémons cadastrados:");
        for (int i = 0; i < lista.size(); i++) {
            Pokemon p = lista.get(i);
            System.out.printf("%d) %s | Tipo: %s | Nível: %d | Treinador: %s%n",
                    i, p.getNome(), p.getTipo(), p.getNivel(), p.getTreinador().getNome());
        }
    }

    private void atualizarNivel() {
        System.out.print("Digite o nome do Pokémon: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Novo nível: ");
        int novoNivel;
        try {
            novoNivel = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Nível inválido, operação cancelada.");
            return;
        }

        boolean atualizado = controller.atualizarNivel(nome, novoNivel);
        if (atualizado) {
            System.out.println("Nível atualizado com sucesso.");
        } else {
            System.out.println("Pokémon não encontrado.");
        }
    }

    private void removerPokemon() {
        System.out.print("Digite o nome do Pokémon a remover: ");
        String nome = scanner.nextLine().trim();

        boolean removido = controller.removerPokemon(nome);
        if (removido) {
            System.out.println("Pokémon removido com sucesso.");
        } else {
            System.out.println("Pokémon não encontrado.");
        }
    }
}
