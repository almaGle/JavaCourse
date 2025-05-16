package Retos.sesion1.reto2;

public class entrada {
    
    String nombreEvento;
    double precioEntrada;

    entrada(String nombreEvento, double precioEntrada) {
        this.nombreEvento = nombreEvento;
        this.precioEntrada = precioEntrada;
    }
    public void mostrarInformacion() {
        System.out.println("Nombre del evento: " + nombreEvento);
        System.out.println("Precio de la entrada: " + precioEntrada);
    }
}
