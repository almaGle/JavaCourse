package Módulo2.sesion3.reto2;

import java.util.Optional;

public class Encuesta {
    private final String paciente;
    private final String comentario; 
    private final int calificacion; 

    public Encuesta(String paciente, String comentario, int calificacion) {
        this.paciente = paciente;
        this.comentario = comentario;
        this.calificacion = calificacion;
    }

    public String getPaciente() {
        return paciente;
    }

    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Devuelve el comentario envuelto en un Optional.
     * Esto previene NullPointerException si el comentario es nulo.
     *
     * @return Un Optional que contiene el comentario si no es nulo, o un Optional vacío.
     */
    public Optional<String> getComentario() {
        return Optional.ofNullable(comentario);
    }
}
