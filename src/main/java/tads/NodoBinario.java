package tads;

public class NodoBinario<T> {
    private T dato;
    private NodoBinario<T> izq;
    private NodoBinario<T> der;

    public NodoBinario(T dato) {
        this.dato = dato;
    }


    public NodoBinario(T dato, NodoBinario<T> izq, NodoBinario<T> der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }


    public T getDato() {
        return dato;
    }

    public NodoBinario<T> getIzq() {
        return izq;
    }

    public NodoBinario<T> getDer() {
        return der;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public void setIzq(NodoBinario<T> izq) {
        this.izq = izq;
    }

    public void setDer(NodoBinario<T> der) {
        this.der = der;
    }


}
