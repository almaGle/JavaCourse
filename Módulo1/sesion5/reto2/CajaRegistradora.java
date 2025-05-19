package JavaCourse.Módulo1.sesion5.reto2;

public class CajaRegistradora {
    public static void main(String[] args) {
        MetodoPago[] pagos = new MetodoPago[5];
        pagos[0] = new PagoEfectivo(25.50);
        pagos[1] = new PagoTarjeta(55.75, 100.00);
        pagos[2] = new PagoTransferencia(120.00, "1234567890");
        pagos[3] = new PagoTarjeta(100.00, 50.00); // Tarjeta con fondos insuficientes
        pagos[4] = new PagoTransferencia(30.00, "9876543210");

        System.out.println("--- Procesando Pagos ---");

        for (MetodoPago pago : pagos) {
            System.out.println("\nIntentando procesar pago:");
            if (pago instanceof Autenticable) {
                Autenticable autenticable = (Autenticable) pago;
                if (autenticable.autenticar()) {
                    pago.procesarPago();
                    pago.mostrarResumen();
                } else {
                    System.out.println("Pago no autenticado. No se puede procesar.");
                }
            } else {
                
                pago.procesarPago();
                pago.mostrarResumen();
            }
        }
    }
}