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
            System.out.println("(4). Atualizar Treinador");
            System.out.println("(0). Sair");
            op = scan.nextInt();scan.nextLine();
            switch(op){
                case 1 -> cadastrarT();
                case 2 -> listarT();
                case 3 -> removerT();
                case 4 -> atualizarT();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!\nEscolha uma Opção Válida!!");
            }
        }while(op != 0);
    }

    public void cadastrarT(){
        String nome = lerNome();
        int idade = lerIdade();
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

    public void atualizarT(){
        System.out.print("Nome do treinador a atualizar: ");
        String nomeAntigo = scan.nextLine();

        System.out.println("Digite as novas informações: ");
        String novoNome = lerNome();
        int novaIdade = lerIdade();

        controleT.atualizarTreinador(nomeAntigo, novoNome, novaIdade);
    }

    private String lerNome(){
        String nome = "";
        boolean valido = false;

        while (!valido) {
            try{
                System.out.println("Digite o Nome com apenas Letras: ");
                nome = scan.nextLine().trim();

                if (nome.isEmpty()){
                    throw new IllegalArgumentException("O Nome não pode estar vazio.");
                }

                for(char c : nome.toCharArray()){
                    if (!Character.isLetter(c) && c != ' '){
                        throw new IllegalArgumentException("O nome deve conter apenas letras e espaços.");
                    }
                }
                valido = true;
            } catch (IllegalArgumentException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return  nome;
    }

    private int lerIdade(){
        int idade = -1;
        boolean valido = false;

        while(!valido){
            try{
                System.out.println("Digite a Idade entre (1 a 100): ");
                String entrada = scan.nextLine().trim();

                if (entrada.isEmpty()){
                    throw new IllegalArgumentException("A idade não pode estar vazia.");
                }
                idade = Integer.parseInt(entrada);

                if (idade < 1 || idade > 99){
                    throw new IllegalArgumentException("A idade deve estar entre 1 e 99 anos");
                }
                valido = true;
            }catch(NumberFormatException e){
                System.out.println("Erro: Digite apenas números.");
            }catch (IllegalArgumentException e ){
                System.out.println("Erro: " + e.getMessage());
            }
        }

        return idade;
    }

}
