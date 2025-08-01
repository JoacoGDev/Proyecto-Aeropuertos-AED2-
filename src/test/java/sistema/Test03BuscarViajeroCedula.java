
package sistema;

import interfaz.Categoria;
import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test03BuscarViajeroCedula {
    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(10);
    }

    @Test
    void buscarViajeroOk() {
        s.registrarViajero("1.914.689-5", "Guillermo", "guille@ort.edu.uy", 35, Categoria.ESTANDAR);
        retorno = s.buscarViajeroPorCedula("1.914.689-5");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(1, retorno.getValorInteger());
        assertEquals("1.914.689-5;Guillermo;guille@ort.edu.uy;35;Estándar", retorno.getValorString());
    }

    @Test
    void buscarViajeroError1() {
        retorno = s.buscarViajeroPorCedula(null);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
        assertEquals(0, retorno.getValorInteger());
        assertEquals("Cédula es null o vacía", retorno.getValorString());
    }


    @Test
    void buscarViajeroError2() {
        s.registrarViajero("1.914.689-5", "Guillermo", "guille@ort.edu.uy", 35, Categoria.ESTANDAR);
        retorno = s.buscarViajeroPorCedula("1914.689-5");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        assertEquals(0, retorno.getValorInteger());
        assertEquals("La cédula no tiene el formato adecuado", retorno.getValorString());
    }

    @Test
    void buscarViajeroError3() {
        s.registrarViajero("1.914.689-5", "Guillermo", "guille@ort.edu.uy", 35, Categoria.ESTANDAR);
        retorno = s.buscarViajeroPorCedula("1.916.689-5");
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
        assertEquals(0, retorno.getValorInteger());
        assertEquals("No existe un viajero con esa cédula", retorno.getValorString());
    }


}

