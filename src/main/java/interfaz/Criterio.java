package interfaz;

import java.util.Arrays;
import java.util.Objects;

public enum Criterio {


    MINUTOS(0, "Minutos"),
    DOLARES(1, "Dolares");


    private final int indice;
    private final String texto;

    Criterio(int indice, String texto) {
        this.indice = indice;
        this.texto = texto;
    }

    public int getIndice() {
        return indice;
    }

    public String getTexto() {
        return texto;
    }

    public static Criterio fromTexto(String texto) {
        return Arrays.stream(Criterio.values())
                .filter(a -> Objects.equals(a.texto, texto))
                .findFirst()
                .orElse(null);
    }

}
