import java.util.Objects;

public abstract class Publicacion implements Prestable{
    private final String titulo;
    private final String autor;
    protected boolean disponible;

    public Publicacion(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        disponible=true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public void prestar(){
        if(disponible)
            disponible=false;
    }

    @Override
    public void devolver(){
        if(!disponible)
            disponible=true;
    }

    @Override
    public String toString() {
        return "Título='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", disponible=" + disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion that = (Publicacion) o;
        return Objects.equals(titulo, that.titulo) && Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }
}



