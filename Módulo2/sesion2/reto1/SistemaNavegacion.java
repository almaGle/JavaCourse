package Módulo2.sesion2.reto1;

import java.util.concurrent.Callable;

public class SistemaNavegacion implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1500); // 1.5 segundos
        return "🛰️ Navegación: trayectoria corregida con éxito.";
    }
}
