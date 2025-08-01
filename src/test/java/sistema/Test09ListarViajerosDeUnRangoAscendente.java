package sistema;

import interfaz.Categoria;
import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test09ListarViajerosDeUnRangoAscendente {
    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();

    @BeforeEach
    public void setUp() {
        s.inicializarSistema(10);
    }

    @Test
    void listarViajerosRangoError1() {

        retorno = s.listarViajerosDeUnRangoAscendente(-1);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());

    }

    @Test
    void listarViajerosRangoError2() {

        retorno = s.listarViajerosDeUnRangoAscendente(14);
        assertEquals(Retorno.Resultado.ERROR_2, retorno.getResultado());

    }



    @Test
    void listarViajerosRango0() {

        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 9, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 8, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 5, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(0);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;9;Estándar|2.912.689-5;Martin;Martin@correo.com;8;Platino|3.913.689-5;Eres;Eres@correo.com;5;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango1() {
        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 15, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 18, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 19, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(1);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;15;Estándar|2.912.689-5;Martin;Martin@correo.com;18;Platino|3.913.689-5;Eres;Eres@correo.com;19;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango2() {

        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 20, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 29, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 25, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(2);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;20;Estándar|2.912.689-5;Martin;Martin@correo.com;29;Platino|3.913.689-5;Eres;Eres@correo.com;25;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango3() {

        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 30, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 35, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 39, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(3);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;30;Estándar|2.912.689-5;Martin;Martin@correo.com;35;Platino|3.913.689-5;Eres;Eres@correo.com;39;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango4() {

        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 40, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 45, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 49, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(4);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;40;Estándar|2.912.689-5;Martin;Martin@correo.com;45;Platino|3.913.689-5;Eres;Eres@correo.com;49;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango5() {

        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 50, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 55, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 59, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(5);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;50;Estándar|2.912.689-5;Martin;Martin@correo.com;55;Platino|3.913.689-5;Eres;Eres@correo.com;59;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango6() {
        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 60, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 66, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 69, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(6);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;60;Estándar|2.912.689-5;Martin;Martin@correo.com;66;Platino|3.913.689-5;Eres;Eres@correo.com;69;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango7() {

        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 70, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 75, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 79, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(7);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;70;Estándar|2.912.689-5;Martin;Martin@correo.com;75;Platino|3.913.689-5;Eres;Eres@correo.com;79;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango8() {
        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 80, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 86, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 89, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(8);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;80;Estándar|2.912.689-5;Martin;Martin@correo.com;86;Platino|3.913.689-5;Eres;Eres@correo.com;89;Frecuente", retorno.getValorString()
        );
    }


    @Test
    void listarViajerosRango10() {

        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 100, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 105, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 109, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(10);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;100;Estándar|2.912.689-5;Martin;Martin@correo.com;105;Platino|3.913.689-5;Eres;Eres@correo.com;109;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango11() {

        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 110, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 115, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 119, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(11);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;110;Estándar|2.912.689-5;Martin;Martin@correo.com;115;Platino|3.913.689-5;Eres;Eres@correo.com;119;Frecuente", retorno.getValorString()
        );
    }


    @Test
    void listarViajerosRango12() {
        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 120, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 125, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 129, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(12);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;120;Estándar|2.912.689-5;Martin;Martin@correo.com;125;Platino|3.913.689-5;Eres;Eres@correo.com;129;Frecuente", retorno.getValorString()
        );
    }

    @Test
    void listarViajerosRango13() {
        s.registrarViajero("1.911.689-5", "Lucas", "lucas0@correo.com", 130, Categoria.ESTANDAR);
        s.registrarViajero("2.912.689-5", "Martin", "Martin@correo.com", 136, Categoria.PLATINO);
        s.registrarViajero("3.913.689-5", "Eres", "Eres@correo.com", 139, Categoria.FRECUENTE);


        retorno = s.listarViajerosDeUnRangoAscendente(13);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
        assertEquals(
                "1.911.689-5;Lucas;lucas0@correo.com;130;Estándar|2.912.689-5;Martin;Martin@correo.com;136;Platino|3.913.689-5;Eres;Eres@correo.com;139;Frecuente", retorno.getValorString()
        );
    }

}
