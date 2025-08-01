package sistema;

import dominio.Ciudad;
import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test11RegistrarConexion {

    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(5);
    }



    @Test
    public void RegistrarConexionError1(){

        retorno = s.registrarConexion(null,null);
        assertEquals(Retorno.Resultado.ERROR_1,retorno.getResultado());

        retorno = s.registrarConexion("","");
        assertEquals(Retorno.Resultado.ERROR_1,retorno.getResultado());

        retorno = s.registrarConexion(null,"");
        assertEquals(Retorno.Resultado.ERROR_1,retorno.getResultado());

        retorno = s.registrarConexion("",null);
        assertEquals(Retorno.Resultado.ERROR_1,retorno.getResultado());

    };

    @Test
    public void RegistrarConexionError2(){
        s.registrarCiudad("a", "a");

        retorno = s.registrarConexion("2", "a");
        assertEquals(Retorno.Resultado.ERROR_2,retorno.getResultado());

    }

    @Test
    public void RegistrarConexionError3(){
        s.registrarCiudad("a", "a");

        retorno = s.registrarConexion("a", "2");
        assertEquals(Retorno.Resultado.ERROR_3,retorno.getResultado());

    }



    @Test
    public void RegistrarConexionError4(){



        s.registrarCiudad("1","a");
        s.registrarCiudad("2","b");

        s.registrarConexion("1","2");


        retorno = s.registrarConexion("1","2");
        assertEquals(Retorno.Resultado.ERROR_4,retorno.getResultado());



    };
}
