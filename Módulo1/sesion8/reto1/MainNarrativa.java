package JavaCourse.Módulo1.sesion8.reto1;

// Clase principal que simula el flujo narrativo.
// Depende de las interfaces (DIP) y coordina las acciones.
public class MainNarrativa {
    private TransicionHistoria transicionHistoria;
    private GestorDialogo gestorDialogo;
    private LogicaDecision logicaDecision;

    // Inyección de dependencias a través del constructor.
    // Esto permite que MainNarrativa sea flexible y acepte cualquier implementación
    // de las interfaces sin tener que modificarse a sí misma (OCP en acción).
    public MainNarrativa(TransicionHistoria transicionHistoria, GestorDialogo gestorDialogo, LogicaDecision logicaDecision) {
        this.transicionHistoria = transicionHistoria;
        this.gestorDialogo = gestorDialogo;
        this.logicaDecision = logicaDecision;
    }

    public void iniciarEscena() {
        System.out.println("\n--- INICIO DE LA SIMULACIÓN DE NARRATIVA ---");
        String escenaActual = "Bosque Misterioso";

        // Diálogo inicial
        gestorDialogo.mostrarDialogo("Narrador", "Te encuentras en un denso bosque, el sol apenas se filtra entre las copas de los árboles.");
        gestorDialogo.mostrarDialogo("Elfo Guardián", "¿Quién anda ahí? Identifícate o prepárate para las consecuencias.");

        // Decisión del jugador
        String decision = logicaDecision.tomarDecision(
            "¿Cómo respondes al Elfo Guardián?",
            "1. Declarar tu nombre y propósito.",
            "2. Intentar huir sigilosamente."
        );

        String siguienteEscena;
        if (decision.contains("1. Declarar")) {
            gestorDialogo.mostrarDialogo("Tú", "¡Soy " + "Tu Nombre" + " y busco el Cristal Lunar!");
            gestorDialogo.mostrarDialogo("Elfo Guardián", "El Cristal Lunar... Eres valiente, forastero. Sígueme.");
            siguienteEscena = "Camino Antiguo";
        } else { // if (decision.contains("2. Intentar huir"))
            gestorDialogo.mostrarDialogo("Tú", "(Intento escabullirme entre los arbustos...)");
            gestorDialogo.mostrarDialogo("Elfo Guardián", "¡No te irás tan fácil! ¡Por el bosque!");
            siguienteEscena = "Persecución por el Bosque";
        }

        // Transición de historia basada en la decisión
        transicionHistoria.siguienteEscena(escenaActual, siguienteEscena);

        // Diálogo de la siguiente escena (ejemplo)
        gestorDialogo.mostrarDialogo("Narrador", "Llegas a " + siguienteEscena + ".");
        if (siguienteEscena.equals("Camino Antiguo")) {
             gestorDialogo.mostrarDialogo("Elfo Guardián", "El camino es largo, mantente alerta.");
        } else {
             gestorDialogo.mostrarDialogo("Narrador", "Los pasos del elfo resuenan cerca. Debes pensar rápido.");
        }


        System.out.println("\n--- FIN DE LA SIMULACIÓN DE NARRATIVA ---");
    }

    public static void main(String[] args) {
        // Creación de las implementaciones concretas
        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo dialogo = new DialogoTexto();
        LogicaDecision decision = new DecisionBinaria();

        // Inyección de dependencias al crear la instancia de MainNarrativa
        MainNarrativa juego = new MainNarrativa(transicion, dialogo, decision);

        // Iniciar el flujo de la escena
        juego.iniciarEscena();
    }
}
