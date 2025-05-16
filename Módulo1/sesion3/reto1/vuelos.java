package Retos.sesion3.reto1;

public class vuelos {
    final String codigoVuelo;
    String destino;
    String HoraSalida;
    Pasajero asientoReservado;
    
    public vuelos(String codigoVuelo, String destino, String HoraSalida) {
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.HoraSalida = HoraSalida;
    }

    boolean reservarAsiento(String nombre) {
        if (asientoReservado == null) {
            asientoReservado = new Pasajero(nombre);
            return true;
        } else {
            return false;
        }
    }

    boolean reservarAsiento(String nombre, String pasaporte){
        if (asientoReservado == null) {
            asientoReservado = new Pasajero(nombre, pasaporte);
            return true;
        } else {
            return false;
        }
    }

    void cancelarReserva() {
        asientoReservado = null;
    }

    String obtenerIntinerario() {
        StringBuilder itinerario = new StringBuilder();
    
        itinerario.append("Vuelo: ").append(codigoVuelo).append("\n");
        itinerario.append("Destino: ").append(destino).append("\n");
        itinerario.append("Hora de salida: ").append(HoraSalida).append("\n");
        itinerario.append("Pasajero: ");
        if (asientoReservado != null) {
            itinerario.append(asientoReservado.nombre);
        } else {
            itinerario.append("No reservado");
        }
        itinerario.append("\n"); // Agregar una nueva línea al final, si lo deseas
    
        return itinerario.toString();
    }
}
