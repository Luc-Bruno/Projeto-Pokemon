package Controller;

import Model.Treinador;
import Model.TreinadorRepository;
import persistencia.ArquivoTreinador;

import java.util.ArrayList;

public class TreinadorController {
    private TreinadorRepository repositorioT = new TreinadorRepository();

    public TreinadorController(){
        ArrayList<Treinador> treinadores = ArquivoTreinador.carregar();
        for(Treinador t : treinadores){
            repositorioT.adcionarTrein(t);
        }
    }

    public void cadastrarTreinador(String nome, int idade){
        Treinador t = new Treinador(nome, idade);
        repositorioT.adcionarTrein(t);
        ArquivoTreinador.salvar(repositorioT.listarTreinador());
        System.out.println("Treinador cadastrado com sucesso!!");
    }

    public ArrayList<Treinador> listarTreinadores(){
        return repositorioT.listarTreinador();
    }

    public void removerTreinador(String nome){
        boolean sucesso = repositorioT.removerTreinador(nome);
        if (sucesso){
            ArquivoTreinador.salvar(repositorioT.listarTreinador());
            System.out.println("Treinador removido!!");
        }else{
            System.out.println("Treinador não encontrado!!");
        }
    }

    public Treinador buscarTreinador(String nome){
        return repositorioT.buscarPorNome(nome);
    }

    public void atualizarTreinador(String nomeAntigo, String novoNome, int novaIdade){
        Treinador treinador = repositorioT.buscarPorNome(nomeAntigo);
        if(treinador != null){
            treinador.setNome(novoNome);
            treinador.setIdade(novaIdade);
            ArquivoTreinador.salvar(repositorioT.listarTreinador());
            System.out.println("Treinador atualizado com sucesso!");
        }else{
            System.out.println("Treinador não encontrado !!");
        }

    }
}
