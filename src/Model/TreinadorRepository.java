package Model;

import java.util.ArrayList;

public class TreinadorRepository {
    private ArrayList<Treinador> treinadores = new ArrayList<>();


    public void adcionarTrein(Treinador t){
        treinadores.add(t);
    }

    public ArrayList<Treinador> listarTreinador(){
        return treinadores;
    }

    public Treinador buscarPorNome(String nome){
        for(Treinador t : treinadores){
            if (t.getNome().equalsIgnoreCase(nome)){
                return t;
            }
        }
        return null;
    }

    public boolean removerTreinador(String nome){
        Treinador t = buscarPorNome(nome);
        if (t != null){
            return treinadores.remove(t);
        }
        return false;
    }

}
