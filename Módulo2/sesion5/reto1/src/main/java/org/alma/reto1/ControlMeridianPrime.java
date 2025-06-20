package org.alma.reto1;

import reactor.core.publisher.Flux;
import java.time.Duration;

public class ControlMeridianPrime {

    private static final String RESET_COLOR = "\u001B[0m";
    private static final String RED_COLOR = "\u001B[31m";
    private static final String YELLOW_COLOR = "\u001B[33m";

    public static void main(String[] args) throws InterruptedException {
        System.out.println(YELLOW_COLOR + "⚡ Iniciando el sistema de gestión de Meridian Prime..." + RESET_COLOR + "\n");

        MeridianPrimeSimulator simulator = new MeridianPrimeSimulator();

        Flux<String> traficoFlux = simulator.simularTrafico();
        Flux<String> contaminacionFlux = simulator.simularContaminacion();
        Flux<String> accidentesFlux = simulator.simularAccidentesViales();
        Flux<String> trenesFlux = simulator.simularTrenesMaglev();
        Flux<String> semaforosFlux = simulator.simularSemaforosInteligentes();

        traficoFlux.subscribe(
            System.out::println,
            error -> System.err.println(RED_COLOR + "🚨 Error en sensores de tráfico: " + error.getMessage() + RESET_COLOR));

        contaminacionFlux.subscribe(
            System.out::println,
            error -> System.err.println(RED_COLOR + "🚨 Error en monitoreo de contaminación: " + error.getMessage() + RESET_COLOR));

        accidentesFlux.subscribe(
            System.out::println,
            error -> System.err.println(RED_COLOR + "🚨 Error en detección de accidentes: " + error.getMessage() + RESET_COLOR));

        trenesFlux.subscribe(
            System.out::println,
            error -> System.err.println(RED_COLOR + "🚨 Error en control de trenes: " + error.getMessage() + RESET_COLOR));

        semaforosFlux.subscribe(
            System.out::println,
            error -> System.err.println(RED_COLOR + "🚨 Error en sistema de semáforos: " + error.getMessage() + RESET_COLOR));

        Flux<String> todosLosEventosCriticos = Flux.merge(
                traficoFlux,
                contaminacionFlux,
                accidentesFlux,
                trenesFlux,
                semaforosFlux
            )
            .publish()     
            .autoConnect(0); 

        todosLosEventosCriticos
            .window(Duration.ofSeconds(1)) 
            .flatMap(window -> window.count()) 
            .filter(count -> count >= 3) 
            .subscribe(count -> System.out.println(RED_COLOR + "\n🚨 ALERTA GLOBAL: " + count + " o más eventos críticos simultáneos detectados en Meridian Prime!" + RESET_COLOR));

        Thread.sleep(20000); 
        System.out.println(YELLOW_COLOR + "\n🚫 Deteniendo el sistema de gestión de Meridian Prime." + RESET_COLOR);
    }
}
