package JavaCourse.Módulo1.sesion5.reto1;

public class Patrulla extends UnidadEmergencia {
    private SistemaGPS gps;
    private Sirena sirena;
    private Operador operador;

    public Patrulla(String nombre, SistemaGPS gps, Sirena sirena, Operador operador) {
        super(nombre);
        this.gps = gps;
        this.sirena = sirena;
        this.operador = operador;
    }

    @Override
    public void responder(String emergencia) {
        System.out.println(nombre + ": Patrulla respondiendo a: " + emergencia + ". ¡Mantengan la calma, la ley está en camino!");
    }

    public void iniciarOperacion(String emergencia) {
        super.activarUnidad();
        gps.localizar();
        sirena.activarSirena();
        operador.reportarse();
        responder(emergencia);
    }
}
