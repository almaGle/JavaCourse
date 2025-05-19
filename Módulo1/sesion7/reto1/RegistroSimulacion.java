package JavaCourse.Módulo1.sesion7.reto1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RegistroSimulacion {

    public static void main(String[] args) {

        // 1. Definir la ruta del archivo parametros.txt dentro de una carpeta config/
        // Usamos Paths.get() para construir la ruta de manera independiente del sistema operativo.
        Path directorioConfig = Paths.get("config");
        Path archivoParametros = directorioConfig.resolve("parametros.txt");

        // 2. Crear un String con los parámetros de la simulación
        String contenidoParametros = "Tiempo de ciclo: 55.8 segundos\n" +
                                     "Velocidad de línea: 1.2 m/s\n" +
                                     "Número de estaciones: 8\n" +
                                     "Temperatura ambiente: 25.0 °C\n" +
                                     "Humedad relativa: 60.5 %";

        try {
            // 3. Crear la carpeta config/ si no existe
            // Files.createDirectories() crea todos los directorios intermedios si es necesario.
            if (!Files.exists(directorioConfig)) {
                Files.createDirectories(directorioConfig);
                System.out.println("Directorio 'config/' creado exitosamente.");
            }

            // 4. Utilizar Files.write() para guardar el contenido en el archivo
            // StandardOpenOption.CREATE crea el archivo si no existe, o lo sobrescribe si ya existe.
            Files.write(archivoParametros, contenidoParametros.getBytes(), StandardOpenOption.CREATE);
            System.out.println("Archivo '" + archivoParametros.getFileName() + "' creado y escrito exitosamente en '" + directorioConfig.getFileName() + "/'.");

            // 5. Utilizar Files.exists() para validar que el archivo fue creado correctamente
            if (Files.exists(archivoParametros)) {
                System.out.println("El archivo '" + archivoParametros.getFileName() + "' existe en la ruta especificada.");
            } else {
                System.out.println("Error: El archivo '" + archivoParametros.getFileName() + "' NO fue creado.");
            }

            // 6. Leer el archivo con Files.readString() y mostrar su contenido en consola
            System.out.println("\n--- Contenido del archivo de parámetros ---");
            String contenidoLeido = Files.readString(archivoParametros);
            System.out.println(contenidoLeido);

        } catch (IOException e) {
            // Manejo de excepciones en caso de errores de I/O
            System.err.println("Se produjo un error de I/O: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
