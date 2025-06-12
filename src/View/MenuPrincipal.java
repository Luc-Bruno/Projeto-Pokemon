package View;

import Controller.TreinadorController;
import Model.Treinador;
import service.SistemaService;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private final SistemaService sistema       = new SistemaService();
    private final TreinadorController tCtrl    = new TreinadorController();
    private final Scanner sc                   = new Scanner(System.in);

    public static void main(String[] args) {
        new MenuPrincipal().start();
    }

    public void start() {
        sistema.carregarTudo();
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1) Listar Treinadores");
            System.out.println("2) Adicionar Treinador");
            System.out.println("3) Sair");
            System.out.print("Opção: ");

            String opc = sc.nextLine().trim();
            switch (opc) {
                case "1" -> listarTreinadores();
                case "2" -> adicionarTreinador();
                case "3" -> {
                    sistema.salvarTudo();
                    System.out.println("Saindo... Até breve!");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void listarTreinadores() {
        List<Treinador> lista = tCtrl.listarTreinadores();
        if (lista.isEmpty()) {
            System.out.println("Nenhum treinador cadastrado.");
        } else {
            System.out.println("\nTreinadores cadastrados:");
            for (int i = 0; i < lista.size(); i++) {
                Treinador t = lista.get(i);
                System.out.printf("%d) %s | Idade: %d%n", i + 1, t.getNome(), t.getIdade());
            }
        }
    }

    private void adicionarTreinador() {
        System.out.print("Nome do treinador: ");
        String nome = sc.nextLine().trim();
        System.out.print("Idade do treinador: ");
        int idade;
        try {
            idade = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Idade inválida. Operação cancelada.");
            return;
        }
        tCtrl.cadastrarTreinador(nome, idade);
    }
}
