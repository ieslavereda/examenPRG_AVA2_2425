import java.util.Map;
import java.util.TreeMap;

public class Libro extends Publicacion{
    private Map<Ejemplar,Boolean> ejemplaresDisponibles;

    public Libro(String titulo, String autor) {
        super(titulo,autor);
        ejemplaresDisponibles = new TreeMap<>();
    }

    public Libro(String titulo, String autor, Map<Ejemplar,Boolean> ejemplaresDisponibles) {
        super(titulo,autor);
        this.ejemplaresDisponibles=ejemplaresDisponibles;
    }

    public Map<Ejemplar, Boolean> getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    @Override
    public boolean prestar() {
        if (ejemplaresDisponibles.values().contains(true)) {
            for (Ejemplar ejemplar: ejemplaresDisponibles.keySet()){
                if(ejemplaresDisponibles.get(ejemplar)){
                    ejemplaresDisponibles.put(ejemplar,false);
                    if(!ejemplaresDisponibles.values().contains(true))
                        disponible=false;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean devolverEjemplar(Ejemplar ejemplar) {
        for (Ejemplar ejemplar1: ejemplaresDisponibles.keySet()){
            if(ejemplaresDisponibles.get(ejemplar)){
                ejemplaresDisponibles.put(ejemplar,false);
                return true;
            }
        }
        return false;
    }

    public void agregarEjemplar(Ejemplar ejemplar) {
        ejemplaresDisponibles.put(ejemplar,true);
    }

    public void borrarEjemplar(Ejemplar ejemplar) {
        ejemplaresDisponibles.remove(ejemplar);
    }

    @Override
    public String toString() {
        return super.toString() + " número de ejemplares disponibles= " + ejemplaresDisponibles.values().size();
    }

}