package sistema;

import interfaz.Retorno;
import interfaz.Sistema;
import interfaz.TipoVuelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test13ActualizarVuelo {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(5);
    }


    @Test
    public void ActualizarVueloError1() {

        retorno = s.actualizarVuelo("0", "1", "ABB3", 0, 0, 0, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

        retorno = s.actualizarVuelo("1", "2", "ABB4", -1, -1, -1, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());


    }

    @Test
    public void ActualizarVueloError2() {

        retorno = s.actualizarVuelo(null, "a", "b", 12, 2.12, 3, TipoVuelo.PRIVADO);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

        retorno = s.actualizarVuelo("null", "", "b", 12, 2.12, 3, TipoVuelo.PRIVADO);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

    }

    @Test
    public void ActualizarVueloError3() {

        s.registrarCiudad("1","Florianopolis");
        retorno = s.actualizarVuelo("0","1","ABB3",1,2,3, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());



    }

    @Test
    public void ActualizarVueloError4() {
        s.registrarCiudad("a", "NULL");

        retorno = s.actualizarVuelo("a","1","ABB3",1,2,3, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_4, retorno.getResultado());
    }

    @Test
    public void ActualizarVuelo5() {
        s.registrarCiudad("a", "NULL");
        s.registrarCiudad("b", "NULL");

        retorno = s.actualizarVuelo("a","b","ABB3",1,2,3, TipoVuelo.COMERCIAL);
        assertEquals(Retorno.Resultado.ERROR_5, retorno.getResultado());
    }

    @Test
    public void ActualizarVuelo6() {
        s.registrarCiudad("a", "a");
        s.registrarCiudad("b", "b");

        s.registrarConexion("a","b");

        retorno = s.actualizarVuelo("a","b","AED2",50,45,250,TipoVuelo.PRIVADO);
        assertEquals(Retorno.Resultado.ERROR_6, retorno.getResultado());
    }

}
