package Model;

public class Batalha {
    private Treinador treinador1;
    private Treinador treinador2;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private String vencedor;

    public Batalha(Pokemon poke1, Pokemon poke2) {
        this.pokemon1 = poke1;
        this.pokemon2 = poke2;
        this.treinador1 = poke1.getTreinador();
        this.treinador2 = poke2.getTreinador();
        this.vencedor = null;
    }

    public void batalhar() {
        this.vencedor = RegrasBatalha.definirVencedor(pokemon1, pokemon2);
        if (vencedor.equals(treinador1.getNome())) {
            pokemon1.ganharExperiencia(20);
        } else {
            pokemon2.ganharExperiencia(20);
        }
    }

    public String getResumo() {
        return "Resultado da última batalha" + ": " + treinador1.getNome() + " vs " + treinador2.getNome() +
                " — Vencedor: " + vencedor;
    }

    public Treinador getTreinador1() {
        return treinador1;
    }

    public void setTreinador1(Treinador treinador1) {
        this.treinador1 = treinador1;
    }

    public Treinador getTreinador2() {
        return treinador2;
    }

    public void setTreinador2(Treinador treinador2) {
        this.treinador2 = treinador2;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }
}
