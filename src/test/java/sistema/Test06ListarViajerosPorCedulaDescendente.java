package sistema;

import interfaz.Categoria;
import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test06ListarViajerosPorCedulaDescendente {
    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(10);
    }

    @Test
    void ListarCedulaDescendenteOk() {

        s.registrarViajero("1.916.689-5", "Claudio", "claudio@ort.edu.uy", 20, Categoria.FRECUENTE);
        s.registrarViajero("1.922.689-5", "Pedro", "pedro@ort.edu.uy", 42, Categoria.FRECUENTE);
        s.registrarViajero("1.913.689-5", "Adam", "Adam@ort.edu.uy", 25, Categoria.ESTANDAR);
        s.registrarViajero("1.902.689-5", "Adrian", "adrian@ort.edu.uy", 35, Categoria.ESTANDAR);
        s.registrarViajero("1.912.689-5", "Jose", "Jose@ort.edu.uy", 15, Categoria.PLATINO);
        s.registrarViajero("1.910.689-5", "Lucas", "Lucas@ort.edu.uy", 45, Categoria.ESTANDAR);


        retorno = s.listarViajerosPorCedulaDescendente();
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("1.922.689-5;Pedro;pedro@ort.edu.uy;42;Frecuente|1.916.689-5;Claudio;claudio@ort.edu.uy;20;Frecuente|1.913.689-5;Adam;Adam@ort.edu.uy;25;Estándar|1.912.689-5;Jose;Jose@ort.edu.uy;15;Platino|1.910.689-5;Lucas;Lucas@ort.edu.uy;45;Estándar|1.902.689-5;Adrian;adrian@ort.edu.uy;35;Estándar", retorno.getValorString());
    }

}
