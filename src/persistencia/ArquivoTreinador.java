package persistencia;

import Model.Treinador;

import java.io.*;
import java.util.ArrayList;

public class ArquivoTreinador {

    private static final String CAMINHO =  "treinadores.txt";

    public static void salvar(ArrayList<Treinador> treinadores){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO))){
            for(Treinador t : treinadores){
                bw.write(t.getNome() + ";" + t.getIdade());
                bw.newLine();
            }
        }catch(IOException e){
            System.out.println("Erro ao salvar Treinadores: " + e.getMessage());
        }
    }

    public static ArrayList<Treinador> carregar(){
        ArrayList<Treinador> lista = new ArrayList<>();

        File arquivoT = new File(CAMINHO);
        if (!arquivoT.exists()){
            return lista;
        }
        try(BufferedReader br = new BufferedReader(new FileReader(CAMINHO))){
            String linha;
            while((linha = br.readLine()) != null){
                String[] partes  = linha.split(";");
                if (partes.length ==2){
                    String nome = partes[0];
                    int idade = Integer.parseInt(partes[1]);
                    lista.add(new Treinador(nome, idade));
                }
            }
        }catch(IOException e){
            System.out.println("Erro ao ler Treinadores: " + e.getMessage());
        }
        return lista;
    }

}
