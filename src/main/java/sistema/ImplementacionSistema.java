package sistema;

import dominio.Ciudad;
import dominio.Viajero;
import dominio.Vuelo;
import dominio.WrapperViajero;
import interfaz.*;
import tads.ABB;
import tads.Conexion;
import tads.Grafo;
import tads.TuplaDijkstra;

/*
Joaquin Gil– 322300
Mateo Gonzalez – 323444
*/

public class ImplementacionSistema implements Sistema {
    private int maxCiudades;

    //ABB para Ordenacion
    private ABB<Viajero> viajerosPorCedula;
    private ABB<WrapperViajero> viajerosPorCorreo;


    //ABB Para Categoria
    private ABB<Viajero> viajerosCategoriaPlatino;
    private ABB<Viajero> viajerosCategoriaFrecuente;
    private ABB<Viajero> viajerosCategoriaEstandar;

    //ABB para Rango de Edades
    private ABB<Viajero>[] rangos;


    //Grafo para Ciudades
    private Grafo ciudades;


    public ImplementacionSistema() {
        //Estructuras a utilizar
        //ABB Ordenacion
        viajerosPorCedula = new ABB<>();
        viajerosPorCorreo = new ABB<>();
        //ABB por Categoria
        viajerosCategoriaPlatino = new ABB<>();
        viajerosCategoriaFrecuente = new ABB<>();
        viajerosCategoriaEstandar = new ABB<>();
        //ABB por Rangos
        rangos = new ABB[14];
        //ABB Por Ciudad
        ciudades = new Grafo(maxCiudades, true);


    }

    @Override
    public Retorno inicializarSistema(int maxCiudades) {
        if (maxCiudades <= 4) {
            return Retorno.error1("");
        }
        this.maxCiudades = maxCiudades;
        //Acá se inicilizan todas las listas y estructuras necesarias para el funcionamiento del proyecto
        viajerosPorCedula = new ABB<>();
        viajerosPorCorreo = new ABB<>();

        for (int i = 0; i < 14; i++) {
            rangos[i] = new ABB<>();
        }


        viajerosCategoriaPlatino = new ABB<>();
        viajerosCategoriaFrecuente = new ABB<>();
        viajerosCategoriaEstandar = new ABB<>();


        ciudades = new Grafo(maxCiudades, true);

        return Retorno.ok();
    }

    @Override
    public Retorno registrarViajero(String cedula, String nombre, String correo, int edad, Categoria categoria) {

        if (cedula == null || cedula.trim().isEmpty() ||
                nombre == null || nombre.trim().isEmpty() ||
                correo == null || correo.trim().isEmpty() ||
                categoria == null) {

            return Retorno.error1("Parámetros inválidos: no pueden ser nulos, vacíos ni negativos.");
        }
        if (!cedula.matches("^(\\d{1}\\.\\d{3}\\.\\d{3}-\\d{1}|\\d{3}\\.\\d{3}-\\d{1})$")) {
            return Retorno.error2("El formato de Cédula no es correcto");
        }
        if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            return Retorno.error3("El formato de correo no es correcto");
        }
        if (edad < 0 || edad > 139) {
            return Retorno.error4("La edad no está dentro del rango válido");
        }

        Viajero viajeroNuevoCedula = new Viajero(cedula, nombre, correo, edad, categoria);
        WrapperViajero viajeroNuevoCorreo = new WrapperViajero(viajeroNuevoCedula);

        if (viajerosPorCedula.obtener(viajeroNuevoCedula) != null) {
            return Retorno.error5("Ya existe un viajero registrado con esa cédula.");
        }
        if (viajerosPorCorreo.obtener(viajeroNuevoCorreo) != null) {
            return Retorno.error6("Ya existe un viajero registrado con ese correo.");
        }


        viajerosPorCedula.agregar(viajeroNuevoCedula);
        viajerosPorCorreo.agregar(viajeroNuevoCorreo);

        //Agregar viajeros a ABB segun Categoria
        if (viajeroNuevoCedula.getCategoria().equals(Categoria.PLATINO)) {
            viajerosCategoriaPlatino.agregar(viajeroNuevoCedula);
        } else if (viajeroNuevoCedula.getCategoria().equals(Categoria.FRECUENTE)) {
            viajerosCategoriaFrecuente.agregar(viajeroNuevoCedula);
        } else {
            viajerosCategoriaEstandar.agregar(viajeroNuevoCedula);
        }


        int rango = edad / 10;

        rangos[rango].agregar(viajeroNuevoCedula);


        return Retorno.ok();
    }


    @Override
    public Retorno buscarViajeroPorCedula(String cedula) {

        //Retorno Error1
        if (cedula == null || cedula.trim().isEmpty()) {
            return Retorno.error1("Cédula es null o vacía");
        }
        //Retorno Error2
        if (!cedula.matches("^(\\d{1}\\.\\d{3}\\.\\d{3}-\\d{1}|\\d{3}\\.\\d{3}-\\d{1})$")) {
            return Retorno.error2("La cédula no tiene el formato adecuado");
        }

        //Retorno Error3
        Viajero nuevoViajeroABuscar = new Viajero(cedula);
        Viajero viajeroEncontrado = viajerosPorCedula.obtener(nuevoViajeroABuscar);
        if (viajeroEncontrado == null) {
            return Retorno.error3("No existe un viajero con esa cédula");
        }

        //Retorno Ok

        return Retorno.ok(viajerosPorCedula.obtenerCantidadRecorridas(), viajeroEncontrado.toString());
    }


    @Override
    public Retorno buscarViajeroPorCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {

            return Retorno.error1("Correo es null o vacio");
        }
        if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            return Retorno.error2("El formato de correo no es correcto");
        }
        WrapperViajero viajeroBuscado = new WrapperViajero(new Viajero(null, null, correo, 0, null));
        WrapperViajero resultado = viajerosPorCorreo.obtener(viajeroBuscado);

        if (resultado == null) {
            return Retorno.error3("No existe un Viajero con ese Correo");
        }


        return Retorno.ok(viajerosPorCorreo.obtenerCantidadRecorridas(), resultado.toString());
    }

    @Override
    public Retorno listarViajerosPorCedulaAscendente() {

        return Retorno.ok(viajerosPorCedula.aplanarCreciente().serializar());

    }

    @Override
    public Retorno listarViajerosPorCedulaDescendente() {
        return Retorno.ok(viajerosPorCedula.aplanarDecreciente().serializar());
    }

    @Override
    public Retorno listarViajerosPorCorreoAscendente() {
        return Retorno.ok(viajerosPorCorreo.aplanarCreciente().serializar());
    }

    @Override
    public Retorno listarViajerosPorCategoria(Categoria unaCategoria) {
        //Usar Array para poner los ABB dentro
        if (unaCategoria.equals(Categoria.PLATINO)) {

            return Retorno.ok(viajerosCategoriaPlatino.aplanarCreciente().serializar());

        } else if (unaCategoria.equals(Categoria.FRECUENTE)) {

            return Retorno.ok(viajerosCategoriaFrecuente.aplanarCreciente().serializar());

        } else {
            return Retorno.ok(viajerosCategoriaEstandar.aplanarCreciente().serializar());
        }
    }

    @Override
    public Retorno listarViajerosDeUnRangoAscendente(int rango) {

        if (rango < 0) {
            return Retorno.error1("El rango no puede ser menor a 0");
        }
        if (rango > 13) {
            return Retorno.error2("El rango no puede ser mayor a 13");
        }

        return Retorno.ok(rangos[rango].aplanarCreciente().serializar());

    }


    @Override
    public Retorno registrarCiudad(String codigo, String nombre) {

        if (ciudades.esLleno()) {
            return Retorno.error1("Ya hay la cantidad maxima de ciudades registradas");
        }

        if (codigo == null  || codigo.trim().isEmpty()|| nombre == null || nombre.trim().isEmpty() ) {
            return Retorno.error2("Codigo y nombre no pueden ser null");
        }

        Ciudad ciudadABuscar = new Ciudad(codigo, nombre);
        if (ciudades.existeVertice(ciudadABuscar)) {
            return Retorno.error3("Ya existe una ciudad con ese codigo");

        } else {
            ciudades.agregarVertice(ciudadABuscar);
            return Retorno.ok();
        }


    }

    @Override
    public Retorno registrarConexion(String codigoCiudadOrigen, String codigoCiudadDestino) {

        if (codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty() || codigoCiudadDestino == null || codigoCiudadDestino.trim().isEmpty()) {
            return Retorno.error1("Los códido de ciudad no pueden ser null");
        }

        Ciudad origen = new Ciudad(codigoCiudadOrigen, null);
        Ciudad destino = new Ciudad(codigoCiudadDestino, null);

        if (!ciudades.existeVertice(origen)) {
            return Retorno.error2("Esa ciudad no existe");
        }

        if (!ciudades.existeVertice(destino)) {
            return Retorno.error3("No existe ciudad destino");
        }

        if (ciudades.existeArista(origen, destino)) {
            return Retorno.error4("Ya existe una conexion entre las ciudades");

        }

        ciudades.agregarArista(origen, destino, 0);
        return Retorno.ok("Registro Exitoso");

    }

    @Override
    public Retorno registrarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        if (combustible <= 0 || minutos <= 0 || costoEnDolares <= 0) {
            return Retorno.error1("Combustible,minutos y costo en dolares no pueden ser negativos o 0");

        }

        if (codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty() ||
                codigoCiudadDestino == null || codigoCiudadDestino.trim().isEmpty() ||
                codigoDeVuelo == null || codigoDeVuelo.trim().isEmpty() || tipoDeVuelo == null) {
            return Retorno.error2("Los códigos no puede ser null ni vacíos");
        }


        if (!ciudades.existeVertice(new Ciudad(codigoCiudadOrigen, ""))) {

            return Retorno.error3("No Existe la ciudad Origen");

        }

        if (!ciudades.existeVertice(new Ciudad(codigoCiudadDestino, ""))) {
            return Retorno.error4("No Existe la ciudad Origen");
        }

        if (!ciudades.existeArista(new Ciudad(codigoCiudadOrigen, ""), new Ciudad(codigoCiudadDestino, ""))) {
            return Retorno.error5("No existe una conexión de origen y destino entre esas ciudades");
        }

        Conexion arista = ciudades.obtenerArista(new Ciudad(codigoCiudadOrigen, ""), new Ciudad(codigoCiudadDestino, ""));
        Vuelo vuelo = new Vuelo(codigoCiudadOrigen, codigoCiudadDestino, codigoDeVuelo, combustible, minutos, costoEnDolares, tipoDeVuelo);
        if (arista.getVuelos().existe(vuelo)) {
            return Retorno.error6("Ya existe un vuelo en esta conexion");

        } else {
            arista.getVuelos().agregar(vuelo);
            return Retorno.ok();
        }


    }

    @Override
    public Retorno actualizarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        if (combustible <= 0 || minutos <= 0 || costoEnDolares <= 0) {
            return Retorno.error1("Combustible,minutos y costo en dolares no pueden ser negativos o 0");

        }
        if (codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty() ||
                codigoCiudadDestino == null || codigoCiudadDestino.trim().isEmpty() ||
                codigoDeVuelo == null || codigoDeVuelo.trim().isEmpty() || tipoDeVuelo == null) {
            return Retorno.error2("Los códigos no puede ser null ni vacíos");
        }
        if (!ciudades.existeVertice(new Ciudad(codigoCiudadOrigen, ""))) {

            return Retorno.error3("No Existe la ciudad Origen");

        }

        if (!ciudades.existeVertice(new Ciudad(codigoCiudadDestino, ""))) {
            return Retorno.error4("No Existe la ciudad Origen");
        }

        if (!ciudades.existeArista(new Ciudad(codigoCiudadOrigen, ""), new Ciudad(codigoCiudadDestino, ""))) {
            return Retorno.error5("No existe una conexión de origen y destino entre esas ciudades");
        }

        Conexion arista = ciudades.obtenerArista(new Ciudad(codigoCiudadOrigen, ""), new Ciudad(codigoCiudadDestino, ""));
        Vuelo vuelo = new Vuelo(codigoCiudadOrigen, codigoCiudadDestino, codigoDeVuelo, combustible, minutos, costoEnDolares, tipoDeVuelo);
        if (!arista.getVuelos().existe(vuelo)) {
            return Retorno.error6("No existe un vuelo con ese codigo en esta conexion");

        } else {
            Vuelo vueloACambiar = arista.getVuelos().obtener(vuelo);
            vueloACambiar.actualizarVuelo(combustible, minutos, costoEnDolares, tipoDeVuelo);
            return Retorno.ok();
        }
    }

    @Override
    public Retorno listadoCiudadesCantDeEscalas(String codigoCiudadOrigen, int cantidad) {
        if (cantidad < 0) {
            return Retorno.error1("Cantidad es menor que 0");

        }

        if (codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty()) {
            return Retorno.error2("Parámetros en blanco o nulos");
        }

        Ciudad ciudad = new Ciudad(codigoCiudadOrigen, null);
        if (!ciudades.existeVertice(ciudad)) {

            return Retorno.error3("La ciudad no existe");
        }

        return Retorno.ok(ciudades.bfsV2Escalas2(ciudad, cantidad).aplanarCreciente().serializar());
    }

    @Override
    public Retorno viajeCostoMinimoMinutos(String codigoCiudadOrigen, String codigoCiudadDestino, TipoVueloPermitido tipoVueloPermitido) {

        if (codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty() ||
                codigoCiudadDestino == null || codigoCiudadDestino.trim().isEmpty() ||
                tipoVueloPermitido == null ) {
            return Retorno.error1("Los datos no puede ser null ni vacíos");
        }
        if (!ciudades.existeVertice(new Ciudad(codigoCiudadOrigen, ""))) {

            return Retorno.error2("No Existe la ciudad Origen");

        }

        if (!ciudades.existeVertice(new Ciudad(codigoCiudadDestino, ""))) {

            return Retorno.error3("No Existe la ciudad Origen");

        }



        Ciudad ciudadOrigen = new Ciudad(codigoCiudadOrigen, null);
        Ciudad ciudadDes = new Ciudad(codigoCiudadDestino,null);
        TuplaDijkstra tupla = ciudades.dijkstra(ciudadOrigen,ciudadDes,tipoVueloPermitido,Criterio.MINUTOS);


        if (!tupla.getCamino().isExiste((new Ciudad(codigoCiudadOrigen, "")))) {
            return Retorno.error4("No Existe la ciudad Origen");
        }

        return Retorno.ok((int)tupla.getCosto(),tupla.getCamino().serializar());

    }

    @Override
    public Retorno viajeCostoMinimoDolares(String codigoCiudadOrigen, String codigoCiudadDestino, TipoVueloPermitido tipoVueloPermitido) {

        if (codigoCiudadOrigen == null || codigoCiudadOrigen.trim().isEmpty() ||
                codigoCiudadDestino == null || codigoCiudadDestino.trim().isEmpty() ||
                tipoVueloPermitido == null ) {
            return Retorno.error1("Los datos no puede ser null ni vacíos");
        }
        if (!ciudades.existeVertice(new Ciudad(codigoCiudadOrigen, ""))) {

            return Retorno.error2("No Existe la ciudad Origen");

        }

        if (!ciudades.existeVertice(new Ciudad(codigoCiudadDestino, ""))) {
            return Retorno.error3("No Existe la ciudad Origen");
        }



        Ciudad ciudadOrigen = new Ciudad(codigoCiudadOrigen, null);
        Ciudad ciudadDes = new Ciudad(codigoCiudadDestino,null);
        TuplaDijkstra tupla = ciudades.dijkstra(ciudadOrigen,ciudadDes,tipoVueloPermitido,Criterio.DOLARES);


        if (!tupla.getCamino().isExiste((new Ciudad(codigoCiudadOrigen, "")))) {
            return Retorno.error4("No Existe la ciudad Origen");
        }

        return Retorno.ok((int)tupla.getCosto(),tupla.getCamino().serializar());

    }

}
