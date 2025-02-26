import java.io.*;
import java.util.*;

public class CSVManager {
    public static void guardarBibliotecaCSV(String rutaArchivo, Set<Publicacion> catalogo) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
        for (Publicacion publicacion : catalogo) {
            String linea = (publicacion instanceof Libro) ? "Libro" : "Revista";
            linea += "," + publicacion.getTitulo();
            linea += "," + publicacion.getAutor();
            if(publicacion instanceof Libro) {
              linea += ",";
              Libro libro = (Libro) publicacion;
              for (Ejemplar ejemplar:libro.getEjemplaresDisponibles().keySet())
                  linea += ","+ejemplar.getCodigo()+","+ejemplar.getAnyoPublicacion();
            } else {
                Revista revista = (Revista) publicacion;
                linea += "," + revista.getNumeroEdicion();
            }
            writer.write(linea);
            writer.newLine();
        }

    }

    public static Set<Publicacion> cargarBibliotecaCSV(String rutaArchivo) throws Exception {
        Set<Publicacion> catalogo = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",");
            String tipo = datos[0];
            String titulo = datos[1];
            String autor = datos[2];
            if(tipo.equals("Libro")) {
                Map<Ejemplar,Boolean> ejemplaresDisponibles = new TreeMap<>();
                for (int i = 4; i < datos.length; i++) {
                    int codigo = Integer.parseInt(datos[i++]);
                    int anyo = Integer.parseInt(datos[i]);
                    ejemplaresDisponibles.put(new Ejemplar(titulo,autor,codigo,anyo),true);
                }
                catalogo.add(new Libro(titulo,autor,ejemplaresDisponibles));
            } else if(tipo.equals("Revista")) {
                catalogo.add(new Revista(titulo,autor,Integer.parseInt(datos[3])));
            } else {
                throw new Exception("Error de tipo");
            }
        }
        return catalogo;
    }

}