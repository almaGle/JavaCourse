package Retos.sesion4.reto1;

public class factura {
    String folio;
    String cliente;
    double total;

    factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    public String toString() {
        return "Factura{" +
                "folio='" + folio + '\'' +
                ", cliente='" + cliente + '\'' +
                ", total=" + total +
                '}';
    }
    @Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    factura factura = (factura) obj;
    return this.folio.equals(factura.folio);
}

    public int hashCode() {
        int result;
        long temp;
        result = folio.hashCode();
        result = 31 * result + cliente.hashCode();
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
