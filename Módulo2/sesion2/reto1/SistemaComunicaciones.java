package Módulo2.sesion2.reto1;

import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(800); // 0.8 segundos
        return "📡 Comunicaciones: enlace con estación terrestre establecido.";
    }
}
