package tads;

import java.util.Iterator;

public class ListaImp<T> implements Lista<T> {

    protected NodoSimple<T> inicio;
    protected NodoSimple<T> ultimo;
    protected int largo;

    public ListaImp() {
        this.inicio = null;
        this.largo = 0;
    }

    @Override
    public void insertarInicio(T dato) {
        inicio = new NodoSimple<T>(dato, inicio);
        largo++;
    }

    @Override
    public void insertarFinal(T dato) {

        NodoSimple<T> aAgregar = new NodoSimple<>(dato);
        if (largo == 0) {
            inicio = aAgregar;
            ultimo = aAgregar;

        }else{
            ultimo.setSig(aAgregar);
            ultimo = aAgregar;


        }
        largo++;

    }

    @Override
    public int largo() {
        return largo;
    }

    @Override
    public boolean esVacia() {
        return largo == 0;
    }

    @Override
    public String serializar() {
        if (largo == 0) {
            return "";
        }
        if (largo == 1) {
            return inicio.getDato().toString();
        }
        StringBuilder respuesta = new StringBuilder();
        NodoSimple<T> aux = inicio;
        while (aux.getSig() != null) {
            respuesta.append(aux.getDato());
            respuesta.append("|");
            aux = aux.getSig();

        }
        respuesta.append(aux.getDato());

        return respuesta.toString();
    }

    public boolean isExiste(T dato) {
        NodoSimple<T> aux = inicio;
        while (aux != null) {
            if (aux.getDato().equals(dato)) {
                return true;
            }
            aux = aux.getSig();
        }
        return false;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private NodoSimple<T> aux = inicio;

            @Override
            public boolean hasNext() {
                return aux != null;
            }

            @Override
            public T next() {
                T dato = aux.getDato();
                aux = aux.getSig();
                return dato;
            }

            @Override
            public void remove() {
            }

        };
    }



}
