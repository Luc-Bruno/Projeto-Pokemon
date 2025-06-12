package View;

import java.util.Scanner;

public class InputHelper {
    private Scanner sc = new Scanner(System.in);

    public String lerString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public int lerInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String linha = sc.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número inteiro.");
            }
        }
    }

    public double lerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String linha = sc.nextLine().trim();
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida, digite um número válido.");
            }
        }
    }
}
