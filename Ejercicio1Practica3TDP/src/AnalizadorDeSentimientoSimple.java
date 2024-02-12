public class AnalizadorDeSentimientoSimple implements AnalizadorDeSentimiento {
    @Override
    public String analizarSentimiento(String texto) {

        double sentimiento = Math.random() * 2 - 1;
        if (sentimiento > 0.1) {
            return "positivo";
        } else if (sentimiento < -0.1) {
            return "negativo";
        } else {
            return "neutral";
        }
    }
}
