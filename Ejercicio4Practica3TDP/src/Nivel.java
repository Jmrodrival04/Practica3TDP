import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Nivel {
    private int dificultad;
    private List<Desafio> desafios;

    public Nivel(int dificultad) {
        this.dificultad = dificultad;
        this.desafios = new ArrayList<>();
    }

    public void agregarDesafio(Desafio desafio) {
        desafios.add(desafio);
    }

    public List<Desafio> getDesafios() {
        return desafios;
    }

    public int getDificultad() {
        return dificultad;
    }
}
