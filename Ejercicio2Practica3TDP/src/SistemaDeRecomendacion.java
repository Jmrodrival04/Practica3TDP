import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SistemaDeRecomendacion {

    private List<Libro> libros;
    private Map<String, Usuario> usuarios;

    public SistemaDeRecomendacion(List<Libro> libros, Map<String, Usuario> usuarios) {
        this.libros = libros;
        this.usuarios = usuarios;
    }

    public Libro libroConMejorMedia() {
        Libro mejorLibro = null;
        double mejorMedia = 0;

        for (Libro libro : libros) {
            double sumaCalificaciones = 0;
            int conteoCalificaciones = 0;
            for (Usuario usuario : usuarios.values()) {
                Integer calificacion = usuario.obtenerCalificaciones().get(libro.getId());
                if (calificacion != null) {
                    sumaCalificaciones += calificacion;
                    conteoCalificaciones++;
                }
            }
            double media = conteoCalificaciones > 0 ? sumaCalificaciones / conteoCalificaciones : 0;
            if (media > mejorMedia) {
                mejorMedia = media;
                mejorLibro = libro;
            }
        }
        return mejorLibro;
    }
}