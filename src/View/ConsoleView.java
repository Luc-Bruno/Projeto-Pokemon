package View;

import java.util.List;
import View.helpers.InputHelper;
import Model.Treinador;
import Model.Pokemon;
import Model.Batalha;

public class ConsoleView {
    private InputHelper in = new InputHelper();

    public void exibirMenuPrincipal() {
        System.out.println("=== MENU PRINCIPAL ===");
        System.out.println("1 - Gerenciar Treinadores");
        System.out.println("2 - Gerenciar Pokémons");
        System.out.println("3 - Gerenciar Batalhas");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        return in.lerInt("Escolha uma opção: ");
    }

    public void mostrarMensagem(String msg) {
        System.out.println(msg);
    }

    public void mostrarErro(String erro) {
        System.err.println("Erro: " + erro);
    }

    public void chamarMenuTreinador(Runnable menuTreinador) {
        menuTreinador.run();
    }

    public void chamarMenuPokemon(Runnable menuPokemon) {
        menuPokemon.run();
    }

    public void chamarMenuBatalha(Runnable menuBatalha) {
        menuBatalha.run();
    }
}

