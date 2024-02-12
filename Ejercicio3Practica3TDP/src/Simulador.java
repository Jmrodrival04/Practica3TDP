public class Simulador {
    public void simularRed(int nodos, double tasaDeTrafico) {
        Red red = new Red(nodos);
        for (Nodo nodo : red.getNodos()) {
            simularTrafico(nodo, tasaDeTrafico);
            System.out.println("Nodo: " + nodo.getId() + " - Tráfico: " + nodo.getTrafico());
        }
    }

    private void simularTrafico(Nodo nodo, double tasaDeTrafico) {

        nodo.setTrafico(Math.random() * tasaDeTrafico);
    }

    public static void main(String[] args) {
        Simulador simulador = new Simulador();
        simulador.simularRed(10, 0.5);
    }
}
