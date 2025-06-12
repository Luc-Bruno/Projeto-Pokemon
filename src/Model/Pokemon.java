// src/Model/Pokemon.java
package Model;

public abstract class Pokemon implements Batalhavel {
    private String nome;
    private int nivel;
    private Tipo tipo;
    private Treinador treinador;

    public Pokemon(String nome, int nivel, Tipo tipo, Treinador treinador) {
        this.nome = nome;
        this.nivel = nivel;
        this.tipo = tipo;
        this.treinador = treinador;
    }

    public String getNome() {
        return nome;
    }

    public int getNivel() {
        return nivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Treinador getTreinador() {
        return treinador;
    }

    public void ganharExperiencia(int pontos) {
        this.nivel += pontos;
    }

    public abstract void usarHabilidade();

    @Override
    public abstract void atacar(Batalhavel alvo);
}




