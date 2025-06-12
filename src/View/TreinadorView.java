// src/View/TreinadorView.java
package View;

import Controller.TreinadorController;
import Model.Treinador;

import java.util.List;
import java.util.Scanner;

public class TreinadorView {
    private final Scanner scan = new Scanner(System.in);
    private final TreinadorController controleT = new TreinadorController();

    public void menuT() {
        int op;
        do {
            System.out.println("\n--- MENU TREINADOR ---");
            System.out.println("1. Cadastrar Treinador");
            System.out.println("2. Listar Treinadores");
            System.out.println("3. Remover Treinador");
            System.out.println("4. Atualizar Treinador");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            op = Integer.parseInt(scan.nextLine());

            switch (op) {
                case 1 -> cadastrarT();
                case 2 -> listarT();
                case 3 -> removerT();
                case 4 -> atualizarT();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (op != 0);
    }

    private void cadastrarT() {
        String nome = lerNome();
        int idade   = lerIdade();
        controleT.cadastrarTreinador(nome, idade);
    }

    private void listarT() {
        List<Treinador> treinadores = controleT.listarTreinadores();
        if (treinadores.isEmpty()) {
            System.out.println("Nenhum treinador cadastrado.");
            return;
        }
        System.out.println("\nTreinadores cadastrados:");
        for (Treinador t : treinadores) {
            System.out.printf("- Nome: %s | Idade: %d%n", t.getNome(), t.getIdade());
        }
    }

    private void removerT() {
        System.out.print("Nome do treinador a remover: ");
        String nome = scan.nextLine().trim();
        controleT.removerTreinador(nome);
    }

    private void atualizarT() {
        System.out.print("Nome do treinador a atualizar: ");
        String nomeAntigo = scan.nextLine().trim();

        System.out.println("Digite os novos dados:");
        String novoNome = lerNome();
        int novaIdade   = lerIdade();

        controleT.atualizarTreinador(nomeAntigo, novoNome, novaIdade);
    }

    private String lerNome() {
        String nome;
        while (true) {
            System.out.print("Digite o nome (letras e espaços): ");
            nome = scan.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro: nome não pode ficar vazio.");
                continue;
            }
            boolean valido = nome.chars().allMatch(c -> Character.isLetter(c) || Character.isSpaceChar(c));
            if (valido) return nome;
            System.out.println("Erro: use apenas letras e espaços.");
        }
    }

    private int lerIdade() {
        while (true) {
            System.out.print("Digite a idade (1 a 99): ");
            String input = scan.nextLine().trim();
            try {
                int idade = Integer.parseInt(input);
                if (idade >= 1 && idade <= 99) return idade;
                System.out.println("Erro: idade deve estar entre 1 e 99.");
            } catch (NumberFormatException e) {
                System.out.println("Erro: digite apenas números válidos.");
            }
        }
    }
}
