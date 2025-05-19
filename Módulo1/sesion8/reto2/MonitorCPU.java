package JavaCourse.Módulo1.sesion8.reto2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set; // Mejor usar la interfaz Set para declarar HashSet

public class MonitorCPU {

    // Umbral crítico para el consumo de CPU
    private static final int UMBRAL_CRITICO = 95;

    public static void main(String[] args) {
        // Uso de un HashSet para almacenar los registros de consumo de CPU.
        // HashSet garantiza que no haya elementos duplicados y ofrece un rendimiento
        // óptimo para operaciones de adición y verificación de existencia.
        Set<Integer> registrosConsumoCPU = new HashSet<>();
        
        // Scanner para la entrada del usuario
        Scanner scanner = null; 

        System.out.println("--- Monitor de Consumo de CPU ---");
        System.out.println("Ingresa el consumo de CPU para cada servidor (en porcentaje).");
        System.out.println("Escribe 'fin' para terminar la entrada de datos.");

        try {
            scanner = new Scanner(System.in);
            String entradaUsuario;

            while (true) {
                System.out.print("Consumo de CPU (0-100%): ");
                entradaUsuario = scanner.nextLine();

                if (entradaUsuario.equalsIgnoreCase("fin")) {
                    break; // Salir del bucle si el usuario escribe 'fin'
                }

                try {
                    int consumo = Integer.parseInt(entradaUsuario);

                    // Validación: Valor negativo o mayor a 100%
                    if (consumo < 0 || consumo > 100) {
                        System.out.println("ERROR: El consumo de CPU debe ser entre 0 y 100. Inténtalo de nuevo.");
                        continue; // Volver al inicio del bucle
                    }

                    // Validación: Registro duplicado
                    if (registrosConsumoCPU.contains(consumo)) {
                        System.out.println("ADVERTENCIA: El consumo '" + consumo + "%' ya ha sido registrado. Ignorando duplicado.");
                        continue; // Volver al inicio del bucle
                    }

                    // Validación: Lanzar ConsumoCriticoException si el consumo es > UMBRAL_CRITICO
                    if (consumo > UMBRAL_CRITICO) {
                        // Lanzamos nuestra excepción personalizada
                        throw new ConsumoCriticoException("¡ALERTA CRÍTICA! Consumo de CPU del " + consumo + "% detectado.");
                    }

                    // Si todas las validaciones pasan, se añade el registro
                    registrosConsumoCPU.add(consumo);
                    System.out.println("Registro de CPU " + consumo + "% añadido correctamente.");

                } catch (NumberFormatException e) {
                    // Captura si el usuario no introduce un número válido
                    System.out.println("ERROR: Entrada no válida. Por favor, ingresa un número entero o 'fin'.");
                } catch (ConsumoCriticoException e) {
                    // Captura nuestra excepción personalizada
                    System.err.println(e.getMessage()); // Muestra el mensaje crítico
                    // En un entorno real, aquí se podría enviar una notificación,
                    // registrar en un sistema de alertas, etc.
                    // Decidimos no añadirlo al registro para evitar un bucle infinito
                    // de alertas si el mismo valor crítico se ingresa repetidamente.
                }
            }

            System.out.println("\n--- Resumen de Registros de CPU ---");
            if (registrosConsumoCPU.isEmpty()) {
                System.out.println("No se registraron consumos de CPU.");
            } else {
                System.out.println("Consumos de CPU registrados (sin duplicados): " + registrosConsumoCPU);
                
            }

        } finally {
            // Asegura que el Scanner se cierre, liberando los recursos del sistema.
            if (scanner != null) {
                scanner.close();
                System.out.println("\nRecursos cerrados correctamente.");
            }
        }
    }
}