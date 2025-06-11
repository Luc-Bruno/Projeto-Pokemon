import service.SistemaService;
import view.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        SistemaService sistema = new SistemaService();

        sistema.carregarTudo();

        MenuPrincipal menu = new MenuPrincipal(sistema);
        menu.exibirMenu();

        sistema.salvarTudo();
        System.out.println("Dados salvos. Até mais!");
    }
}
