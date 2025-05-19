package JavaCourse.Módulo1.sesion4.reto2;


    public class Main {
    public static void main(String[] args) {
        // Crea una declaración de impuestos
        DeclaracionImpuestos declaracion = new DeclaracionImpuestos("ABC123456XYZ", 1500.75);
        System.out.println("Información de la Declaración de Impuestos:");
        System.out.println("RFC del Contribuyente: " + declaracion.rfcContribuyentes());
        System.out.println("Monto Declarado: $" + declaracion.montoDeclarado());
        System.out.println();

        // Crea una cuenta fiscal
        try {
            cuentaFiscal cuenta = new cuentaFiscal("ABC123456XYZ", 5000.50);
            System.out.println("Información de la Cuenta Fiscal:");
            System.out.println("RFC de la Cuenta: " + cuenta.getRfc());
            System.out.println("Saldo Disponible: $" + cuenta.getSaldoDisponible());
            System.out.println();

            // Valida si el RFC coincide
            boolean rfcCoincide = cuenta.validarRFC(declaracion);
            if (rfcCoincide) {
                System.out.println("El RFC de la cuenta fiscal coincide con el RFC de la declaración de impuestos.");
            } else {
                System.out.println("El RFC de la cuenta fiscal NO coincide con el RFC de la declaración de impuestos.");
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Error al crear la cuenta fiscal: " + e.getMessage());
        }

        // Ejemplo con RFC diferente
        try {
            cuentaFiscal otraCuenta = new cuentaFiscal("DEF789012UVW", 10000.00);
            boolean rfcCoincideOtraCuenta = otraCuenta.validarRFC(declaracion);
            System.out.println("\nValidación con otra cuenta fiscal:");
            if (rfcCoincideOtraCuenta) {
                System.out.println("El RFC de la otra cuenta fiscal coincide con el RFC de la declaración de impuestos.");
            } else {
                System.out.println("El RFC de la otra cuenta fiscal NO coincide con el RFC de la declaración de impuestos.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error al crear la otra cuenta fiscal: " + e.getMessage());
        }
    }
}

