package Controller;

public class ServicosAuxiliares {

    public static boolean nomeValido(String nome) {
        return nome != null && nome.matches("[A-Za-zÀ-ÿ\\s]+");
    }

    public static boolean idadeValida(int idade) {
        return idade > 0 && idade < 100;
    }

    public static boolean nivelValido(int nivel) {
        return nivel >= 0 && nivel <= 100;
    }
}
