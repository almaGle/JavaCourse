package JavaCourse.Módulo1.sesion5.reto1;

public class Ambulancia extends UnidadEmergencia {
    private SistemaGPS gps;
    private Sirena sirena;
    private Operador operador;

    public Ambulancia(String nombre, SistemaGPS gps, Sirena sirena, Operador operador) {
        super(nombre);
        this.gps = gps;
        this.sirena = sirena;
        this.operador = operador;
    }

    @Override
    public void responder(String emergencia) {
        System.out.println(nombre + ": Ambulancia en camino a la emergencia: " + emergencia + ". ¡Atención médica de urgencia!");
    }

    public void iniciarOperacion(String emergencia) {
        super.activarUnidad();
        gps.localizar();
        sirena.activarSirena();
        operador.reportarse();
        responder(emergencia);
    }
}