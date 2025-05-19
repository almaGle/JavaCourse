package JavaCourse.Módulo1.sesion8.reto1;
// Interfaz para tomar decisiones según la acción del jugador.
// Abstrae la forma en que se procesan las decisiones del jugador.
public interface LogicaDecision {
    // Retorna la clave de la siguiente escena o resultado basado en la decisión.
    String tomarDecision(String pregunta, String... opciones);
}
