package JavaCourse.Módulo1.sesion5.reto1;

public class Operador {
    private String nombre;

    public Operador(String nombre) {
        this.nombre = nombre;
    }

    public void reportarse() {
        System.out.println("Operador " + nombre + ": Presente y listo para la acción.");
    }
}
