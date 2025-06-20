
public class OrdenPersonalizada extends OrdenProduccion {
    private String cliente;
    private double costoAdicionalAplicado = 0;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void aplicarCostoAdicional(int costo) {
        this.costoAdicionalAplicado = costo;
    }

    public double getCostoAdicionalAplicado() {
        return costoAdicionalAplicado;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("🛠️ OrdenPersonalizada - Código: " + codigo + " - Cantidad: " + cantidad + " - Cliente: " + cliente + (costoAdicionalAplicado > 0 ? " - Costo Adicional: $" + costoAdicionalAplicado : ""));
    }
}