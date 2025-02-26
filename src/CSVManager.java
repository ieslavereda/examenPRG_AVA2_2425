import java.io.*;
import java.util.*;

class CSVManager {
//    public static void guardarRecursosCSV(Map<String, Publicacion> catalogo, String rutaArchivo) throws IOException {
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
//            for (Map.Entry<String, Publicacion> entry : catalogo.entrySet()) {
//                Publicacion publicacion = entry.getValue();
//                String tipo = (publicacion instanceof Libro) ? "Libro" : "Revista";
//                String detalles = (publicacion instanceof Libro) ?
//                        String.valueOf(((Libro) publicacion).getNumPaginas()) :
//                        String.valueOf(((Revista) publicacion).getNumeroEdicion());
//                String ejemplares = (publicacion instanceof Libro) ?
//                        String.join(",", ((Libro) publicacion).getEjemplares()) : "";
//                writer.write(entry.getKey() + "," + publicacion.getTitulo() + "," + publicacion.getAutor() + "," +
//                        publicacion.getAñoPublicacion() + "," + publicacion.isDisponible() + "," + tipo + "," + detalles + "," + ejemplares);
//                writer.newLine();
//            }
//        }
//    }
//
//    public static Map<String, Publicacion> cargarRecursosCSV(String rutaArchivo) throws IOException {
//        Map<String, Publicacion> catalogo = new HashMap<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
//            String linea;
//            while ((linea = reader.readLine()) != null) {
//                String[] datos = linea.split(",");
//                String codigo = datos[0];
//                String titulo = datos[1];
//                String autor = datos[2];
//                int añoPublicacion = Integer.parseInt(datos[3]);
//                boolean disponible = Boolean.parseBoolean(datos[4]);
//                String tipo = datos[5];
//                if (tipo.equals("Libro")) {
//                    int numPaginas = Integer.parseInt(datos[6]);
//                    Libro libro = new Libro(titulo, autor, añoPublicacion, disponible, numPaginas);
//                    if (datos.length > 7 && !datos[7].isEmpty()) {
//                        for (String ejemplar : datos[7].split(",")) {
//                            libro.agregarEjemplar(ejemplar);
//                        }
//                    }
//                    catalogo.put(codigo, libro);
//                } else {
//                    int numeroEdicion = Integer.parseInt(datos[6]);
//                    catalogo.put(codigo, new Revista(titulo, autor, añoPublicacion, disponible, numeroEdicion));
//                }
//            }
//        }
//        return catalogo;
//    }
}