package JavaCourse.Módulo1.sesion7.reto2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime; // Para añadir fecha y hora al log de fallos
import java.time.format.DateTimeFormatter; // Para formatear la fecha y hora

public class AnalizadorDeLogs {

    // Método auxiliar para crear un archivo de log de ejemplo si no existe.
    // Esto es útil para probar el AnalizadorDeLogs sin tener que crear el archivo manualmente.
    private static void crearArchivoLogEjemplo(String nombreArchivo) {
        Path rutaArchivo = Paths.get(nombreArchivo);
        if (!Files.exists(rutaArchivo)) {
            System.out.println("Creando archivo de log de ejemplo: " + nombreArchivo);
            String contenidoEjemplo = 
                "INFO: Inicio de la prueba de usuario.\n" +
                "ERROR: Fallo en la autenticación del usuario 'admin'.\n" +
                "WARNING: Conexión a la base de datos lenta.\n" +
                "INFO: Procesando datos de entrada.\n" +
                "ERROR: NullPointerException en el módulo de pagos.\n" +
                "INFO: Datos procesados correctamente.\n" +
                "WARNING: Espacio en disco bajo en el servidor de logs.\n" +
                "ERROR: Timeout en la respuesta del servicio externo.\n" +
                "SUCCESS: Prueba completada con éxito.\n" +
                "INFO: Generando reporte final.\n" +
                "ERROR: Error de permisos al escribir en el directorio '/tmp'.\n" +
                "WARNING: Versión obsoleta de la librería 'commons-io'.\n" +
                "INFO: Limpiando recursos.\n" +
                "SUCCESS: Todos los procesos finalizados.\n";
            try {
                Files.writeString(rutaArchivo, contenidoEjemplo);
            } catch (IOException e) {
                System.err.println("Error al crear el archivo de log de ejemplo: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        String nombreArchivoLog = "errores.log";
        String nombreArchivoFallos = "registro_fallos.txt";

        // Creamos el archivo de log de ejemplo antes de intentar leerlo
        crearArchivoLogEjemplo(nombreArchivoLog);

        int totalLineas = 0;
        int cantidadErrores = 0;
        int cantidadAdvertencias = 0;

        // Usamos try-with-resources para asegurar que el BufferedReader se cierre automáticamente
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivoLog))) {
            String linea;
            System.out.println("Analizando archivo: " + nombreArchivoLog);
            while ((linea = lector.readLine()) != null) {
                totalLineas++;
                if (linea.contains("ERROR")) {
                    cantidadErrores++;
                }
                if (linea.contains("WARNING")) {
                    cantidadAdvertencias++;
                }
            }

            // --- Resumen del Análisis ---
            System.out.println("\n--- Resumen del Análisis ---");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores (ERROR): " + cantidadErrores);
            System.out.println("Cantidad de advertencias (WARNING): " + cantidadAdvertencias);

            if (totalLineas > 0) {
                double porcentajeErrores = (double) cantidadErrores / totalLineas * 100;
                double porcentajeAdvertencias = (double) cantidadAdvertencias / totalLineas * 100;
                double porcentajeTotalProblemas = porcentajeErrores + porcentajeAdvertencias;

                System.out.printf("Porcentaje de líneas con errores: %.2f%%\n", porcentajeErrores);
                System.out.printf("Porcentaje de líneas con advertencias: %.2f%%\n", porcentajeAdvertencias);
                System.out.printf("Porcentaje total de líneas con problemas (errores/advertencias): %.2f%%\n", porcentajeTotalProblemas);
            } else {
                System.out.println("El archivo está vacío o no contiene líneas.");
            }

        } catch (IOException e) {
            // --- Manejo de Excepciones ---
            // Capturamos cualquier IOException (por ejemplo, archivo no encontrado)
            // y guardamos el mensaje de error en un archivo de registro de fallos.
            System.err.println("¡Error al leer el archivo de log! Guardando detalles en " + nombreArchivoFallos);
            
            // Formatear la fecha y hora para el registro de fallos
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String fechaHora = LocalDateTime.now().format(formatter);
            
            try (BufferedWriter escritorFallos = new BufferedWriter(new FileWriter(nombreArchivoFallos, true))) { // 'true' para añadir al final del archivo
                escritorFallos.write("--- Fallo de Análisis (" + fechaHora + ") ---\n");
                escritorFallos.write("Error al intentar leer el archivo: " + nombreArchivoLog + "\n");
                escritorFallos.write("Mensaje de error: " + e.getMessage() + "\n");
                escritorFallos.write("-------------------------------------\n\n");
                System.out.println("Detalles del fallo registrados en: " + nombreArchivoFallos);
            } catch (IOException ex) {
                System.err.println("¡Error crítico! No se pudo escribir en el archivo de registro de fallos: " + ex.getMessage());
            }
        }
    }
}