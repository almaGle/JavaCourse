package Retos.sesion5.reto1;

public class CentralEmergencias {
    public static void main(String[] args) {
        // Crear instancias de las clases auxiliares
        SistemaGPS gpsAmbulancia = new SistemaGPS();
        Sirena sirenaAmbulancia = new Sirena();
        Operador operadorAmbulancia = new Operador("Dra. Ana");

        SistemaGPS gpsPatrulla = new SistemaGPS();
        Sirena sirenaPatrulla = new Sirena();
        Operador operadorPatrulla = new Operador("Oficial Carlos");

        SistemaGPS gpsBomberos = new SistemaGPS();
        Sirena sirenaBomberos = new Sirena();
        Operador operadorBomberos = new Operador("Capitán Benítez");

        // Crear instancias de las unidades de emergencia
        Ambulancia ambulancia = new Ambulancia("Ambulancia 1", gpsAmbulancia, sirenaAmbulancia, operadorAmbulancia);
        Patrulla patrulla = new Patrulla("Patrulla 5", gpsPatrulla, sirenaPatrulla, operadorPatrulla);
        UnidadBomberos bomberos = new UnidadBomberos("Bomberos Alfa", gpsBomberos, sirenaBomberos, operadorBomberos);

        System.out.println("--- Iniciando Operaciones ---");

        // Llamar al método iniciarOperacion() en cada unidad
        System.out.println("\nIniciando operación de la Ambulancia:");
        ambulancia.iniciarOperacion("Paciente con dificultad respiratoria");

        System.out.println("\nIniciando operación de la Patrulla:");
        patrulla.iniciarOperacion("Reporte de alteración del orden público");

        System.out.println("\nIniciando operación de la Unidad de Bomberos:");
        bomberos.iniciarOperacion("Alarma de incendio en edificio");
    }
}