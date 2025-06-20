package Módulo2.sesion2.reto2;
// src/SimulacionHospital.java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulacionHospital {

    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a los recursos médicos...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        Runnable draSanchezTask = () -> {
            String originalName = Thread.currentThread().getName(); 
            Thread.currentThread().setName("Dra. Sánchez"); 
            salaCirugia.usar(Thread.currentThread().getName()); 
            Thread.currentThread().setName(originalName); 
        };
        Runnable drGomezTask = () -> {
            String originalName = Thread.currentThread().getName();
            Thread.currentThread().setName("Dr. Gómez");
            salaCirugia.usar(Thread.currentThread().getName());
            Thread.currentThread().setName(originalName);
        };
        Runnable enfermeraLauraTask = () -> {
            String originalName = Thread.currentThread().getName();
            Thread.currentThread().setName("Enfermera Laura");
            salaCirugia.usar(Thread.currentThread().getName());
            Thread.currentThread().setName(originalName);
        };
        Runnable drMartinezTask = () -> {
            String originalName = Thread.currentThread().getName();
            Thread.currentThread().setName("Dr. Martínez");
            salaCirugia.usar(Thread.currentThread().getName());
            Thread.currentThread().setName(originalName);
        };
        Runnable paramedicoJuanTask = () -> {
            String originalName = Thread.currentThread().getName();
            Thread.currentThread().setName("Paramédico Juan");
            salaCirugia.usar(Thread.currentThread().getName());
            Thread.currentThread().setName(originalName);
        };


        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(draSanchezTask);
        executor.submit(drGomezTask);
        executor.submit(enfermeraLauraTask);
        executor.submit(drMartinezTask);
        executor.submit(paramedicoJuanTask);

        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                System.err.println("❌ Las tareas no terminaron en el tiempo especificado.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("❌ La simulación fue interrumpida mientras esperaba la terminación.");
        }

        System.out.println("\n✅ Simulación de acceso a recursos críticos finalizada.");
    }
}