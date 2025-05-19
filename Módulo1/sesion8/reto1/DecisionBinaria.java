package JavaCourse.Módulo1.sesion8.reto1;

import java.util.Scanner;

// Implementación simple de LogicaDecision para decisiones binarias (sí/no, opción 1/2).
// Esta clase es responsable de interactuar con el jugador para obtener una decisión.
public class DecisionBinaria implements LogicaDecision {

    private Scanner scanner = new Scanner(System.in); // Usamos un Scanner para la entrada del usuario

    @Override
    public String tomarDecision(String pregunta, String... opciones) {
        System.out.println("\n" + pregunta);
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        System.out.print("Elige una opción (" + 1 + "-" + opciones.length + "): ");

        int eleccion = -1;
        while (eleccion < 1 || eleccion > opciones.length) {
            try {
                eleccion = Integer.parseInt(scanner.nextLine());
                if (eleccion < 1 || eleccion > opciones.length) {
                    System.out.print("Opción inválida. Por favor, elige entre 1 y " + opciones.length + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Por favor, ingresa un número: ");
            }
        }
        // Para este ejemplo, retornamos la opción elegida o una clave simple.
        // En un juego real, esto podría mapear a una clave de la siguiente escena.
        return opciones[eleccion - 1]; // Retorna la opción de texto elegida
    }
}