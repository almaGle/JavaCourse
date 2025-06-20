package Módulo2.sesion3.reto2;

// src/ProcesadorEncuestasClinica.java
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProcesadorEncuestasClinica {

    // Clase auxiliar para combinar Encuesta y el nombre de la Sucursal
   
    static class EncuestaConSucursal {
        private final Encuesta encuesta;
        private final String nombreSucursal;

        public EncuestaConSucursal(Encuesta encuesta, String nombreSucursal) {
            this.encuesta = encuesta;
            this.nombreSucursal = nombreSucursal;
        }

        public Encuesta getEncuesta() {
            return encuesta;
        }

        public String getNombreSucursal() {
            return nombreSucursal;
        }
    }

    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
            new Sucursal("Centro", List.of(
                new Encuesta("Paciente A", "El tiempo de espera fue largo", 2),
                new Encuesta("Paciente B", null, 4), // Sin comentario
                new Encuesta("Paciente C", "Excelente atención del personal", 5)
            )),
            new Sucursal("Norte", List.of(
                new Encuesta("Paciente D", "La atención fue buena, pero la limpieza puede mejorar", 3),
                new Encuesta("Paciente E", null, 2), // Sin comentario
                new Encuesta("Paciente F", "Todo perfecto", 5)
            )),
            new Sucursal("Sur", List.of(
                new Encuesta("Paciente G", "No me gustó el trato del médico", 1),
                new Encuesta("Paciente H", "Instalaciones un poco antiguas", 3)
            ))
        );

        System.out.println("📊 Comentarios para seguimiento del área de calidad:");

        sucursales.stream()
            // 1. Se usa flatMap para "desanidar" la lista de encuestas de cada sucursal.
            // Para mantener el contexto de la sucursal, mapeamos cada encuesta a una EncuestaConSucursal.
            .flatMap(sucursal -> sucursal.getEncuestas().stream()
                                         .map(encuesta -> new EncuestaConSucursal(encuesta, sucursal.getNombre())))
            // 2. Filtrar solo las encuestas con calificación menor o igual a 3 (insatisfechos).
            .filter(eCS -> eCS.getEncuesta().getCalificacion() <= 3)
            // 3. Mapear cada EncuestaConSucursal a su Optional<String> de comentario.
            // Esto nos da un Stream de Optional<String>
            .map(eCS -> eCS.getEncuesta().getComentario().map(
                                comentario -> "Sucursal " + eCS.getNombreSucursal() + ": Seguimiento a paciente con comentario: \"" + comentario + "\""))
            // 4. Filtrar solo los Optional que contienen un valor (es decir, el comentario no es nulo).
            .filter(Optional::isPresent)
            // 5. Extraer el valor String del Optional (ahora sabemos que es seguro).
            .map(Optional::get)
            // 6. Imprimir cada mensaje de seguimiento.
            .forEach(System.out::println);
    }
}