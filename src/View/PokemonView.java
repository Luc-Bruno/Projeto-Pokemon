package View;

import java.util.List;
import java.util.Scanner;

import Controller.PokemonController;
import Model.Pokemon;
import Model.PokemonAgua;
import Model.PokemonFogo;

public class PokemonView {
    
    private PokemonController controller;
private Scanner scanner;
public PokemonView(PokemonController controller) {
    this.controller = controller;
    this.scanner = new Scanner(System.in);
}

public void mostrarMenu() {
    int opcao;
    do {
        System.out.println("\n----- MENU POKÉMON -----");
        System.out.println("1. Adicionar Pokémon");
        System.out.println("2. Listar Pokémons");
        System.out.println("3. Atualizar nível do Pokémon");
        System.out.println("4. Remover Pokémon");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        scanner.nextLine(); // consumir quebra de linha

        switch (opcao) {
            case 1 -> adicionarPokemon();
            case 2 -> listarPokemons();
            case 3 -> atualizarNivel();
            case 4 -> removerPokemon();
            case 0 -> System.out.println("Encerrando...");
            default -> System.out.println("Opção inválida.");
        }
    } while (opcao != 0);
}

private void adicionarPokemon() {
    System.out.print("Digite o nome do Pokémon: ");
    String nome = scanner.nextLine();

    System.out.print("Digite o tipo (fogo/água): ");
    String tipo = scanner.nextLine().toLowerCase();

    System.out.print("Digite o nível: ");
    int nivel = scanner.nextInt();
    scanner.nextLine();

    Pokemon novo = null;
    if (tipo.equals("fogo")) {
        novo = new PokemonFogo(nome, nivel);
    } else if (tipo.equals("água") || tipo.equals("agua")) {
        novo = new PokemonAgua(nome, nivel);
    } else {
        System.out.println("Tipo inválido.");
        return;
    }

    controller.adicionarPokemon(novo);
}

private void listarPokemons() {
    List<Pokemon> lista = controller.listarPokemons();
    if (lista.isEmpty()) {
        System.out.println("Nenhum Pokémon cadastrado.");
    } else {
        System.out.println("Pokémons cadastrados:");
        for (Pokemon p : lista) {
            System.out.println("- " + p.getNome() + " | Nível: " + p.getNivel() + " | XP: " + p.getExperiencia());
        }
    }
}

private void atualizarNivel() {
    System.out.print("Digite o nome do Pokémon: ");
    String nome = scanner.nextLine();

    System.out.print("Novo nível: ");
    int novoNivel = scanner.nextInt();
    scanner.nextLine();

    boolean atualizado = controller.atualizarNivel(nome, novoNivel);
    if (atualizado) {
        System.out.println("Nível atualizado com sucesso.");
    } else {
        System.out.println("Pokémon não encontrado.");
    }
}

private void removerPokemon() {
    System.out.print("Digite o nome do Pokémon a remover: ");
    String nome = scanner.nextLine();

    boolean removido = controller.removerPokemon(nome);
    if (removido) {
        System.out.println("Pokémon removido.");
    } else {
        System.out.println("Pokémon não encontrado.");
    }
}
}
