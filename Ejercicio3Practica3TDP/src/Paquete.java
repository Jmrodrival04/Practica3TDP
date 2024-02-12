public class Paquete {
    private int id;
    private Nodo origen;
    private Nodo destino;

    public Paquete(int id, Nodo origen, Nodo destino) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
    }


    public int getId() {
        return id;
    }

    public Nodo getOrigen() {
        return origen;
    }

    public Nodo getDestino() {
        return destino;
    }
}
