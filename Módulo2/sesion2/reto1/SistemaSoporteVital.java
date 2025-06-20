package Módulo2.sesion2.reto1;

import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000); // 1 segundo
        return "🧪 Soporte vital: presión y oxígeno dentro de parámetros normales.";
    }
}