public class Principal {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Revista nature1 = new Revista("Nature","cientificos",202411);
        Revista nature2 = new Revista("Nature","cientificos",202412);
        Revista java = new Revista("Java","Editorial Vereda",202503);
        Revista mariaDB = new Revista("MariaDB","Editorial Vereda",202501);
        biblioteca.agregarPublicacion(nature1);
        biblioteca.agregarPublicacion(nature2);
        biblioteca.agregarPublicacion(java);
        biblioteca.agregarPublicacion(mariaDB);
        biblioteca.buscarPublicacion(nature2).prestar();
        biblioteca.buscarPublicacion(nature2).devolver();

        Libro maquinaTiempo = new Libro("La maquina del tiempo", "Herbert George Wells", Genero.CIENCIA_FICCION,5);
        Libro montanyas = new Libro("En las montanyas de la locura", "H.P. Lovecraft", Genero.CIENCIA_FICCION,0);
        biblioteca.agregarPublicacion(maquinaTiempo);
        biblioteca.agregarPublicacion(montanyas);
        System.out.println(biblioteca.catalogoOrdenado());
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
        biblioteca.agregarPublicacion(new Libro("El bolson de higgs","Javier Santaolalla",Genero.DIVULGATIVOS,0));
        biblioteca.agregarPublicacion(new Libro("1984","George Orwell",Genero.DISTOPIA,10));

        CSVManager.guardarBibliotecaCSV("biblio1.csv",biblioteca);
        System.out.println(biblioteca);

        Biblioteca biblioteca2 = CSVManager.cargarBibliotecaCSV("biblio1.csv");
        biblioteca2.borrarPublicacion(nature1);
        ((Libro)biblioteca2.buscarPublicacion(maquinaTiempo)).borrarEjemplar(0);
        System.out.println(maquinaTiempo.mostrarEjemplares());
        biblioteca2.catalogoOrdenado();
        System.out.println(biblioteca2);

    }
}
