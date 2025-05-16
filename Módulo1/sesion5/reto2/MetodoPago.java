package Retos.sesion5.reto2;

public abstract class MetodoPago {
    protected double monto;

    public MetodoPago(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    // Método abstracto
    public abstract void procesarPago();

    // Método concreto
    public void mostrarResumen() {
        System.out.println("Tipo de pago: " + this.getClass().getSimpleName());
        System.out.println("Monto: $" + monto);
    }
}
