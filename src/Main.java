import Model.Pokemon;
import Model.PokemonFogo;
import Model.PokemonAgua;
import Model.PokemonGrama;
import Model.Treinador;
import Model.TreinadorRepository;
import Model.Tipo;
import Controller.BatalhaController;
import Controller.PokemonController;
import Controller.TreinadorController;
import service.SistemaService;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaService sistema = new SistemaService();
        sistema.carregarTudo();

        BatalhaController  batalhaCtrl  = new BatalhaController();
        PokemonController  pokemonCtrl  = new PokemonController();
        TreinadorController treinCtrl   = new TreinadorController();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1) Adicionar Treinador");
            System.out.println("2) Adicionar Pokémons");
            System.out.println("3) Listar Pokémon e Treinador");
            System.out.println("4) Realizar Batalha");
            System.out.println("5) Histórico de Batalhas");
            System.out.println("0) Sair");
            System.out.print("Opção: ");
            int opc = -1;
            try {
                opc = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, digite um número entre 0 e 5.");
                sc.nextLine();
                continue;
            }
            switch (opc) {
                case 1:
                    System.out.print("Nome do Treinador: ");
                    String tn = sc.nextLine().trim();
                    treinCtrl.adicionarTreinador(tn);
                    break;
                case 2:
                    try {
                        System.out.print("Nome do Treinador dono: ");
                        String dono = sc.nextLine().trim();
                        Treinador t = TreinadorRepository.getOuCriar(dono);

                        System.out.print("Nome do Pokémon: ");
                        String pn = sc.nextLine().trim();

                        System.out.print("Tipo (FOGO, AGUA, PLANTA): ");
                        String tipoStr = sc.nextLine().trim().toUpperCase();
                        Tipo tipo = Tipo.valueOf(tipoStr);

                        System.out.print("Nível inicial: ");
                        int nv = sc.nextInt();
                        sc.nextLine();

                        pokemonCtrl.adicionarPokemon(pn, tipo, nv, t);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo inválido! Use: FOGO, AGUA ou PLANTA.");
                    } catch (InputMismatchException e) {
                        System.out.println("Nível deve ser um número inteiro.");
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Erro ao adicionar Pokémon: " + e.getMessage());
                    }
                    break;

                case 3:
                    pokemonCtrl.listarPokemons();
                    break;
                case 4:
                    List<Pokemon> lista = pokemonCtrl.getPokemons();
                    if (lista.size() < 2) {
                        System.out.println("Precisa haver pelo menos 2 pokémons cadastrados.");
                        break;
                    }
                    System.out.println("Escolha índice do 1º Pokémon:");
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.printf("%d: %s (%s)%n", i, lista.get(i).getNome(), lista.get(i).getTipo());
                    }
                    int i1 = sc.nextInt();
                    System.out.println("Escolha índice do 2º Pokémon:");
                    int i2 = sc.nextInt();
                    sc.nextLine();
                    batalhaCtrl.iniciarBatalha(lista.get(i1), lista.get(i2));
                    break;
                case 5:
                    batalhaCtrl.listarHistorico();
                    break;
                case 0:
                    sistema.salvarTudo();
                    sc.close();
                    System.out.println("Saindo \uD83D\uDE33 \uD83D\uDC49\uD83D\uDC48... Até breve!");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
