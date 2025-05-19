package JavaCourse.Módulo1.sesion6.reto2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {

        // Uso de CopyOnWriteArrayList para gestionar los temas activos de forma segura
        // Esto es útil en entornos concurrentes donde múltiples hilos pueden leer y
        // modificar la lista de temas.
        CopyOnWriteArrayList<Tema> temasActivos = new CopyOnWriteArrayList<>();

        // Agregando temas
        temasActivos.add(new Tema("Matemáticas básicas", 1));
        temasActivos.add(new Tema("Lectura comprensiva", 2));
        temasActivos.add(new Tema("Cuidado del medio ambiente", 3));
        temasActivos.add(new Tema("Historia universal", 2));
        temasActivos.add(new Tema("Programación Java", 1));

        System.out.println("--- Temas activos (orden de inserción) ---");
        temasActivos.forEach(System.out::println);
        System.out.println();

        // Mostrar la lista ordenada alfabéticamente (orden natural por Comparable)
        // Se crea una nueva ArrayList para poder usar Collections.sort() sin modificar
        // directamente CopyOnWriteArrayList de una manera que cause UnsupportedOperationException.
        // Ojo: CopyOnWriteArrayList no soporta Collections.sort directamente si implica modificación.
        // En este caso, para ordenar, se convierte a una lista modificable y luego se ordena.
        List<Tema> temasOrdenadosPorTitulo = new ArrayList<>(temasActivos);
        Collections.sort(temasOrdenadosPorTitulo);

        System.out.println("--- Temas ordenados alfabéticamente por título ---");
        temasOrdenadosPorTitulo.forEach(System.out::println);
        System.out.println();

        // Ordenar la lista por prioridad ascendente (1 -> 3) usando Comparator
        List<Tema> temasOrdenadosPorPrioridad = new ArrayList<>(temasActivos);
        Collections.sort(temasOrdenadosPorPrioridad, new Comparator<Tema>() {
            @Override
            public int compare(Tema t1, Tema t2) {
                return Integer.compare(t1.getPrioridad(), t2.getPrioridad());
            }
        });

        System.out.println("--- Temas ordenados por prioridad (ascendente) ---");
        temasOrdenadosPorPrioridad.forEach(System.out::println);
        System.out.println();

        // Uso de ConcurrentHashMap como repositorio de recursos compartidos por tema
        // ConcurrentHashMap es seguro para su uso en entornos concurrentes.
        ConcurrentHashMap<String, String> repositorioRecursos = new ConcurrentHashMap<>();

        // Agregando recursos
        repositorioRecursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        repositorioRecursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        repositorioRecursos.put("Cuidado del medio ambiente", "Video: Ecología para niños");
        repositorioRecursos.put("Historia universal", "PDF: Línea del tiempo");
        repositorioRecursos.put("Programación Java", "Tutorial: Introducción a Java");

        System.out.println("--- Repositorio de recursos por tema ---");
        repositorioRecursos.forEach((tituloTema, recurso) ->
                System.out.println("Tema: '" + tituloTema + "' -> Recurso: " + recurso));
        System.out.println();

        // Ejemplo de acceso a un recurso específico
        String temaBuscado = "Programación Java";
        System.out.println("Buscando recurso para el tema: '" + temaBuscado + "'");
        String recursoEncontrado = repositorioRecursos.get(temaBuscado);
        if (recursoEncontrado != null) {
            System.out.println("Recurso encontrado: " + recursoEncontrado);
        } else {
            System.out.println("No se encontró ningún recurso para el tema: " + temaBuscado);
        }
    }
}
