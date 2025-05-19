package JavaCourse.Módulo1.sesion8.reto1;

// Implementación simple de GestorDialogo.
// Simplemente imprime el diálogo en consola.
public class DialogoTexto implements GestorDialogo {
    @Override
    public void mostrarDialogo(String personaje, String dialogo) {
        System.out.println(personaje + ": \"" + dialogo + "\"");
    }
}