package tads;

import dominio.Ciudad;

public class TuplaDijkstra {
    private double costo;
    private ListaImp<Ciudad> camino;

    public TuplaDijkstra(ListaImp<Ciudad> camino, double costo) {
        this.camino = camino;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public ListaImp<Ciudad> getCamino() {
        return camino;
    }

    public void setCamino(ListaImp<Ciudad> camino) {
        this.camino = camino;
    }

    @Override
    public String toString() {
        return "TuplaDijkstra{" +
                "costo=" + costo +
                ", camino='" + camino + '\'' +
                '}';
    }
}
