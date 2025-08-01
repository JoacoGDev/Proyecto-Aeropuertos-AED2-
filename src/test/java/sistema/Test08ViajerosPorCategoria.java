package sistema;

import interfaz.Categoria;
import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test08ViajerosPorCategoria {
    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(10);
    }

    @Test
    void ListarViajerosPorCategoriaOk() {



        s.registrarViajero("1.909.689-5", "Maria", "Maria@ort.edu.uy", 25, Categoria.PLATINO);
        s.registrarViajero("1.910.679-5", "Pedro", "Pedro@ort.edu.uy", 25, Categoria.PLATINO);
        s.registrarViajero("1.911.659-5", "Juan", "Jaun@ort.edu.uy", 25, Categoria.PLATINO);

        s.registrarViajero("1.912.689-5", "Jose", "Jose@ort.edu.uy", 42, Categoria.FRECUENTE);
        s.registrarViajero("1.913.689-5", "Carlos", "Carlos@ort.edu.uy", 42, Categoria.FRECUENTE);
        s.registrarViajero("1.914.799-5", "Santos", "Santos@ort.edu.uy", 42, Categoria.FRECUENTE);

        s.registrarViajero("2.915.689-5", "Duki", "Duki@ort.edu.uy", 17, Categoria.ESTANDAR);
        s.registrarViajero("6.916.689-5", "Carlitos", "Carlitos@ort.edu.uy", 17, Categoria.ESTANDAR);
        s.registrarViajero("1.917.689-5", "Henry", "Henry@ort.edu.uy", 15, Categoria.ESTANDAR);


        retorno = s.listarViajerosPorCategoria(Categoria.FRECUENTE);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("1.912.689-5;Jose;Jose@ort.edu.uy;42;Frecuente|1.913.689-5;Carlos;Carlos@ort.edu.uy;42;Frecuente|1.914.799-5;Santos;Santos@ort.edu.uy;42;Frecuente", retorno.getValorString());


        retorno = s.listarViajerosPorCategoria(Categoria.PLATINO);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("1.909.689-5;Maria;Maria@ort.edu.uy;25;Platino|1.910.679-5;Pedro;Pedro@ort.edu.uy;25;Platino|1.911.659-5;Juan;Jaun@ort.edu.uy;25;Platino", retorno.getValorString());

        retorno = s.listarViajerosPorCategoria(Categoria.ESTANDAR);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals("1.917.689-5;Henry;Henry@ort.edu.uy;15;Estándar|2.915.689-5;Duki;Duki@ort.edu.uy;17;Estándar|6.916.689-5;Carlitos;Carlitos@ort.edu.uy;17;Estándar", retorno.getValorString());



    }
}
