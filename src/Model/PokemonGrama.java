package Model;

public class PokemonGrama extends Pokemon {
    public PokemonGrama(String nome, int nivel, Treinador treinador) {
        super(nome, nivel, Tipo.PLANTA, treinador);
    }

    @Override
    public void usarHabilidade() {
        ganharExperiencia(10);
    }

    @Override
    public void atacar(Batalhavel alvo) {
        System.out.println(getNome() + " usa Folha Navalha em " + ((Pokemon) alvo).getNome());
        ganharExperiencia(50);
    }
}
