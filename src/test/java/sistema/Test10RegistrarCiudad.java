package sistema;

import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test10RegistrarCiudad {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(5);
    }

    @Test
    void RegistrarCiudadOk() {
        s.registrarCiudad("1","Solymar");
        retorno = s.registrarCiudad("6","Atlantida");
        assertEquals(Retorno.Resultado.OK,retorno.getResultado());

    }

    @Test
    void RegistrarCiudadError1() {
        s.registrarCiudad("1","Solymar");
        s.registrarCiudad("2","Parque Soleado");
        s.registrarCiudad("3","Parque del Plata");
        s.registrarCiudad("4","Pinamar");
        s.registrarCiudad("5","Salinas");

        retorno = s.registrarCiudad("6","Atlantida");
        assertEquals(Retorno.Resultado.ERROR_1,retorno.getResultado());

    }

    @Test
    void RegistrarCiudadError2() {

        retorno = s.registrarCiudad("","Atlantida");
        assertEquals(Retorno.Resultado.ERROR_2,retorno.getResultado());

        retorno = s.registrarCiudad("1","");
        assertEquals(Retorno.Resultado.ERROR_2,retorno.getResultado());

        retorno = s.registrarCiudad("","");
        assertEquals(Retorno.Resultado.ERROR_2,retorno.getResultado());

    }

    @Test
    void RegistrarCiudadError3() {
        s.registrarCiudad("1","Solymar");

        retorno = s.registrarCiudad("1","Atlantida");
        assertEquals(Retorno.Resultado.ERROR_3,retorno.getResultado());

    }

}
