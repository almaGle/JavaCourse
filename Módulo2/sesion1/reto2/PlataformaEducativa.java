package Módulo2.sesion1.reto2;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate; 

public class PlataformaEducativa {

    /**
     * Muestra el detalle de todos los materiales en una lista.
     * Utiliza 'List<? extends MaterialCurso>' para aceptar listas de MaterialCurso o sus subtipos.
     * @param lista La lista de materiales a mostrar.
     */
    public static void mostrarMateriales(List<? extends MaterialCurso> lista) {
        System.out.println("\n📚 Materiales del curso:");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }

    /**
     * Suma y muestra la duración total de los videos en una lista.
     * Utiliza 'List<? extends Video>' para asegurar que solo se pasen listas de Video o sus subtipos.
     * @param lista La lista de videos a procesar.
     */
    public static void contarDuracionVideos(List<? extends Video> lista) {
        int duracionTotal = 0;
        for (Video video : lista) {
            duracionTotal += video.getDuracion();
        }
        System.out.println("\n🎥 Duración total de videos: " + duracionTotal + " minutos");
    }

    /**
     * Se actualiza el estado de los ejercicios a 'revisado = true'.
     * Se utiliza 'List<? super Ejercicio>' para permitir la modificación de la lista
     * que contenga Ejercicio o sus supertipos (MaterialCurso, Object).
     * @param lista La lista de ejercicios a marcar como revisados.
     */
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista) {
        System.out.println("\n✅ Marcando ejercicios como revisados:");
        for (Object obj : lista) {
            if (obj instanceof Ejercicio) { // Se necesita el instanceof y casting para acceder a setRevisado()
                Ejercicio ejercicio = (Ejercicio) obj;
                if (!ejercicio.isRevisado()) { // Solo marca si no ha sido revisado
                    ejercicio.setRevisado(true);
                    System.out.println("✅ Ejercicio '" + ejercicio.getTitulo() + "' marcado como revisado.");
                }
            }
        }
    }

    /**
     * Desafío adicional: Filtra materiales por autor.
     * Se utiliza un Predicate para definir la condición de filtrado.
     * @param lista La lista de materiales a filtrar.
     * @param filtro El predicado para filtrar por autor.
     */
    public static void filtrarMaterialesPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("\n🔍 Filtrando materiales por autor:");
        lista.stream()
             .filter(filtro)
             .forEach(MaterialCurso::mostrarDetalle);
    }

    public static void main(String[] args) {
        List<Video> videos = new ArrayList<>();
        videos.add(new Video("Introducción a Java", "Mario", 15));
        videos.add(new Video("POO en Java", "Carlos", 20));

        List<Articulo> articulos = new ArrayList<>();
        articulos.add(new Articulo("Historia de Java", "Ana", 1200));
        articulos.add(new Articulo("Tipos de datos", "Luis", 800));

        List<Ejercicio> ejercicios = new ArrayList<>();
        ejercicios.add(new Ejercicio("Variables y tipos", "Luis", false));
        ejercicios.add(new Ejercicio("Condicionales", "Mario", false));

        List<MaterialCurso> todosLosMateriales = new ArrayList<>();
        todosLosMateriales.addAll(videos);
        todosLosMateriales.addAll(articulos);
        todosLosMateriales.addAll(ejercicios);

        // Probar los métodos
        mostrarMateriales(todosLosMateriales); // Muestra todos los materiales

        contarDuracionVideos(videos); // Solo videos

        marcarEjerciciosRevisados(ejercicios); // Solo ejercicios, marcando como revisados

        // Mostrar materiales para ver el estado actualizado de los ejercicios
        mostrarMateriales(todosLosMateriales);

        // Filtrar por autor
        
        filtrarMaterialesPorAutor(todosLosMateriales, material -> material.getAutor().equals("Mario"));
    }
}