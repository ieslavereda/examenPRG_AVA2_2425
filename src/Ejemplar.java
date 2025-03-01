import java.util.Objects;

public class Ejemplar extends Libro implements Comparable<Ejemplar> {
    private final int codigo;
    private static int secuencia;

    public Ejemplar(String titulo, String autor, Genero genero) {
        super(titulo, autor, genero);
        this.codigo = secuencia++;
    }

    public int getCodigo() {
        return codigo;
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
    public int compareTo(Ejemplar ejemplar) {
        return ejemplar.codigo - this.codigo;
    }

    @Override
    public String toString(){
        return "ejemplar código: " + codigo;
    }


}
