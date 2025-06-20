package org.alma.reto2;

import reactor.core.publisher.Flux;
import java.time.Duration;

public class UciMonitorReactor {

    private static final String YELLOW_COLOR = "\u001B[33m";
    private static final String GREEN_COLOR = "\u001B[32m";
    private static final String RED_COLOR = "\u001B[31m";
    private static final String RESET_COLOR = "\u001B[0m";

    public static void main(String[] args) throws InterruptedException {
        System.out.println(YELLOW_COLOR + "⚡ Iniciando monitoreo de UCI...\n" + RESET_COLOR);

        VitalSignsSimulator simulator = new VitalSignsSimulator();

        Flux<VitalSignAlert> patient1Alerts = simulator.getPatientVitalSignsFlux(1);
        Flux<VitalSignAlert> patient2Alerts = simulator.getPatientVitalSignsFlux(2);
        Flux<VitalSignAlert> patient3Alerts = simulator.getPatientVitalSignsFlux(3);

        Flux<VitalSignAlert> allPatientAlerts = Flux.merge(
                patient1Alerts,
                patient2Alerts,
                patient3Alerts
            )
            .sort((a1, a2) -> Integer.compare(a2.priority(), a1.priority())); // Prioriza alertas (mayor prioridad primero)

        allPatientAlerts
        .delayElements(Duration.ofSeconds(1)) 
        .subscribe(
            alert -> System.out.println(alert.toString()), 
            error -> System.err.println("Error en el monitoreo: " + error.getMessage()),
            () -> System.out.println("Monitoreo de UCI completado.") 
        );

        Thread.sleep(60000); // Monitorear por 20 segundos
        System.out.println(YELLOW_COLOR + "\n🚫 Deteniendo el monitoreo de UCI." + RESET_COLOR);
    }
}