import java.util.*;

class Biblioteca {
    private final List<Publicacion> catalogo;

    public Biblioteca() {
        catalogo = new ArrayList<>();
    }

    public List<Publicacion> getCatalogo() {
        return catalogo;
    }

    public void agregarPublicacion(Publicacion publicacion) {
        catalogo.add(publicacion);
    }

    public Publicacion buscarPublicacion(Publicacion publicacion) {
        if(catalogo.contains(publicacion))
            return publicacion;
        return null;
    }

    public boolean borrarPublicacion(Publicacion publicacion) {
        return catalogo.remove(publicacion);
    }

    public List<Publicacion> catalogoOrdenado(){
        Collections.sort(catalogo);
        return catalogo;
    }

    @Override
    public String toString() {
        String resultado = "";
        for (Publicacion publicacion : catalogo) {
            resultado += publicacion + "\n";
        }
        return resultado;
    }
}