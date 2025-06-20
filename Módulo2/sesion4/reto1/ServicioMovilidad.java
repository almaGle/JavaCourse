package Módulo2.sesion4.reto1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class ServicioMovilidad {

    private static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("❌ Hilo interrumpido durante la simulación de espera.");
        }
    }

    /**
     * Simula el cálculo de la ruta óptima.
     * Esta es una operación asíncrona que puede tomar de 2 a 3 segundos.
     *
     * @return CompletableFuture que contendrá el mensaje de la ruta.
     */
    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Calculando ruta...");
            int latencia = 2 + new Random().nextInt(2); // Latencia de 2 o 3 segundos
            dormir(latencia);
            
            return "Centro -> Norte";
        });
    }

    /**
     * Simula la estimación de la tarifa del viaje.
     * Esta es una operación asíncrona que puede tomar de 1 a 2 segundos.
     *
     * @return CompletableFuture que contendrá el valor numérico de la tarifa.
     */
    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("💰 Estimando tarifa...");
            int latencia = 1 + new Random().nextInt(2); // Latencia de 1 o 2 segundos
            dormir(latencia);
            
            return 75.50;
        });
    }
}