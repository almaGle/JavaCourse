package Módulo2.sesion4.reto1;

import java.util.concurrent.CompletableFuture;

public class MovilidadAppMain {

    public static void main(String[] args) {
        System.out.println("🚀 Solicitando viaje en la app de movilidad...\n");

        ServicioMovilidad servicio = new ServicioMovilidad();

        CompletableFuture<String> rutaFuture = servicio.calcularRuta();
        CompletableFuture<Double> tarifaFuture = servicio.estimarTarifa();

        CompletableFuture<String> confirmacionFuture = rutaFuture.thenCombine(tarifaFuture,
            (ruta, tarifa) -> {
                return "✅ 🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + String.format("%.2f", tarifa);
            })
            .exceptionally(ex -> {
                System.err.println("🚨 Error al procesar el viaje: " + ex.getMessage());
                return "❌ No se pudo confirmar el viaje debido a un error.";
            });

        System.out.println(confirmacionFuture.join());

        System.out.println("\n✨ Proceso de solicitud de viaje finalizado.");
    }
}