package Model;

public class PokemonFogo extends Pokemon{
   public PokemonFogo(String nome, int nivel) {
        super(nome, nivel);
    }
    @Override
public void atacar(Batalhavel oponente) {
    System.out.println(nome + " lançou uma bola de fogo em " + oponente.getNome() + "!");
    ganharExperiencia(50);
}

}
