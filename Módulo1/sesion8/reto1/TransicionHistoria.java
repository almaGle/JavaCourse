package JavaCourse.Módulo1.sesion8.reto1;
// Interfaz para definir cómo se pasa de una escena a otra.
// Permite que diferentes tipos de transiciones (simple, con efectos, etc.)
// puedan ser implementadas de forma independiente.
public interface TransicionHistoria {
    void siguienteEscena(String nombreEscenaActual, String nombreSiguienteEscena);
}