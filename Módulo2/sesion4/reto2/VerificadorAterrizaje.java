package Módulo2.sesion4.reto2;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class VerificadorAterrizaje {

    private static final Random RANDOM = new Random();

    private static void dormir(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("❌ Hilo de verificación interrumpido.");
        }
    }

    /**
     * Se simula la verificación de disponibilidad de la pista.
     * Probabilidad de éxito: 80%
     * @return CompletableFuture que indica si la pista está disponible.
     */
    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🛣️ Verificando disponibilidad de pista...");
            dormir(2 + RANDOM.nextInt(2)); // Latencia de 2 o 3 segundos
            boolean disponible = RANDOM.nextDouble() < 0.80; // 80% de probabilidad de ser true
            System.out.println("🛣️ Pista disponible: " + disponible);
            return disponible;
        });
    }

    /**
     * Simula la verificación del estado meteorológico.
     * Probabilidad de éxito: 85%
     * @return CompletableFuture que indica si el clima es favorable.
     */
    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🌦️ Verificando estado meteorológico...");
            dormir(2 + RANDOM.nextInt(2)); // Latencia de 2 o 3 segundos
            boolean favorable = RANDOM.nextDouble() < 0.85; // 85% de probabilidad de ser true
            System.out.println("🌦️ Clima favorable: " + favorable);
            return favorable;
        });
    }

    /**
     * Simula la verificación del estado del tráfico aéreo cercano.
     * Probabilidad de éxito: 90%
     * @return CompletableFuture que indica si el tráfico aéreo está despejado.
     */
    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Verificando tráfico aéreo cercano...");
            dormir(2 + RANDOM.nextInt(2)); // Latencia de 2 o 3 segundos
            boolean despejado = RANDOM.nextDouble() < 0.90; // 90% de probabilidad de ser true
            System.out.println("🚦 Tráfico aéreo despejado: " + despejado);
            return despejado;
        });
    }

    /**
     * Simula la verificación de disponibilidad de personal en tierra.
     * Probabilidad de éxito: 95%
     * @return CompletableFuture que indica si el personal está disponible.
     */
    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("👷‍♂️ Verificando disponibilidad de personal en tierra...");
            dormir(2 + RANDOM.nextInt(2)); // Latencia de 2 o 3 segundos
            boolean disponible = RANDOM.nextDouble() < 0.95; // 95% de probabilidad de ser true
            System.out.println("👷‍♂️ Personal disponible: " + disponible);
            return disponible;
        });
    }
}