package Retos.sesion5.reto1;

public abstract class UnidadEmergencia {
    protected String nombre;

    public UnidadEmergencia(String nombre) {
        this.nombre = nombre;
    }
    public abstract void responder(String emergencia);

    public void activarUnidad() {
        System.out.println("🚑 Unidad de emergencia activada");
    }
}
