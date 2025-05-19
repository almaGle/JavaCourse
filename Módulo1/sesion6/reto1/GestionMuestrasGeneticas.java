import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class GestionMuestrasGeneticas {

    public static void main(String[] args) {

        // Paso 1: ArrayList para registrar todas las especies en orden de llegada
        // Este ArrayList guardará cada muestra tal como llega, permitiendo duplicados.
        ArrayList<String> ordenLlegadaMuestras = new ArrayList<>();
        ordenLlegadaMuestras.add("Homo sapiens");
        ordenLlegadaMuestras.add("Mus musculus");
        ordenLlegadaMuestras.add("Arabidopsis thaliana");
        ordenLlegadaMuestras.add("Homo sapiens");
        ordenLlegadaMuestras.add("Danio rerio");
        ordenLlegadaMuestras.add("Saccharomyces cerevisiae");

        // Paso 2: HashSet para filtrar especies únicas
        // El HashSet eliminará automáticamente los duplicados, dejando solo las especies únicas.
        HashSet<String> especiesUnicas = new HashSet<>();
        especiesUnicas.addAll(ordenLlegadaMuestras); // Agregamos todas las muestras al HashSet para obtener las únicas

        // Paso 3: HashMap para asociar ID de muestra con investigador
        // Este HashMap almacenará pares clave-valor, donde la clave es el ID de la muestra
        // y el valor es el nombre del investigador responsable.
        HashMap<String, String> muestraInvestigador = new HashMap<>();
        muestraInvestigador.put("M-001", "Dra. López");
        muestraInvestigador.put("M-002", "Dr. Hernández");
        muestraInvestigador.put("M-003", "Biól. García");
        muestraInvestigador.put("M-004", "Ing. Rodríguez");
        muestraInvestigador.put("M-005", "Dra. López"); // Ejemplo de mismo investigador para diferentes muestras
        muestraInvestigador.put("M-006", "Dr. Hernández");

        // Paso 4: Mostrar resultados

        // Mostrar la lista completa y ordenada de muestras
        System.out.println("--- Orden de llegada de las muestras ---");
        for (int i = 0; i < ordenLlegadaMuestras.size(); i++) {
            System.out.println((i + 1) + ". " + ordenLlegadaMuestras.get(i));
        }
        System.out.println(); // Salto de línea para mejor legibilidad

        // Mostrar las especies únicas procesadas
        System.out.println("--- Especies únicas procesadas ---");
        for (String especie : especiesUnicas) {
            System.out.println("- " + especie);
        }
        System.out.println();

        // Mostrar la relación de ID de muestra -> investigador
        System.out.println("--- Relación ID de Muestra -> Investigador ---");
        for (String idMuestra : muestraInvestigador.keySet()) {
            System.out.println("ID: " + idMuestra + " -> Investigador: " + muestraInvestigador.get(idMuestra));
        }
        System.out.println();

        // Realizar una búsqueda por ID de muestra
        String idBuscado = "M-002";
        System.out.println("--- Búsqueda de Investigador por ID de Muestra (" + idBuscado + ") ---");
        if (muestraInvestigador.containsKey(idBuscado)) {
            System.out.println("El investigador responsable de la muestra " + idBuscado + " es: " + muestraInvestigador.get(idBuscado));
        } else {
            System.out.println("El ID de muestra " + idBuscado + " no fue encontrado.");
        }

        System.out.println(); // Salto de línea final
        // Realizar otra búsqueda por ID de muestra que no existe
        String idNoExistente = "M-999";
        System.out.println("--- Búsqueda de Investigador por ID de Muestra (" + idNoExistente + ") ---");
        if (muestraInvestigador.containsKey(idNoExistente)) {
            System.out.println("El investigador responsable de la muestra " + idNoExistente + " es: " + muestraInvestigador.get(idNoExistente));
        } else {
            System.out.println("El ID de muestra " + idNoExistente + " no fue encontrado.");
        }
    }
}