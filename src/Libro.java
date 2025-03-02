import java.util.*;

public class Libro extends Publicacion {
    private final Map<Integer, Boolean> ejemplaresDisponibles;
    private static int secuencia;
    private final Genero genero;

    public Libro(String titulo, String autor, Genero genero, int ejemplares) {
        super(titulo, autor);
        this.genero = genero;
        ejemplaresDisponibles = new HashMap<>();
        for (int i = 0; i < ejemplares; i++) {
            ejemplaresDisponibles.put(secuencia++, true);
        }
        disponible = (ejemplares > 0);
    }

    public Genero getGenero() {
        return genero;
    }

    public Map<Integer, Boolean> getEjemplaresDisponibles() {
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
        for (Integer ejemplar : ejemplaresDisponibles.keySet()) {
            devolverEjemplar(ejemplar);
        }
    }

    public int prestarEjemplar() {
        if (ejemplaresDisponibles.containsValue(true)) {
            for (Integer ejemplar : ejemplaresDisponibles.keySet()) {
                if (ejemplaresDisponibles.get(ejemplar)) {
                    ejemplaresDisponibles.put(ejemplar, false);
                    if (!ejemplaresDisponibles.containsValue(true))
                        disponible = false;
                    return ejemplar;
                }
            }
        }
        return -1;
    }

    public boolean devolverEjemplar(int codigo) {
        for (Integer ejemplar : ejemplaresDisponibles.keySet()) {
            if (ejemplar == codigo) {
                ejemplaresDisponibles.put(ejemplar, true);
                disponible = true;
                return true;
            }
        }
        return false;
    }

    public void agregarEjemplar() {
        ejemplaresDisponibles.put(secuencia++, true);
        disponible = true;
    }

    public boolean borrarEjemplar(int codigo) {
        for (Integer ejemplar : ejemplaresDisponibles.keySet()) {
            if (ejemplar == codigo) {
                ejemplaresDisponibles.remove(ejemplar);
                if (!ejemplaresDisponibles.containsValue(true))
                    disponible = false;
                return true;
            }
        }
        return false;
    }

    public List<Integer> mostrarEjemplares() {
        List<Integer> lista = new ArrayList<>(ejemplaresDisponibles.keySet());
        lista.sort(new Comparator<>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        return lista;
    }

    @Override
    public String toString() {
        return super.toString() + " género= " + genero + " número de ejemplares= " + ejemplaresDisponibles.values().size();
    }

}