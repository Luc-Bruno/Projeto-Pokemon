package View;

import Controller.TreinadorController;
import Model.Treinador;

import java.util.ArrayList;
import java.util.Scanner;

public class TreinadorView {
    private Scanner scan = new Scanner(System.in);
    private TreinadorController controleT = new TreinadorController();

    public void menuT(){
        int op;
        do{
            System.out.println("---MENU TREINADOR---");
            System.out.println("(1). Cadastrar Treinador");
            System.out.println("(2). Listar Treinadores");
            System.out.println("(3). Remover Treinador");
            System.out.println("(0). Sair");
            op = scan.nextInt();scan.nextLine();
            switch(op){
                case 1 -> cadastrarT();
                case 2 -> listarT();
                case 3 -> removerT();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!\nEscolha uma Opção Válida!!");
            }
        }while(op != 0);
    }

    public void cadastrarT(){
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Idade: ");
        int idade = scan.nextInt();scan.nextLine();
        controleT.cadastrarTreinador(nome, idade);
    }

    public void listarT(){
        ArrayList<Treinador> treinadores = controleT.listarTreinadores();
        for (Treinador t : treinadores){
            System.out.println("Nome: " + t.getNome() + ", Idade: " + t.getIdade());
        }
    }

    public void removerT(){
        System.out.println("Nome do Treinador que deseja remover: ");
        String nome = scan.nextLine();
        controleT.removerTreinador(nome);
    }


}
