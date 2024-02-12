public class Nodo {
    private int id;
    private double trafico;

    public Nodo(int id) {
        this.id = id;
        this.trafico = 0.0;
    }

    public int getId() {
        return id;
    }

    public double getTrafico() {
        return trafico;
    }

    public void setTrafico(double trafico) {
        this.trafico = trafico;
    }
}
