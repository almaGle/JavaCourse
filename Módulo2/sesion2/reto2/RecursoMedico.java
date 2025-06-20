package Módulo2.sesion2.reto2;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock; 

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
        this.lock = new ReentrantLock(); 
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Se simula el uso del recurso médico por un profesional.
     * Utiliza ReentrantLock para asegurar que solo un hilo acceda a la vez.
     *
     * @param profesional El nombre del profesional que intenta usar el recurso.
     */
    public void usar(String profesional) {
        // 1. Intentar adquirir el candado
        lock.lock(); // Este método bloquea el hilo si el candado ya está en uso

        try {
            // 2. Acceso a la sección crítica (solo un hilo a la vez aquí)
            System.out.println(profesional + " ha ingresado a " + nombre);

            // Simular el tiempo de uso del recurso
            Thread.sleep(1000 + (long) (Math.random() * 500)); // Uso aleatorio entre 1 y 1.5 segundos

            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            // Manejo de la interrupción del hilo mientras está en sleep
            Thread.currentThread().interrupt(); // Restaura el estado de interrupción
            System.err.println("❌ " + profesional + " fue interrumpido mientras usaba " + nombre);
        } finally {
            // 3. Liberar el candado en el bloque 'finally'
            // Esto asegura que el candado siempre se libere, incluso si ocurre una excepción.
            lock.unlock();
        }
    }
}