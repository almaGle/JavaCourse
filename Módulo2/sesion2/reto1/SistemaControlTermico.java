package Módulo2.sesion2.reto1;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1200); // 1.2 segundos
        return "🔥 Control térmico: temperatura estable (22°C).";
    }
}
