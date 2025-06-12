package Controller;

public class ServicosAuxiliares {

    public static boolean nomeValido(String nome) {
        if (nome == null || nome.trim().isEmpty()) return false;
        for (char c: nome.toCharArray()) {
            if (!Character.isLetter(c)&& c != ' ') return false;
        }
        return true
    }

    public static boolean idadeValida(int idade) {
        return idade > 0 && idade < 100;
    }

    public static boolean nivelValido(int nivel) {
        return nivel >= 0 && nivel <= 100;
    }
}
