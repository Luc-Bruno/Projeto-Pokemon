package Model;

public class RegrasBatalha {

    public static String definirVencedor(Pokemon p1, Pokemon p2) {
        Tipo tipo1 = p1.getTipo();
        Tipo tipo2 = p2.getTipo();

        if ((tipo1 == Tipo.AGUA && tipo2 == Tipo.FOGO) ||
                (tipo1 == Tipo.FOGO && tipo2 == Tipo.PLANTA) ||
                (tipo1 == Tipo.PLANTA && tipo2 == Tipo.AGUA)) {
            return p1.getTreinador().getNome();
        } else if ((tipo2 == Tipo.AGUA && tipo1 == Tipo.FOGO) ||
                (tipo2 == Tipo.FOGO && tipo1 == Tipo.PLANTA) ||
                (tipo2 == Tipo.PLANTA && tipo1 == Tipo.AGUA)) {
            return p2.getTreinador().getNome();
        } else {

            return "Empate";
        }
    }
}

