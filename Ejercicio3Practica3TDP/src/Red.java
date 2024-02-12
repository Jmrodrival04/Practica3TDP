import java.util.ArrayList;
import java.util.List;

public class Red {
    private List<Nodo> nodos;

    public Red(int numeroDeNodos) {
        nodos = new ArrayList<>();
        for (int i = 0; i < numeroDeNodos; i++) {
            nodos.add(new Nodo(i));
        }
    }

    public List<Nodo> getNodos() {
        return nodos;
    }
}
