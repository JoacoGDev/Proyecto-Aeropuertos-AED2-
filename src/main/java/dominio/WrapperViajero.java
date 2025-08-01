package dominio;

import interfaz.Categoria;

import java.util.Objects;

public class WrapperViajero implements Comparable<WrapperViajero> {

    private Viajero viajero;

    public WrapperViajero(Viajero viajero) {
        this.viajero = viajero;
    }


    public Viajero getViajero() {
        return viajero;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WrapperViajero that = (WrapperViajero) o;
        return Objects.equals(viajero.getCorreo(), that.viajero.getCorreo());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(viajero);
    }

    @Override
    public int compareTo(WrapperViajero o) {

        return this.viajero.getCorreo().compareTo(o.getViajero().getCorreo());
    }

    @Override
    public String toString() {
        return viajero.toString();
    }
}
