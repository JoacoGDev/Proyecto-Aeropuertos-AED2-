package tads;


public class ABB<T extends Comparable<T>> {

    private NodoBinario<T> raiz;
    private int cantRecorridas;
    private int cantElementos;


    public void agregar(T dato) {
        if (raiz == null) {
            raiz = new NodoBinario<>(dato);
            cantElementos++;
        } else {
            agregarRec(raiz, dato);
        }

    }

    private void agregarRec(NodoBinario<T> nodoBinario, T dato) {
        //Casos Base
        if (nodoBinario.getDato().compareTo(dato) < 0) {
            //derecha
            if (nodoBinario.getDer() == null) { //Puedo agregar?
                nodoBinario.setDer(new NodoBinario<>(dato));
                cantElementos++;
            } else {
                //llamar rec
                agregarRec(nodoBinario.getDer(), dato);


            }
        } else {
            //izquierda
            if (nodoBinario.getIzq() == null) { //Puedo agregar?
                nodoBinario.setIzq(new NodoBinario<>(dato));
                cantElementos++;
            } else {
                //llamar rec
                agregarRec(nodoBinario.getIzq(), dato);

            }

        }

    }
    public int obtenerCantElementos(){
        return cantElementos;
    }

    public T obtener(T dato) {
        cantRecorridas = 0;
        return obtenerRec(raiz, dato);
    }

    private T obtenerRec(NodoBinario<T> nodoBinario, T dato) {

        cantRecorridas++;

        if (nodoBinario == null) {
            return null;
        }

        if (nodoBinario.getDato().equals(dato)) { //comparar objetos
            return nodoBinario.getDato();
        }

        if (nodoBinario.getDato().compareTo(dato) < 0) {
            return obtenerRec(nodoBinario.getDer(), dato);
        } else {

            return obtenerRec(nodoBinario.getIzq(), dato);
        }
    }

    public int obtenerCantidadRecorridas() {
        return cantRecorridas;
    }

    public boolean existe(T dato) {

        return existeRec(raiz, dato);
    }

    private boolean existeRec(NodoBinario<T> nodoBinario, T dato) {

        if (nodoBinario == null) {
            return false;
        }

        if (nodoBinario.getDato().equals(dato)) { //comparar objetos
            return true;
        }

        if (nodoBinario.getDato().compareTo(dato) < 0) {
            return existeRec(nodoBinario.getDer(), dato);
        } else {

            return existeRec(nodoBinario.getIzq(), dato);
        }
    }


    public boolean existev2(T dato) {

        return existev2Rec(raiz, dato);

    }

    private boolean existev2Rec(NodoBinario<T> nodoBinario, T dato) {

        if (nodoBinario == null) {
            return false;
        }

        if (nodoBinario.getDato().equals(dato)) {
            return true;
        }

        if (nodoBinario.getDato().compareTo(dato) < 0) {

            return existev2Rec(nodoBinario.getDer(), dato);
        } else {

            return existev2Rec(nodoBinario.getIzq(), dato);
        }


    }
    public void mostrarCreciente() {
        mostrarCrecienteRec(raiz);
    }

    private void mostrarCrecienteRec(NodoBinario<T> nodoBinario) {
        if(nodoBinario != null){
            mostrarCrecienteRec(nodoBinario.getIzq());
            System.out.println(nodoBinario.getDato());
            mostrarCrecienteRec(nodoBinario.getDer());
        }
    }


    public void mostrarDecreciente() {
        mostrarDecrecienteRec(raiz);
    }

    private void mostrarDecrecienteRec(NodoBinario<T> nodoBinario) {
        if(nodoBinario != null){
            mostrarDecrecienteRec(nodoBinario.getDer());
            System.out.println(nodoBinario.getDato());
            mostrarDecrecienteRec(nodoBinario.getIzq());
        }
    }


    public Lista<T> aplanarCreciente() {
        Lista<T> aux = new ListaImp<>();
        return aplanarCrecienteRec(raiz, aux);

    }

    private Lista<T> aplanarCrecienteRec(NodoBinario<T> nodoBinario, Lista<T> aux) {

        if (nodoBinario != null) {
            aplanarCrecienteRec(nodoBinario.getDer(), aux); //Voy al Mayor
            aux.insertarInicio(nodoBinario.getDato()); // Agrego al Inicio
            aplanarCrecienteRec(nodoBinario.getIzq(), aux);//Voy al menor

        }

        return aux;
    }

    public Lista<T> aplanarDecreciente() {
        Lista<T> aux = new ListaImp<>();
        return aplanarDecrecienteRec(raiz, aux);

    }

    private Lista<T> aplanarDecrecienteRec(NodoBinario<T> nodoBinario, Lista<T> aux) {

        if (nodoBinario != null) {
            aplanarDecrecienteRec(nodoBinario.getIzq(), aux);
            aux.insertarInicio(nodoBinario.getDato());
            aplanarDecrecienteRec(nodoBinario.getDer(), aux);

        }

        return aux;
    }

    public void mostrarNivel(int nivel) {
        mostrarNivelRec(raiz, nivel, 0);
    }

    private void mostrarNivelRec(NodoBinario<T> nodoBinario, int nivel, int nivelActual) {
        if (nodoBinario != null) {
            if (nivel == nivelActual) {
                System.out.println(nodoBinario.getDato());
            } else { //Con el Else se corta la llamada para no seguir recorriendo niveles despues del buscado
                mostrarNivelRec(nodoBinario.getIzq(), nivel, nivelActual + 1);
                mostrarNivelRec(nodoBinario.getDer(), nivel, nivelActual + 1);
            }
        }
    }


}
