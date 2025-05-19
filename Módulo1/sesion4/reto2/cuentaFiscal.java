package JavaCourse.Módulo1.sesion4.reto2;
import java.util.Objects;

public class cuentaFiscal {
    private final String rfc;
    private double saldoDisponible;

    public cuentaFiscal(String rfc, double saldoDisponible) {
        Objects.requireNonNull(rfc, "El RFC no puede ser nulo.");
        if (saldoDisponible < 0) {
            throw new IllegalArgumentException("El saldo disponible no puede ser negativo.");
        }
        this.rfc = rfc;
        this.saldoDisponible = saldoDisponible;
    }

    public String getRfc() {
        return rfc;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public boolean validarRFC(DeclaracionImpuestos d) {
        return Objects.equals(this.rfc, d.rfcContribuyentes());
    }
}

