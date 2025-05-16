package Retos.sesion3.reto2;
import java.util.Optional;

public class Factura {
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.rfc =  Optional.ofNullable(rfc);
    }
    public String getResumen(){
        
            return "Factura generada:\n" +
                   "Descripción: " + descripcion + "\n" +
                   "Monto: $" + monto + "\n" +
                   "RFC: " + rfc.orElse("[RFC: No proporcionado]");
        
    }
}
