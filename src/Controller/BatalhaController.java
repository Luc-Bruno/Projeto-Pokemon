package Controller;

import Model.Batalha;
import Model.Pokemon;
import service.BatalhaService;

import java.util.List;

public class BatalhaController {
    private final BatalhaService service = new BatalhaService();

    public void iniciarBatalha(Pokemon p1, Pokemon p2) {
        Batalha b = service.realizarBatalha(p1, p2);
        System.out.println(b.getResumo());
    }

    public void listarHistorico() {
        List<Batalha> historico = service.listarBatalhas();
        for (Batalha b : historico) {
            System.out.println(b.getResumo());
        }
    }

    public void remover(int idx) {
        if (service.removerBatalha(idx)) {
            System.out.println("Batalha removida e arquivo atualizado.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void atualizar(int idx, Pokemon p1, Pokemon p2) {
        Batalha nova = new Batalha(p1, p2);
        nova.batalhar();
        if (service.atualizarBatalha(idx, nova) != null) {
            System.out.println("Batalha atualizada.");
        } else {
            System.out.println("Índice inválido.");
        }
    }
}
