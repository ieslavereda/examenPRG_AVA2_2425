import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Biblioteca {
    private Set<Publicacion> catalogo;

    public Biblioteca() {
        catalogo = new HashSet<>();
    }

    public void agregarPublicacion(Publicacion publicacion) {
        catalogo.add(publicacion);
    }

    public boolean buscarPublicacion(Publicacion publicacion) {
        return catalogo.contains(publicacion);
    }

    public boolean borrarPublicacion(Publicacion publicacion) {
        return catalogo.remove(publicacion);
    }

    @Override
    public String toString() {
        String resultado = "";
        for (Publicacion publicacion : catalogo) {
            resultado += publicacion;
        }
        return resultado;
    }
}