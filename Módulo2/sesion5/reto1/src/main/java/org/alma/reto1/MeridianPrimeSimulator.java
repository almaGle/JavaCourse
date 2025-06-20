package org.alma.reto1;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import reactor.core.publisher.Mono;

public class MeridianPrimeSimulator {

    private static final Random RANDOM = new Random();
    private static final String RESET_COLOR = "\u001B[0m";
    private static final String RED_COLOR = "\u001B[31m";   
    private static final String YELLOW_COLOR = "\u001B[33m";

   
    public Flux<String> simularTrafico() {
        System.out.println(YELLOW_COLOR + "  [SIM] Iniciando simulación de Sensores de Tráfico..." + RESET_COLOR);
        return Flux.interval(Duration.ofMillis(500))
                .onBackpressureBuffer()
                .flatMap(tick -> {
                    int congestion = RANDOM.nextInt(101);
                    if (congestion > 70) {
                        return Mono.just(YELLOW_COLOR + "🚗 Alerta: Congestión del " + congestion + "% en Avenida Solar" + RESET_COLOR);
                    }
                    return Mono.empty(); 
                })
                .delayElements(Duration.ofMillis(100));
    }

    public Flux<String> simularContaminacion() {
        System.out.println(YELLOW_COLOR + "  [SIM] Iniciando simulación de Contaminación del Aire..." + RESET_COLOR);
        return Flux.interval(Duration.ofMillis(600))
                .flatMap(tick -> {
                    int pm25 = RANDOM.nextInt(100);
                    if (pm25 > 50) {
                        return Mono.just(YELLOW_COLOR + "🌫️ Alerta: Contaminación alta (PM2.5: " + pm25 + " ug/m3)" + RESET_COLOR);
                    }
                    return Mono.empty(); 
                });
    }

    public Flux<String> simularAccidentesViales() {
        System.out.println(YELLOW_COLOR + "  [SIM] Iniciando simulación de Accidentes Viales..." + RESET_COLOR);
        return Flux.interval(Duration.ofMillis(800))
                .flatMap(tick -> {
                    String[] prioridades = {"Baja", "Media", "Alta"};
                    String prioridad = prioridades[RANDOM.nextInt(prioridades.length)];
                    if ("Alta".equals(prioridad)) {
                        return Mono.just(RED_COLOR + "🚑 Emergencia vial: Accidente con prioridad " + prioridad + RESET_COLOR);
                    }
                    return Mono.empty();
                });
    }

    public Flux<String> simularTrenesMaglev() {
        System.out.println(YELLOW_COLOR + "  [SIM] Iniciando simulación de Trenes Maglev..." + RESET_COLOR);
        return Flux.interval(Duration.ofMillis(700))
                .flatMap(tick -> {
                    int retraso = RANDOM.nextInt(11);
                    if (retraso > 5) {
                        return Mono.just(YELLOW_COLOR + "🚝 Tren maglev con retraso crítico: " + retraso + " minutos" + RESET_COLOR);
                    }
                    return Mono.empty();
                })
                .onBackpressureBuffer();
    }

    public Flux<String> simularSemaforosInteligentes() {
        System.out.println(YELLOW_COLOR + "  [SIM] Iniciando simulación de Semáforos Inteligentes..." + RESET_COLOR);
        AtomicInteger rojoConsecutivo = new AtomicInteger(0);

        return Flux.interval(Duration.ofMillis(400))
                .flatMap(tick -> {
                    String[] estados = {"Verde", "Amarillo", "Rojo"};
                    String estadoActual = estados[RANDOM.nextInt(estados.length)];

                    if ("Rojo".equals(estadoActual)) {
                        int count = rojoConsecutivo.incrementAndGet();
                        if (count >= 3) {
                            rojoConsecutivo.set(0);
                            return Mono.just(YELLOW_COLOR + "🚦 Semáforo en Rojo detectado " + count + " veces seguidas en cruce Norte" + RESET_COLOR);
                        }
                    } else {
                        rojoConsecutivo.set(0);
                    }
                    return Mono.empty(); 
                });
    }
}
