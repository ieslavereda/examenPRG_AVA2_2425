public class Revista extends Publicacion {
    private final int numeroEdicion;

    public Revista(String titulo, String autor, int numeroEdicion) {
        super(titulo, autor);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    @Override
    public String toString() {
        return super.toString() + " número de edición= " + numeroEdicion + " disponible? " + (disponible?"Sí ":"No ");
    }

}