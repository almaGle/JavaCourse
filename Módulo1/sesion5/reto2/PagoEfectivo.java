package Retos.sesion5.reto2;

public class PagoEfectivo extends MetodoPago implements Autenticable {
    public PagoEfectivo(double monto) {
        super(monto);
    }

    @Override
    public void procesarPago() {
        System.out.println("Procesando pago en efectivo por $" + monto + ".");
    }

    @Override
    public boolean autenticar() {
        System.out.println("Pago en efectivo autenticado.");
        return true; // El efectivo siempre se considera autenticado
    }
}

