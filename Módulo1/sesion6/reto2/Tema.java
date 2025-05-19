package JavaCourse.Módulo1.sesion6.reto2;

// Clase Tema que implementa Comparable para ordenar por título
class Tema implements Comparable<Tema> {
    private String titulo;
    private int prioridad; // 1 = urgente, 2 = importante, 3 = opcional

    public Tema(String titulo, int prioridad) {
        this.titulo = titulo;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Tema{titulo='" + titulo + "', prioridad=" + prioridad + "}";
    }

    // Implementación de Comparable para ordenar por título alfabéticamente
    @Override
    public int compareTo(Tema otroTema) {
        return this.titulo.compareTo(otroTema.titulo);
    }

}
