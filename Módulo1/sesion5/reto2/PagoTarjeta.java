package JavaCourse.Módulo1.sesion5.reto2;

public class PagoTarjeta extends MetodoPago implements Autenticable {
    private double saldoDisponible;

    public PagoTarjeta(double monto, double saldoDisponible) {
        super(monto);
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando pago con tarjeta por $" + monto + ".");
        saldoDisponible -= monto;
        System.out.println("Saldo restante en tarjeta: $" + saldoDisponible);
    }

    @Override
    public boolean autenticar() {
        boolean fondosSuficientes = saldoDisponible >= monto;
        System.out.println("Validando fondos de la tarjeta: " + (fondosSuficientes ? "OK" : "Fondos insuficientes."));
        return fondosSuficientes;
    }
}
