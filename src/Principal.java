public class Principal {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Revista nature1 = new Revista("Nature","científicos",202411);
        Revista nature2 = new Revista("Nature","científicos",202412);
        Revista nature3 = new Revista("Nature","científicos",202501);
        biblioteca.agregarPublicacion(nature1);
        biblioteca.agregarPublicacion(nature2);
        biblioteca.agregarPublicacion(nature3);
        biblioteca.buscarPublicacion(nature2).prestar();
        biblioteca.buscarPublicacion(nature2).devolver();
        System.out.println(biblioteca);

        Libro maquinaTiempo = new Libro("La máquina del tiempo", "Herbert George Wells", Genero.CIENCIA_FICCION,5);
        Libro montanyas = new Libro("En las montañas de la locura", "H.P. Lovecraft", Genero.CIENCIA_FICCION);
        biblioteca.agregarPublicacion(maquinaTiempo);
        biblioteca.agregarPublicacion(montanyas);
        System.out.println(biblioteca);

        montanyas.agregarEjemplar();
        System.out.println(biblioteca);

        System.out.println(maquinaTiempo.mostrarEjemplares());

        System.out.println("Ejemplar prestado: " + ((Libro)biblioteca.buscarPublicacion(maquinaTiempo)).prestarEjemplar());
        System.out.println("Ejemplar prestado: " + ((Libro)biblioteca.buscarPublicacion(maquinaTiempo)).prestarEjemplar());
        System.out.println("Ejemplar prestado: " + ((Libro)biblioteca.buscarPublicacion(maquinaTiempo)).prestarEjemplar());
        System.out.println("Ejemplar prestado: " + ((Libro)biblioteca.buscarPublicacion(maquinaTiempo)).prestarEjemplar());
        System.out.println("Se ha devuelto el ejemplar 5?: "+((Libro)biblioteca.buscarPublicacion(montanyas)).devolverEjemplar(5));

        System.out.println("Se ha devuelto el ejemplar 1? " + ((Libro)biblioteca.buscarPublicacion(maquinaTiempo)).devolverEjemplar(1));
        System.out.println("Se ha devuelto el ejemplar 3? " +((Libro)biblioteca.buscarPublicacion(montanyas)).devolverEjemplar(3));

        System.out.println(biblioteca);
        biblioteca.agregarPublicacion(new Libro("Java para aprobar","IES La Vereda",Genero.TECNICOS,2));
        biblioteca.agregarPublicacion(new Libro("El bolsón de higgs","Javier Santaolalla",Genero.DIVULGATIVOS));
        biblioteca.agregarPublicacion(new Libro("1984","George Orwell",Genero.DISTOPIA,10));

        CSVManager.guardarBibliotecaCSV("biblio1",biblioteca);
        System.out.println(biblioteca);

        Biblioteca biblioteca2 = CSVManager.cargarBibliotecaCSV("biblio1");
        biblioteca2.borrarPublicacion(nature1);
        ((Libro)biblioteca2.buscarPublicacion(maquinaTiempo)).borrarEjemplar(0);
        System.out.println(maquinaTiempo.mostrarEjemplares());
        System.out.println(biblioteca2);

    }
}
