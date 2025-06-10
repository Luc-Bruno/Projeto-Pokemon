package Model;

public class PokemonAgua extends Pokemon{
    public PokemonAgua(String nome, int nivel) {
        super(nome,nivel);
    }

    @Override
public void atacar(Batalhavel oponente) {
    System.out.println(nome + " usou jato d’água contra " + oponente.getNome() + " !");
    ganharExperiencia(50);
}
}