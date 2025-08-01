package sistema;

import interfaz.Categoria;
import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test07ViajerosPorCorreoAscendente {
    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(10);
    }

    @Test
    void ListarCorreoAscendenteOk() {


        s.registrarViajero("1.911.689-5", "Lucas", "AALucas@ort.edu.uy", 15, Categoria.ESTANDAR);
        s.registrarViajero("1.910.689-5", "Maria", "BBMaria@ort.edu.uy", 25, Categoria.PLATINO);
        s.registrarViajero("1.915.689-5", "Jose", "CCJose@ort.edu.uy", 42, Categoria.FRECUENTE);
        s.registrarViajero("1.913.689-5", "Pedro", "DDPedro@ort.edu.uy", 17, Categoria.ESTANDAR);


        retorno = s.listarViajerosPorCorreoAscendente();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("1.911.689-5;Lucas;AALucas@ort.edu.uy;15;Estándar|1.910.689-5;Maria;BBMaria@ort.edu.uy;25;Platino|1.915.689-5;Jose;CCJose@ort.edu.uy;42;Frecuente|1.913.689-5;Pedro;DDPedro@ort.edu.uy;17;Estándar", retorno.getValorString());
    }
}
