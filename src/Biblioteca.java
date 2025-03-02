import java.util.*;

class Biblioteca {
    private final Set<Publicacion> catalogo;

    public Biblioteca() {
        catalogo = new TreeSet<>();
    }

    public Set<Publicacion> getCatalogo() {
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

    public Collection<Publicacion> catalogoOrdenado(){
        List<Publicacion> listaCatalogo = new ArrayList<>(catalogo);
        listaCatalogo.sort(Publicacion.POR_AUTOR);
        return listaCatalogo;
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