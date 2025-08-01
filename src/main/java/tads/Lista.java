package tads;

public interface Lista<T> extends Iterable<T> {

    public void insertarInicio(T dato);

    public void insertarFinal(T dato);

    public int largo();

    public boolean esVacia();

    public String serializar();
}
