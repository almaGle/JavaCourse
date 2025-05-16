package Retos.sesion5.reto2;
import java.util.Random;

public class PagoTransferencia extends MetodoPago implements Autenticable {
    private String numeroCuenta;

    public PagoTransferencia(double monto, String numeroCuenta) {
        super(monto);
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public void procesarPago() {
        System.out.println("Iniciando transferencia bancaria por $" + monto + " a la cuenta " + numeroCuenta + ".");
        // Simulación de proceso de transferencia
        System.out.println("Transferencia completada.");
    }

    @Override
    public boolean autenticar() {
        // Simulación de validación bancaria externa (podría ser una llamada a un servicio)
        Random random = new Random();
        boolean validacionExitosa = random.nextBoolean();
        System.out.println("Simulando validación bancaria para transferencia: " + (validacionExitosa ? "Éxito." : "Fallida."));
        return validacionExitosa;
    }
}
