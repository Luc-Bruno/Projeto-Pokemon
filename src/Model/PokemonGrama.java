package Model;

public class PokemonGrama extends Pokemon{
    public PokemonGrama(String nome, int nivel) {
        super(nome,nivel);
    }

    @Override
public void atacar(Batalhavel oponente) {
    System.out.println(nome + " usou o seu mato kkkk contra " + oponente.getNome() + " !");
    ganharExperiencia(50);
}
}