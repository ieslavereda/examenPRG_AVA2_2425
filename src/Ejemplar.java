import java.util.Objects;

public class Ejemplar extends Libro implements Comparable<Ejemplar>{
    private int codigo;
    private int anyoPublicacion;
    private static int secuencia;

    public Ejemplar(String titulo, String autor, int codigo, int anyoPublicacion) {
        super(titulo, autor);
        this.codigo = codigo;
        this.anyoPublicacion = anyoPublicacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getAnyoPublicacion() {
        return anyoPublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ejemplar ejemplar = (Ejemplar) o;
        return codigo == ejemplar.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codigo);
    }

    @Override
    public int compareTo(Ejemplar ejemplar){
        return ejemplar.codigo - this.codigo;
    }


}
