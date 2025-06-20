package Módulo2.sesion4.reto2;

import java.util.concurrent.CompletableFuture;

public class ControlAterrizajePrincipal {

    public static void main(String[] args) {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        VerificadorAterrizaje verificador = new VerificadorAterrizaje();

        CompletableFuture<Boolean> pistaFuture = verificador.verificarPista();
        CompletableFuture<Boolean> climaFuture = verificador.verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificador.verificarTraficoAereo();
        CompletableFuture<Boolean> personalFuture = verificador.verificarPersonalTierra();

        CompletableFuture<String> resultadoAterrizaje = CompletableFuture.allOf(
                pistaFuture, climaFuture, traficoFuture, personalFuture)
            .thenApply(Void -> {
                boolean pistaOk = pistaFuture.join();
                boolean climaOk = climaFuture.join();
                boolean traficoOk = traficoFuture.join();
                boolean personalOk = personalFuture.join();

                if (pistaOk && climaOk && traficoOk && personalOk) {
                    return "🛬 Aterrizaje autorizado: todas las condiciones óptimas.";
                } else {
                    return "🚫 Aterrizaje denegado: condiciones no óptimas.";
                }
            })
            .exceptionally(ex -> {
                System.err.println("🚨 Error crítico en el sistema de verificación: " + ex.getMessage());
                return "❌ No se pudo determinar la autorización debido a un fallo del sistema.";
            });

        System.out.println(resultadoAterrizaje.join());

        System.out.println("\n✅ Proceso de gestión de aterrizaje finalizado.");
    }
}