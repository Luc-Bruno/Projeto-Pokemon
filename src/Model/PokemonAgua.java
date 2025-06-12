// src/Model/PokemonAgua.java
package Model;

public class PokemonAgua extends Pokemon {
    public PokemonAgua(String nome, int nivel, Treinador treinador) {
        super(nome, nivel, Tipo.AGUA, treinador);
    }

    @Override
    public void usarHabilidade() {
        ganharExperiencia(10);
    }

    @Override
    public void atacar(Batalhavel alvo) {
        System.out.println(getNome() + " usa Jato de Água em " + ((Pokemon) alvo).getNome());
        ganharExperiencia(50);
    }
}
