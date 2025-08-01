package tads;

public class NodoSimple<T> {
	private T dato;
	private NodoSimple<T> sig;

	public NodoSimple(T dato, NodoSimple<T> sig) {
		this.dato = dato;
		this.sig = sig;
	}
	
	public NodoSimple(T dato) {
		this.dato = dato;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public NodoSimple<T> getSig() {
		return sig;
	}

	public void setSig(NodoSimple<T> sig) {
		this.sig = sig;
	}

	@Override
	public String toString() {
		return dato + "";
	}

}
