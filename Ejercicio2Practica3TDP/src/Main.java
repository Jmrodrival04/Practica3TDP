import java.util.*;

public class Main {

    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static List<Libro> libros = Arrays.asList(
            new Libro("1", "Libro A"),
            new Libro("2", "Libro B"),
            new Libro("3", "Libro C")
    );
    private static Scanner scanner = new Scanner(System.in);
    private static String mejorMedia;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenú Principal");
            System.out.println("1. Ingresar calificaciones");
            System.out.println("2. Ver recomendaciones");
            System.out.println("3. Ver medias de valoraciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarCalificaciones();
                    break;
                case 2:
                    verRecomendaciones();
                    break;
                case 3:
                    verMediasValoraciones();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void ingresarCalificaciones() {
        System.out.println("Ingrese su ID de usuario:");
        String usuarioId = scanner.nextLine();
        Usuario usuario = usuarios.getOrDefault(usuarioId, new Usuario(usuarioId));
        usuarios.put(usuarioId, usuario);

        System.out.println("Ingrese calificaciones para los libros (del 1 al 5). Ingrese -1 para finalizar.");
        for (Libro libro : libros) {
            System.out.println("Calificación para " + libro.getTitulo() + ": ");
            int calificacion = scanner.nextInt();
            if (calificacion == -1) {
                break;
            }
            usuario.agregarCalificacion(libro.getId(), calificacion);
        }
        scanner.nextLine(); 
    }

    private static void verRecomendaciones() {
        SistemaDeRecomendacion sistema = new SistemaDeRecomendacion(libros, usuarios);
        Libro recomendado = sistema.libroConMejorMedia();

        if (recomendado != null) {
            System.out.println("Libro recomendado basado en la mejor media de calificaciones:");
            System.out.println(recomendado.getTitulo());
        } else {
            System.out.println("No hay suficientes calificaciones para hacer una recomendación.");
        }
    }


    private static void verMediasValoraciones() {
        System.out.println("Medias de valoraciones por libro:");
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
            System.out.println(libro.getTitulo() + ": " + (media > 0 ? media : "Sin calificaciones"));
        }
    }
}
