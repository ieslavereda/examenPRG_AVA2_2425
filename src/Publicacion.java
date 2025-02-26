public abstract class Publicacion implements Prestable{
    private String titulo;
    private String autor;
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
    public boolean prestar(){
        if(disponible)
            disponible=false;
        return true;
    }

    @Override
    public boolean devolver(){
        if(!disponible)
            disponible=true;
        return true;
    }

    @Override
    public String toString() {
        return "Publicacion{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", disponible=" + disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacion that = (Publicacion) o;
        return titulo.equals(that.titulo) && autor.equals(that.autor);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode()+autor.hashCode();
    }
}



