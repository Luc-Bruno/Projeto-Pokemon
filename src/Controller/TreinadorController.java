package Controller;

import Model.Treinador;
import Model.TreinadorRepository;

import java.util.ArrayList;

public class TreinadorController {
    private TreinadorRepository repositorioT = new TreinadorRepository();

    public void cadastrarTreinador(String nome, int idade){
        Treinador t = new Treinador(nome, idade);
        repositorioT.adcionarTrein(t);
        System.out.println("Treinador cadastrado com sucesso!!");
    }

    public ArrayList<Treinador> listarTreinadores(){
        return repositorioT.listarTreinador();
    }

    public void removerTreinador(String nome){
        boolean sucesso = repositorioT.removerTreinador(nome);
        if (sucesso){
            System.out.println("Treinador removido!!");
        }else{
            System.out.println("Treinador não encontrado!!");
        }
    }

    public Treinador buscarTreinador(String nome){
        return repositorioT.buscarPorNome(nome);
    }


}
