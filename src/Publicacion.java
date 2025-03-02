import java.util.Comparator;
import java.util.Objects;

public abstract class Publicacion implements Prestable, Comparable<Publicacion>{
    public static final Comparator<Publicacion> POR_AUTOR = new Comparator<Publicacion>() {
        @Override
        public int compare(Publicacion publicacion1, Publicacion publicacion2) {
            if(publicacion1.getAutor().equalsIgnoreCase(publicacion2.getAutor()))
                return publicacion1.getTitulo().compareToIgnoreCase(publicacion2.getTitulo());
            return publicacion1.getAutor().compareToIgnoreCase(publicacion2.getAutor());
        }
    };

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

    public boolean isDisponible() {
        return disponible;
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

    @Override
    public int compareTo(Publicacion publicacion){
        return publicacion.getTitulo().compareToIgnoreCase(titulo);
    }


}



