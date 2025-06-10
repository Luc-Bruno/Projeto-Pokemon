package Model;

public abstract class Pokemon implements Batalhavel {

protected String nome;
protected int nivel;
protected int experiencia;

    public Pokemon(String nome, int nivel) {
        this.nome = nome;
        this.nivel = nivel;
        this.experiencia = 0;
    }

    public void setNivel(int nivel) {
    this.nivel = nivel;
}

    public String getNome() {
        return nome;
    }
    public int getNivel(){
        return nivel;
    }

    public int getExperiencia(){
        return experiencia;
    }
    public void ganharExperiencia(int xp){
        this.experiencia+=xp;
        if (experiencia >=100){
            this.nivel++;
            this.experiencia=0;
            System.out.println(nome+" Subiu para o nivel: " +nivel+" !");
        }
    }
@Override
public abstract void atacar(Batalhavel oponente);


    }



