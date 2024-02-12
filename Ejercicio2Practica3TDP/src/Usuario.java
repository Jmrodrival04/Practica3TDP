import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String id;
    private Map<String, Integer> calificaciones;


    public Usuario(String id) {
        this.id = id;
        this.calificaciones = new HashMap<>();
    }


    public void agregarCalificacion(String libroId, int calificacion) {
        calificaciones.put(libroId, calificacion);
    }


    public Map<String, Integer> obtenerCalificaciones() {
        return new HashMap<>(calificaciones);
    }


    public String getId() {
        return id;
    }
}
