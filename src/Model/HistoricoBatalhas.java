package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoricoBatalhas {
    private List<Batalha> batalhas;

public HistoricoBatalhas() {
    batalhas = new ArrayList<>();
}

    public void adicionar(Batalha b) {
        batalhas.add(b);
    }

    public List<Batalha> listar() {
        return Collections.unmodifiableList(batalhas);
    }

    public boolean remover(int index) {
        if (index >= 0 && index < batalhas.size()) {
            batalhas.remove(index);
            return true;
        }
        return false;
    }

    public int total() {
        return batalhas.size();
    }
}