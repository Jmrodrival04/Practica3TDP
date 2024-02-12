public class AnalisisDeRedesSociales {
    public static void main(String[] args) {
        AnalizadorDeSentimiento analizador = new AnalizadorDeSentimientoSimple();

        Publicacion[] publicaciones = {
                new Publicacion("¡Me encanta este día soleado!"),
                new Publicacion("Estoy triste por la noticia de hoy."),
                new Publicacion("Es un día cualquiera."),
        };

        for (Publicacion publicacion : publicaciones) {
            String sentimiento = analizador.analizarSentimiento(publicacion.getTexto());
            System.out.println("Publicación: " + publicacion.getTexto() + " - Sentimiento: " + sentimiento);
        }
    }
}
