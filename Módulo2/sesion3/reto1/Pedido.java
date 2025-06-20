package Módulo2.sesion3.reto1;

import java.util.Optional;

public class Pedido {
    private final String cliente;
    private final String tipoEntrega;
    private final String telefono;   

    public Pedido(String cliente, String tipoEntrega, String telefono) {
        this.cliente = cliente;
        this.tipoEntrega = tipoEntrega;
        this.telefono = telefono;
    }

    public String getCliente() {
        return cliente;
    }

    public String getTipoEntrega() {
        return tipoEntrega;
    }

    /**
     * Devuelve el número de teléfono envuelto en un Optional.
     * Esto evita NullPointerException si el teléfono es nulo.
     *
     * @return Un Optional que contiene el teléfono si no es nulo, o un Optional vacío.
     */
    public Optional<String> getTelefono() {
        return Optional.ofNullable(telefono);
    }
}