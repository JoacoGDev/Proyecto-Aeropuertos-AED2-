package tads;

import dominio.Ciudad;
import interfaz.Criterio;
import interfaz.TipoVuelo;
import interfaz.TipoVueloPermitido;

public class Grafo {

    //Definir atributos
    private int cantidad;
    private int tope;
    private Ciudad[] vertices;
    private Conexion[][] matAdj;

    public Grafo(int unaCantMax, boolean esDirijido) {
        cantidad = 0;
        tope = unaCantMax;
        vertices = new Ciudad[tope];
        matAdj = new Conexion[tope][tope];
        if (esDirijido) {
            for (int i = 0; i < tope; i++) {
                for (int j = 0; j < tope; j++) {

                    matAdj[i][j] = new Conexion();
                }
            }
        } else {
            for (int i = 0; i < tope; i++) {
                for (int j = i; j < tope; j++) {
                    Conexion aux = new Conexion();
                    matAdj[i][j] = aux;
                    matAdj[j][i] = aux;

                }
            }


        }
    }


    public boolean esLleno() {
        //Implementar...
        return cantidad == tope;
    }

    public boolean esVacio() {
        //Implementar...
        return cantidad == 0;
    }

    // PRE: !esLleno()
    private int obtenerPosLibre() {
        //Implementar...
        for (int i = 0; i < tope; i++) {
            if (vertices[i] == null) {
                return i;
            }

        }
        return -1;
    }

    private int obtenerPos(Ciudad vert) {
        //Implementar...
        for (int i = 0; i < tope; i++) {
            if (vert.equals(vertices[i])) {
                return i;
            }

        }
        return -1;
    }

    // PRE: !esLleno && !existeVertice
    public void agregarVertice(Ciudad vert) {
        //Implementar...
        int pos = obtenerPosLibre();
        vertices[pos] = vert;
        cantidad++;
    }

    // PRE: existeVertice
    public void borrarVertice(Ciudad vert) {
        //Implementar...
        int pos = obtenerPos(vert);
        vertices[pos] = null;
        cantidad--;
        for (int k = 0; k < tope; k++) {
            matAdj[pos][k].setExiste(false);
            matAdj[k][pos].setExiste(false);

        }


    }

    public boolean existeVertice(Ciudad vert) {
        //Implementar...
        return obtenerPos(vert) != -1;
    }

    // existeVertice(origen) && existeVertice(destino) && !existeArista
    public void agregarArista(Ciudad origen, Ciudad destino, int peso) {
        //Implementar...
        int posOrigen = obtenerPos(origen);
        int posDestino = obtenerPos(destino);
        matAdj[posOrigen][posDestino].setExiste(true);
        //matAdj[posOrigen][posDestino].setPeso(peso);

    }

    // existeVertice(origen) && existeVertice(destino)
    public boolean existeArista(Ciudad origen, Ciudad destino) {
        //Implementar...
        int posOrigen = obtenerPos(origen);
        int posDestino = obtenerPos(destino);

        return matAdj[posOrigen][posDestino].isExiste();
    }

    public Conexion obtenerArista(Ciudad origen, Ciudad destino) {
        //Implementar...
        int posOrigen = obtenerPos(origen);
        int posDestino = obtenerPos(destino);

        return matAdj[posOrigen][posDestino];
    }

    // existeVertice(origen) && existeVertice(destino) && existeArista
    public void borrarArista(Ciudad origen, Ciudad destino) {
        //Implementar...
        int posOrigen = obtenerPos(origen);
        int posDestino = obtenerPos(destino);
        matAdj[posOrigen][posDestino].setExiste(false);

    }

    public Lista<Ciudad> verticesAdyacentes(Ciudad vert) {
        Lista<Ciudad> retorno = new ListaImp<>();
        //Implementar...
        int pos = obtenerPos(vert);
        for (int j = 0; j < tope; j++) {
            if (matAdj[pos][j].isExiste()) {
                retorno.insertarInicio(vertices[j]);

            }

        }
        return retorno;
    }

    // Pre: existeVertice(vert)
    public Lista<Ciudad> verticesIncidentes(Ciudad vert) {
        Lista<Ciudad> retorno = new ListaImp<>();
        //Implementar...
        int pos = obtenerPos(vert);
        for (int i = 0; i < tope; i++) {
            if (matAdj[i][pos].isExiste()) {
                retorno.insertarInicio(vertices[i]);

            }

        }
        return retorno;
    }

    public void dfs(Ciudad vert) {
        int pos = obtenerPos(vert);
        boolean[] visitados = new boolean[tope];
        dfsRec(pos, visitados);
    }

    private void dfsRec(int pos, boolean[] visitados) {
        System.out.print(vertices[pos] + " ");
        visitados[pos] = true;
        for (int j = 0; j < tope; j++) {
            if (matAdj[pos][j].isExiste() && !visitados[j]) {
                dfsRec(j, visitados);

            }
        }

    }

    //Falta poner paquete de cola
    public void bfs(Ciudad vert) {
        int pos = obtenerPos(vert);
        boolean[] visitados = new boolean[tope];
        Cola<Integer> cola = new Cola<>();
        int inicio = obtenerPos(vert);
        cola.encolar(inicio);
        visitados[inicio] = true;

        while (!cola.esVacia()) {
            pos = cola.desencolar();
            System.out.print(vertices[pos] + " ");
            for (int j = 0; j < tope; j++) {
                if (matAdj[pos][j].isExiste() && !visitados[j]) {
                    cola.encolar(j);
                    visitados[j] = true;

                }
            }

        }
        System.out.println();

    }

    public void bfsV2(Ciudad vert) {
        //int pos = obtenerPos(vert);
        boolean[] visitados = new boolean[tope];

        System.out.println("Inicio BFS");

        Cola<Tupla> cola = new Cola<>();
        int inicio = obtenerPos(vert);
        cola.encolar(new Tupla(inicio, 0));
        visitados[inicio] = true;

        while (!cola.esVacia()) {

            Tupla aux = cola.desencolar();
            int pos = aux.getPos();
            int nivel = aux.getNivel();
            System.out.println(vertices[pos] + " - " + nivel);
            for (int j = 0; j < tope; j++) {

                if (matAdj[pos][j].isExiste() && !visitados[j]) {
                    cola.encolar(new Tupla(j, nivel + 1));
                    visitados[j] = true;
                }
            }

        }
        System.out.println("Final BFS");

    }


    public ABB<Ciudad> bfsV2Escalas2(Ciudad vert, int escalas) {

        boolean[] visitados = new boolean[tope];
        Cola<Tupla> cola = new Cola<>();

        int inicio = obtenerPos(vert);

        cola.encolar(new Tupla(inicio, 0));
        visitados[inicio] = true;

        ABB<Ciudad> ciudadesAlcanzables = new ABB<>();

        while (!cola.esVacia()) {
            Tupla aux = cola.desencolar();
            int pos = aux.getPos();
            int nivel = aux.getNivel();


            if (nivel <= escalas) {
                ciudadesAlcanzables.agregar(vertices[pos]);
            }

            if (nivel < escalas) {

                for (int j = 0; j < tope; j++) {
                    if (matAdj[pos][j].isExiste() && !visitados[j] && !matAdj[pos][j].getVuelos().aplanarCreciente().esVacia()) { //Verificar esta condición por si tiene vuelos o no
                        cola.encolar(new Tupla(j, nivel + 1));
                        visitados[j] = true;
                    }
                }
            }
        }

        return ciudadesAlcanzables;
    }


    public TuplaDijkstra dijkstra(Ciudad vOrigen, Ciudad vDestino, TipoVueloPermitido tipo, Criterio cri) {


        int posOrigen = obtenerPos(vOrigen);
        int posDestino = obtenerPos(vDestino);

        if (posOrigen == -1 || posDestino == -1) {
            return null;
        }

        //Definir e inicializar estructuras

        boolean[] visitados = new boolean[tope];
        double[] costos = new double[tope];
        Ciudad[] anterior = new Ciudad[tope];

        for (int i = 0; i < tope; i++) {
            costos[i] = Double.MAX_VALUE;
        }

        //Marcar el origen con costo cero

        costos[posOrigen] = 0;

        for (int i = 0; i < cantidad; i++) { //Loop por cantidad de vertices

            //obtener vertice ni visitado de menor costo(Si hay varios cualquiera)
            int pos = obtenerVericeNoVisitadoDeMenorCosto(visitados, costos);

            if (pos != -1) {
                //Visitarlo
                visitados[pos] = true;
                //Evaluar si tengo que actualizar el costo de los adyacentes NO VISITADOS
                for (int j = 0; j < tope; j++) {
                    if (matAdj[pos][j].isExiste() && !visitados[j] && !matAdj[pos][j].getVuelos().aplanarCreciente().esVacia()) {
                        //Evaluar si tengo que actualizar el costo
                        double nuevoCosto = costos[pos] + matAdj[pos][j].getVueloMenorCosto(tipo, cri);
                        if (nuevoCosto < costos[j] ) {
                            costos[j] = nuevoCosto;
                            anterior[j] = vertices[pos];

                        }
                    }
                }
            }
        }


        ListaImp<Ciudad> camino = generarCamino(anterior, vertices[posDestino]);
        return new TuplaDijkstra(camino, costos[posDestino]);
    }





    private ListaImp<Ciudad> generarCamino(Ciudad[] anteriores, Ciudad ciudadDestino) {
        ListaImp<Ciudad> camino = new ListaImp<>();
        Ciudad actual = ciudadDestino;

        while (actual != null) {
            camino.insertarInicio(actual);
            int pos = obtenerPos(actual);
            actual = anteriores[pos];
        }

        return camino;
    }


    private int obtenerVericeNoVisitadoDeMenorCosto(boolean[] visitados, double[] costos) {
        double min = Double.MAX_VALUE;
        int resp = -1;

        for (int i = 0; i < tope; i++) {
            if (costos[i] < min && !visitados[i]) {

                min = costos[i];
                resp = i;
            }

        }
        return resp;
    }


}
