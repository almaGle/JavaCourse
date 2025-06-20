package Módulo2.sesion2.reto1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class MisionEspacial {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        Future<String> navFuture = executor.submit(new SistemaNavegacion());
        Future<String> soporteVitalFuture = executor.submit(new SistemaSoporteVital());
        Future<String> controlTermicoFuture = executor.submit(new SistemaControlTermico());
        Future<String> comunicacionesFuture = executor.submit(new SistemaComunicaciones());

        try {
            
            System.out.println(comunicacionesFuture.get()); 
            System.out.println(soporteVitalFuture.get());
            System.out.println(controlTermicoFuture.get());
            System.out.println(navFuture.get());

        } catch (InterruptedException | ExecutionException e) {
            // Captura excepciones que puedan ocurrir durante la ejecución de las tareas
            System.err.println("❌ Un error ocurrió durante la simulación: " + e.getMessage());
            e.printStackTrace();
        } finally {
            executor.shutdown();
            System.out.println("✅ Todos los sistemas reportan estado operativo.");
        }
    }
}