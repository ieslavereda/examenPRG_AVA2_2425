import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Libro extends Publicacion {
    private final Map<Ejemplar, Boolean> ejemplaresDisponibles;
    private final Genero genero;

    public Libro(String titulo, String autor, Genero genero) {
        super(titulo, autor);
        this.genero = genero;
        ejemplaresDisponibles = new TreeMap<>();
        disponible = false;
    }

    public Libro(String titulo, String autor, Genero genero, int ejemplares) {
        super(titulo, autor);
        this.genero = genero;
        ejemplaresDisponibles = new TreeMap<>();
        for (int i = 0; i < ejemplares; i++) {
            ejemplaresDisponibles.put(new Ejemplar(titulo, autor, genero), true);
        }
    }

    public Genero getGenero() {
        return genero;
    }

    public Map<Ejemplar, Boolean> getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    @Override
    public void prestar() {
        for (int i = 0; i < ejemplaresDisponibles.keySet().size(); i++) {
            prestarEjemplar();
        }
    }

    @Override
    public void devolver() {
        for (Ejemplar ejemplar : ejemplaresDisponibles.keySet()) {
            devolverEjemplar(ejemplar.getCodigo());
        }
    }

    public int prestarEjemplar() {
        if (ejemplaresDisponibles.containsValue(true)) {
            for (Ejemplar ejemplar : ejemplaresDisponibles.keySet()) {
                if (ejemplaresDisponibles.get(ejemplar)) {
                    ejemplaresDisponibles.put(ejemplar, false);
                    if (!ejemplaresDisponibles.containsValue(true))
                        disponible = false;
                    return ejemplar.getCodigo();
                }
            }
        }
        return -1;
    }

    public boolean devolverEjemplar(int codigo) {
        for (Ejemplar ejemplar : ejemplaresDisponibles.keySet()) {
            if (ejemplar.getCodigo() == codigo) {
                ejemplaresDisponibles.put(ejemplar, true);
                disponible = true;
                return true;
            }
        }
        return false;
    }

    public void agregarEjemplar() {
        ejemplaresDisponibles.put(new Ejemplar(getTitulo(), getAutor(), getGenero()), true);
        disponible = true;
    }

    public boolean borrarEjemplar(int codigo) {
        for (Ejemplar ejemplar : ejemplaresDisponibles.keySet()) {
            if (ejemplar.getCodigo() == codigo) {
                ejemplaresDisponibles.remove(ejemplar);
                if (!ejemplaresDisponibles.containsValue(true))
                    disponible = false;
                return true;
            }
        }
        return false;
    }

    public Set<Ejemplar> mostrarEjemplares() {
        return ejemplaresDisponibles.keySet();
    }

    @Override
    public String toString() {
        return super.toString() + " número de ejemplares= " + ejemplaresDisponibles.values().size();
    }

}