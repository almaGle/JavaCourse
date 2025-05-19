package JavaCourse.Módulo1.sesion8.reto2;

// Excepción personalizada que se lanzará cuando el consumo de CPU supere un umbral crítico.
// Hereda de Exception para ser una excepción 'checked', lo que significa que
// el compilador forzará su manejo (try-catch o throws).
public class ConsumoCriticoException extends Exception {

    // Constructor que recibe un mensaje de error.
    public ConsumoCriticoException(String message) {
        super(message);
    }

    // Opcional: se puede añadir un constructor que también reciba la causa de la excepción.
    public ConsumoCriticoException(String message, Throwable cause) {
        super(message, cause);
    }
}
