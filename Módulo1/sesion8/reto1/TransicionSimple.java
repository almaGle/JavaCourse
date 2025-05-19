package JavaCourse.Módulo1.sesion8.reto1;

// Implementación simple de TransicionHistoria.
// Se encarga únicamente de anunciar el cambio de escena.
public class TransicionSimple implements TransicionHistoria {
    @Override
    public void siguienteEscena(String nombreEscenaActual, String nombreSiguienteEscena) {
        System.out.println("--- Transición de Escena ---");
        System.out.println("De '" + nombreEscenaActual + "' a '" + nombreSiguienteEscena + "'.");
        System.out.println("----------------------------");
    }
}