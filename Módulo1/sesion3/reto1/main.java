package JavaCourse.Módulo1.sesion3.reto1;

public class main {
    public static void main (String[] args){
        Pasajero p1 = new Pasajero("Juan Perez", "ABC123456");
        System.out.println("Nombre: " + p1.getNombre());
        System.out.println("Pasaporte: " + p1.getPasaporte());
        
        Pasajero p2 = new Pasajero("Maria Lopez", "XYZ987654");
        System.out.println("Nombre: " + p2.getNombre());
        System.out.println("Pasaporte: " + p2.getPasaporte());

        vuelos v1 = new vuelos("Vuelo 101", "Cancún", "13:00");

        v1.reservarAsiento(p1.nombre);
        System.out.println("Reserva realizada para: " + p1.nombre);
        System.out.println(v1.obtenerIntinerario());
        v1.cancelarReserva();
        System.out.println("Reserva cancelada");
        System.out.println(v1.obtenerIntinerario());
        v1.reservarAsiento(p2.nombre, p2.pasaporte);
        System.out.println(v1.obtenerIntinerario());




    }
}
