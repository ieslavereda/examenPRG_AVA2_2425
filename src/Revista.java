class Revista extends Publicacion {
    private int numeroEdicion;

    public Revista(String titulo, String autor, int numeroEdicion) {
        super(titulo, autor);
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public String toString() {
        return super.toString() + " número de edición= " + numeroEdicion + " disponible? " + (disponible?"Sí":"No");
    }

}