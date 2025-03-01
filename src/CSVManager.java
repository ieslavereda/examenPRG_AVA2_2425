import java.io.*;

public class CSVManager {
    public static void guardarBibliotecaCSV(String rutaArchivo, Biblioteca biblioteca){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))){
            for (Publicacion publicacion : biblioteca.getCatalogo()) {
                String linea = (publicacion instanceof Libro) ? "Libro" : "Revista";
                linea += "," + publicacion.getTitulo();
                linea += "," + publicacion.getAutor();
                if(publicacion instanceof Libro) {
                    linea += ",";
                    Libro libro = (Libro) publicacion;
                    linea += ","+libro.getGenero();
                    for (Ejemplar ejemplar:libro.getEjemplaresDisponibles().keySet())
                        linea += ","+ejemplar.getCodigo();
                } else {
                    Revista revista = (Revista) publicacion;
                    linea += "," + revista.getNumeroEdicion();
                }
                writer.write(linea);
                writer.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Biblioteca cargarBibliotecaCSV(String rutaArchivo){
        Biblioteca biblioteca = new Biblioteca();
        try(BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String tipo = datos[0];
                String titulo = datos[1];
                String autor = datos[2];
                if(tipo.equals("Libro")) {
                    Genero genero = Genero.getGenerosCadena(datos[4]);
                    biblioteca.agregarPublicacion(new Libro(titulo,autor,genero,datos.length-5));
                } else if(tipo.equals("Revista")) {
                    biblioteca.agregarPublicacion(new Revista(titulo,autor,Integer.parseInt(datos[3])));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return biblioteca;
    }

}