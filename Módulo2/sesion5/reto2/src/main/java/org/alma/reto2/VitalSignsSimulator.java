package org.alma.reto2;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;
import java.util.Random;

record VitalSignAlert(int patientId, String type, String message, int priority) {
    private static final String YELLOW_COLOR = "\u001B[33m";
    private static final String RED_COLOR = "\u001B[31m";
    private static final String RESET_COLOR = "\u001B[0m";

    @Override
    public String toString() {
        String color = (type.equals("FC")) ? RED_COLOR : YELLOW_COLOR;
        return color + "⚠️ Paciente " + patientId + " - " + message + RESET_COLOR;
    }
}

public class VitalSignsSimulator {

    private static final Random RANDOM = new Random();

    
    public Flux<VitalSignAlert> getPatientVitalSignsFlux(int patientId) {
        System.out.println("  [SIM] Iniciando monitoreo para Paciente " + patientId);
        return Flux.interval(Duration.ofSeconds(2)) 
                .flatMap(tick -> {
                    // Generar valores aleatorios
                    int fc = 60 + RANDOM.nextInt(80); 
                    int paSystolic = 90 + RANDOM.nextInt(60); 
                    int paDiastolic = 60 + RANDOM.nextInt(40); 
                    int spo2 = 85 + RANDOM.nextInt(15); 

                  
                    if (RANDOM.nextDouble() < 0.2) {
                        fc = RANDOM.nextBoolean() ? (40 + RANDOM.nextInt(10)) : (121 + RANDOM.nextInt(30)); 
                    }
                    if (RANDOM.nextDouble() < 0.2) { 
                        spo2 = 80 + RANDOM.nextInt(9); 
                    }
                    if (RANDOM.nextDouble() < 0.2) {
                        paSystolic = RANDOM.nextBoolean() ? (70 + RANDOM.nextInt(20)) : (141 + RANDOM.nextInt(30));
                        paDiastolic = RANDOM.nextBoolean() ? (40 + RANDOM.nextInt(20)) : (91 + RANDOM.nextInt(30)); 
                    }

                  
                    if (fc < 50 || fc > 120) {
                        System.out.println("  [DEBUG] FC CRÍTICA detectada para Paciente " + patientId); 
                        return Mono.just(new VitalSignAlert(patientId, "FC", "FC crítica: " + fc + " bpm", 2));
                    }
                    if (paSystolic < 90 || paDiastolic < 60 || paSystolic > 140 || paDiastolic > 90) {
                        System.out.println("  [DEBUG] PA CRÍTICA detectada para Paciente " + patientId); 
                        return Mono.just(new VitalSignAlert(patientId, "PA", "PA crítica: " + paSystolic + "/" + paDiastolic + " mmHg", 1));
                    }
                    if (spo2 < 90) {
                        System.out.println("  [DEBUG] SpO2 CRÍTICA detectada para Paciente " + patientId); 
                        return Mono.just(new VitalSignAlert(patientId, "SpO2", "SpO2 baja: " + spo2 + "%", 1));
                    }

                    return Mono.empty();
                });
    }
}