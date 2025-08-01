package sistema;

import interfaz.Retorno;
import interfaz.Sistema;
import interfaz.TipoVuelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test14CiudadesPorCantidadDeEscalas {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(5);
    }


    @Test
    public void CiudadPorCantidadDeEscalasOk() {


        s.registrarCiudad("CODA1", "MonteVerde");
        s.registrarCiudad("CODA2", "LagoAzul");
        s.registrarCiudad("CODA3", "RíoClaro");
        s.registrarCiudad("CODA4", "ValleSereno");
        s.registrarCiudad("CODA5", "PuertaSol");
        s.registrarCiudad("CODA6", "BosqueMístico");
        s.registrarCiudad("CODA7", "CostaBrava");
        s.registrarCiudad("CODA8", "SierraAlta");
        s.registrarCiudad("CODA9", "VientoNorte");
        s.registrarCiudad("CODA10", "PuebloEscondido");
        s.registrarCiudad("CODA11", "MarCeleste");
        s.registrarCiudad("CODA12", "ColinaDorada");
        s.registrarCiudad("CODA13", "FuenteCristal");
        s.registrarCiudad("CODA14", "EstrellaDelSur");
        s.registrarCiudad("CODA15", "BrisaSuave");
        s.registrarCiudad("CODA16", "SelvaProfunda");
        s.registrarCiudad("CODA17", "AuroraBoreal");
        s.registrarCiudad("CODA18", "CaminoReal");
        s.registrarCiudad("CODA19", "CascadaLuminosa");
        s.registrarCiudad("CODA20", "NubeAlta");
        s.registrarCiudad("CODA21", "HorizonteLejano");
        s.registrarCiudad("CODA22", "PuertoFirme");
        s.registrarCiudad("CODA23", "SolRadiante");

        //Distancia 1
        s.registrarConexion("CODA1", "CODA2");
        s.registrarVuelo("CODA1", "CODA2", "vueloA1", 4500, 300, 1400, TipoVuelo.COMERCIAL);

        s.registrarConexion("CODA1", "CODA16");
        s.registrarVuelo("CODA1", "CODA16", "vueloA2", 4600, 320, 1450, TipoVuelo.COMERCIAL);

        s.registrarConexion("CODA1", "CODA7");
        s.registrarVuelo("CODA1", "CODA7", "vueloA3", 4700, 330, 1500, TipoVuelo.COMERCIAL);

        s.registrarConexion("CODA1", "CODA6");
        s.registrarVuelo("CODA1", "CODA6", "vueloA4", 4800, 340, 1550, TipoVuelo.COMERCIAL);

        s.registrarConexion("CODA1", "CODA17");
        s.registrarVuelo("CODA1", "CODA17", "vueloA5", 4900, 350, 1600, TipoVuelo.COMERCIAL);

        s.registrarConexion("CODA1", "CODA5");
        s.registrarVuelo("CODA1", "CODA5", "vueloA6", 5000, 360, 1650, TipoVuelo.COMERCIAL);

        s.registrarConexion("CODA1", "CODA18");
        s.registrarVuelo("CODA1", "CODA18", "vueloA7", 5100, 370, 1700, TipoVuelo.COMERCIAL);

        s.registrarConexion("CODA1", "CODA4");
        s.registrarVuelo("CODA1", "CODA4", "vueloA8", 5200, 380, 1750, TipoVuelo.COMERCIAL);

        s.registrarConexion("CODA1", "CODA23");
        s.registrarVuelo("CODA1", "CODA23", "vueloA9", 5300, 390, 1800, TipoVuelo.COMERCIAL);

        s.registrarConexion("CODA1", "CODA3");
        s.registrarVuelo("CODA1", "CODA3", "vueloA10", 5400, 400, 1850, TipoVuelo.COMERCIAL);

        retorno = s.listadoCiudadesCantDeEscalas("CODA1", 0);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("CODA1;MonteVerde", retorno.getValorString());

        retorno = s.listadoCiudadesCantDeEscalas("CODA1", 1);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("CODA1;MonteVerde|CODA2;LagoAzul|CODA3;RíoClaro|CODA4;ValleSereno|CODA5;PuertaSol", retorno.getValorString());

        // Distancia 2
        s.registrarConexion("CODA16", "CODA21");
        s.registrarVuelo("CODA16", "CODA21", "vueloA11", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA2", "CODA8");
        s.registrarVuelo("CODA2", "CODA8", "vueloA12", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA2", "CODA9");
        s.registrarVuelo("CODA2", "CODA9", "vueloA13", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA3", "CODA10");
        s.registrarVuelo("CODA3", "CODA10", "vueloA14", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA4", "CODA11");
        s.registrarVuelo("CODA4", "CODA11", "vueloA15", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA4", "CODA12");
        s.registrarVuelo("CODA4", "CODA12", "vueloA16", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA18", "CODA19");
        s.registrarVuelo("CODA18", "CODA19", "vueloA17", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA5", "CODA20");
        s.registrarVuelo("CODA5", "CODA20", "vueloA18", 5000, 360, 1500, TipoVuelo.COMERCIAL);

        // Distancia 3
        s.registrarConexion("CODA8", "CODA13");
        s.registrarVuelo("CODA8", "CODA13", "vueloA19", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA9", "CODA14");
        s.registrarVuelo("CODA9", "CODA14", "vueloA20", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA10", "CODA15");
        s.registrarVuelo("CODA10", "CODA15", "vueloA21", 5000, 360, 1500, TipoVuelo.COMERCIAL);
        s.registrarConexion("CODA11", "CODA22");
        s.registrarVuelo("CODA11", "CODA22", "vueloA22", 5000, 360, 1500, TipoVuelo.COMERCIAL);

        retorno = s.listadoCiudadesCantDeEscalas("CODA1", 0);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("CODA1;MonteVerde", retorno.getValorString());

        retorno = s.listadoCiudadesCantDeEscalas("CODA1", 1);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("CODA1;MonteVerde|CODA2;LagoAzul|CODA3;RíoClaro|CODA4;ValleSereno|CODA5;PuertaSol", retorno.getValorString());

        retorno = s.listadoCiudadesCantDeEscalas("CODA1", 2);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("CODA1;MonteVerde|CODA2;LagoAzul|CODA3;RíoClaro|CODA4;ValleSereno|CODA5;PuertaSol", retorno.getValorString());

        retorno = s.listadoCiudadesCantDeEscalas("CODA1", 3);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("CODA1;MonteVerde|CODA2;LagoAzul|CODA3;RíoClaro|CODA4;ValleSereno|CODA5;PuertaSol", retorno.getValorString());

        retorno = s.listadoCiudadesCantDeEscalas("CODA1", 5);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("CODA1;MonteVerde|CODA2;LagoAzul|CODA3;RíoClaro|CODA4;ValleSereno|CODA5;PuertaSol", retorno.getValorString());
    }

    @Test
    public void CiudadPorCantidadDeEscalasOkError1(){
        retorno = s.listadoCiudadesCantDeEscalas("CODA1", -1);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

    }

    @Test
    public void CiudadPorCantidadDeEscalasOkError2(){
        retorno = s.listadoCiudadesCantDeEscalas("", 2);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.listadoCiudadesCantDeEscalas("  ", 2);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.listadoCiudadesCantDeEscalas(null, 2);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

    }

    @Test
    public void CiudadPorCantidadDeEscalasOkError3(){
        retorno = s.listadoCiudadesCantDeEscalas("CiudadOrigen", 2);
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
    }
}
