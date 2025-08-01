package dominio;

import interfaz.Categoria;

import java.util.Objects;

public class Viajero implements Comparable<Viajero> {

    private String Cedula;
    private String Nombre;
    private String Correo;
    private int Edad;
    private Categoria Categoria;

    public Viajero(String cedula) {
        Cedula = cedula;
    }


    public Viajero(String cedula, String nombre, String correo, int edad, Categoria categoria) {
        Cedula = cedula;
        Nombre = nombre;
        Correo = correo;
        Edad = edad;
        Categoria = categoria;
    }


    public String getCedula() {
        return Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public int getEdad() {
        return Edad;
    }

    public Categoria getCategoria() {
        return Categoria;
    }

    @Override
    public int compareTo(Viajero o) {
        int cedula = Integer.parseInt(this.Cedula.replaceAll("\\D", ""));
        int cedulaComparar = Integer.parseInt(o.Cedula.replaceAll("\\D", ""));
        return Integer.compare(cedula,cedulaComparar);
    }

    @Override
    public String toString() {
        return Cedula + ";" + Nombre + ";" + Correo + ";" + Edad + ";" + Categoria.getTexto();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Viajero viajero = (Viajero) o;
        return Objects.equals(Cedula, viajero.Cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Cedula);
    }
}
