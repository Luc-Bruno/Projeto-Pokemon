package view;

import model.Pokemon;
import service.SistemaService;

import java.util.Scanner;

public class MenuPrincipal {

    private SistemaService sistema;
    private Scanner scanner;

    public MenuPrincipal(SistemaService sistema) {
        this.sistema = sistema;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Cadastrar Pokémon");
            System.out.println("2. Listar Pokémons");
            System.out.println("3. Batalhar");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPokemon();
                case 2 -> listarPokemons();
                case 3 -> fazerBatalha();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarPokemon() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.print("Nível: ");
        int nivel = scanner.nextInt();
        scanner.nextLine();

        Pokemon p = new Pokemon(nome, tipo, nivel);
        sistema.getPokemonService().adicionarPokemon(p);
        sistema.getPokemonService().salvarPokemons();
        System.out.println("Pokémon cadastrado!");
    }

    private void listarPokemons() {
        for (Pokemon p : sistema.getPokemonService().listarPokemons()) {
            System.out.println("- " + p.getNome() + " | Tipo: " + p.getTipo() + " | Nível: " + p.getNivel());
        }
    }

    private void fazerBatalha() {
        System.out.print("Nome do primeiro Pokémon: ");
        String nome1 = scanner.nextLine();
        Pokemon p1 = sistema.getPokemonService().buscarPokemonPorNome(nome1);

        System.out.print("Nome do segundo Pokémon: ");
        String nome2 = scanner.nextLine();
        Pokemon p2 = sistema.getPokemonService().buscarPokemonPorNome(nome2);

        if (p1 != null && p2 != null) {
            var b = sistema.getBatalhaService().realizarBatalha(p1, p2);
            sistema.getBatalhaService().salvarBatalhas();
            System.out.println("Resultado: " + b.getResultado());
        } else {
            System.out.println("Pokémon(s) não encontrado(s).");
        }
    }
}
