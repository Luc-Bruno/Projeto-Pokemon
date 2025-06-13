package View;

import Controller.BatalhaController;
import Controller.PokemonController;
import Controller.TreinadorController;
import Model.Pokemon;
import Model.Treinador;
import Model.TreinadorRepository;
import Model.Tipo;
import service.SistemaService;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private final SistemaService sistema = new SistemaService();
    private final TreinadorController treinadorCtrl = new TreinadorController();
    private final PokemonController pokemonCtrl   = new PokemonController();
    private final BatalhaController batalhaCtrl   = new BatalhaController();
    private final Scanner             sc            = new Scanner(System.in);

    public static void main(String[] args) {
        new MenuPrincipal().start();
    }

    public void start() {
        sistema.carregarTudo();
        while (true) {
            exibirMenu();
            String opc = sc.nextLine().trim();
            switch (opc) {
                case "1":
                    treinadorCtrl.listarTreinadores();
                    break;

                case "2":
                    pokemonCtrl.listarPokemons();
                    break;

                case "3":
                    adicionarTreinador();
                    break;

                case "4":
                    adicionarPokemon();
                    break;

                case "5":
                    realizarBatalha();
                    break;

                case "6":
                    batalhaCtrl.listarHistorico();
                    break;

                case "7":
                    sistema.salvarTudo();
                    System.out.println("Saindo... Até mais!");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente de novo.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\n=== MENU PRINCIPAL ===");
        System.out.println("1) Listar Treinadores");
        System.out.println("2) Listar Pokémons");
        System.out.println("3) Adicionar Treinador");
        System.out.println("4) Adicionar Pokémon");
        System.out.println("5) Realizar Batalha");
        System.out.println("6) Histórico de Batalhas");
        System.out.println("7) Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void adicionarTreinador() {
        System.out.print("Nome do treinador: ");
        String nome = sc.nextLine().trim();
        treinadorCtrl.adicionarTreinador(nome);
    }

    private void adicionarPokemon() {
        System.out.print("Nome do treinador dono: ");
        String donoNome = sc.nextLine().trim();
        Treinador dono = TreinadorRepository.getOuCriar(donoNome);

        System.out.print("Nome do Pokémon: ");
        String pokeNome = sc.nextLine().trim();

        System.out.print("Tipo (FOGO, AGUA, PLANTA): ");
        String tipoStr = sc.nextLine().trim().toUpperCase();
        Tipo tipo;
        try {
            tipo = Tipo.valueOf(tipoStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo inválido, operação cancelada.");
            return;
        }

        System.out.print("Nível inicial: ");
        int nivel;
        try {
            nivel = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Nível inválido, operação cancelada.");
            return;
        }

        pokemonCtrl.adicionarPokemon(pokeNome, tipo, nivel, dono);
    }

    private void realizarBatalha() {
        List<Pokemon> lista = pokemonCtrl.getPokemons();
        if (lista.size() < 2) {
            System.out.println("Cadastre pelo menos 2 Pokémons para batalhar.");
            return;
        }
        System.out.println("Escolha índice do 1º Pokémon:");
        for (int i = 0; i < lista.size(); i++) {
            Pokemon p = lista.get(i);
            System.out.printf("%d) %s (%s)%n", i, p.getNome(), p.getTipo());
        }
        System.out.print("Índice 1: ");
        int idx1 = lerIndice(lista.size());
        if (idx1 < 0) return;

        System.out.print("Índice 2: ");
        int idx2 = lerIndice(lista.size());
        if (idx2 < 0) return;

        batalhaCtrl.iniciarBatalha(lista.get(idx1), lista.get(idx2));
    }

    private int lerIndice(int tamanho) {
        try {
            int idx = Integer.parseInt(sc.nextLine().trim());
            if (idx < 0 || idx >= tamanho) {
                System.out.println("Índice fora de intervalo.");
                return -1;
            }
            return idx;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida.");
            return -1;
        }
    }
}
