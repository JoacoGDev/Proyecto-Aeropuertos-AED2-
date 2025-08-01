package tads;

import dominio.Vuelo;
import interfaz.Criterio;
import interfaz.TipoVueloPermitido;

public class Conexion {

    private boolean existe;
    private ABB<Vuelo> vuelos = new ABB<>();

    public Conexion() {
        this.existe = false;

    }

    public Conexion(int unPeso) {
        this.existe = true;

    }

    public ABB<Vuelo> getVuelos() {
        return vuelos;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }


    public double getVueloMenorCosto(TipoVueloPermitido tipoVuelo, Criterio criterio) {

        if(criterio.getIndice() == 0){
            return vueloCostoMinimoMinutos(tipoVuelo);
        }
        return vueloCostoMinimoDolares(tipoVuelo);

    }

    private double vueloCostoMinimoMinutos(TipoVueloPermitido tipoVuelo) {

        Lista<Vuelo> vuelosBuscados = vuelos.aplanarCreciente();
        double menorCosto = Double.MAX_VALUE;
        boolean tipoValido = tipoVuelo.getIndice() == 2;

        for (Vuelo v : vuelosBuscados) {

            tipoValido = tipoValido || v.getTipoVuelo().getTexto().equals(tipoVuelo.getTexto());

            if (tipoValido && v.getMinutos() < menorCosto) {
                menorCosto = v.getMinutos();
            }
        }
        return menorCosto;
    }

    private double vueloCostoMinimoDolares(TipoVueloPermitido tipoVuelo) {
        Lista<Vuelo> vuelosBuscados = vuelos.aplanarCreciente();
        double menorCosto = Double.MAX_VALUE;

        boolean tipoValido = tipoVuelo.getIndice() == 2;

        for (Vuelo v : vuelosBuscados) {

            tipoValido = tipoValido || v.getTipoVuelo().getTexto().equals(tipoVuelo.getTexto());

            if (tipoValido && v.getCostoEnDolares() < menorCosto) {
                menorCosto = v.getCostoEnDolares();
            }
        }
        return menorCosto;
    }
}
