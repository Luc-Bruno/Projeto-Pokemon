// src/Model/PokemonFogo.java
package Model;

public class PokemonFogo extends Pokemon {
    public PokemonFogo(String nome, int nivel, Treinador treinador) {
        super(nome, nivel, Tipo.FOGO, treinador);
    }

    @Override
    public void usarHabilidade() {
    }

    @Override
    public void atacar(Batalhavel alvo) {
        System.out.println(getNome() + " usa Lança Chamas em " + ((Pokemon) alvo).getNome());
        ganharExperiencia(50);
    }
}

