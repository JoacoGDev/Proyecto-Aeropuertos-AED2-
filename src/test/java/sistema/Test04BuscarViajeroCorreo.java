package sistema;

import interfaz.Categoria;
import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test04BuscarViajeroCorreo {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(10);
    }

    @Test
    void buscarViajeroOk() {

        s.registrarViajero("1.913.689-5", "Adam", "Adam@ort.edu.uy", 25, Categoria.ESTANDAR);
        s.registrarViajero("1.914.689-5", "Guillermo", "guille@ort.edu.uy", 35, Categoria.ESTANDAR);


        retorno = s.buscarViajeroPorCorreo("guille@ort.edu.uy");
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(2, retorno.getValorInteger());
        assertEquals("1.914.689-5;Guillermo;guille@ort.edu.uy;35;Estándar", retorno.getValorString());
    }

    @Test
    void buscarViajeroError1() {
        retorno = s.buscarViajeroPorCorreo(null);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
        assertEquals(0, retorno.getValorInteger());
        assertEquals("Correo es null o vacio", retorno.getValorString());
    }


    @Test
    void buscarViajeroError2() {
        s.registrarViajero("1.914.689-5", "Guillermo", "guille@ort.edu.uy", 35, Categoria.ESTANDAR);
        retorno = s.buscarViajeroPorCorreo("guilleort.edu.uy");
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());
        assertEquals(0, retorno.getValorInteger());
        assertEquals("El formato de correo no es correcto", retorno.getValorString());
    }

    @Test
    void buscarViajeroError3() {
        s.registrarViajero("1.914.689-5", "Guillermo", "guille@ort.edu.uy", 35, Categoria.ESTANDAR);
        retorno = s.buscarViajeroPorCorreo("NoExiste@ort.edu.uy");
        assertEquals(Retorno.Resultado.ERROR_3, retorno.getResultado());
        assertEquals(0, retorno.getValorInteger());
        assertEquals("No existe un Viajero con ese Correo", retorno.getValorString());
    }
}
