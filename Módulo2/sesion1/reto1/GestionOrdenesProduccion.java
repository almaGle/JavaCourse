
import java.util.ArrayList;
import java.util.List;

public class GestionOrdenesProduccion {

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("\n📋 Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada) {
                OrdenPersonalizada orden = (OrdenPersonalizada) obj;
                orden.aplicarCostoAdicional(costoAdicional);
                System.out.println("✅ Orden " + orden.getCodigo() + " ajustada con costo adicional de $" + costoAdicional);
            }
        }
    }

    public static void contarOrdenesPorTipo(List<? extends OrdenProduccion> todasLasOrdenes) {
        int masaCount = 0;
        int personalizadaCount = 0;
        int prototipoCount = 0;

        for (OrdenProduccion orden : todasLasOrdenes) {
            if (orden instanceof OrdenMasa) {
                masaCount++;
            } else if (orden instanceof OrdenPersonalizada) {
                personalizadaCount++;
            } else if (orden instanceof OrdenPrototipo) {
                prototipoCount++;
            }
        }

        System.out.println("\n📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + masaCount);
        System.out.println("🛠️ Personalizadas: " + personalizadaCount);
        System.out.println("🧪 Prototipos: " + prototipoCount);
    }

    public static void main(String[] args) {
        List<OrdenMasa> ordenesMasa = new ArrayList<>();
        ordenesMasa.add(new OrdenMasa("A123", 500));
        ordenesMasa.add(new OrdenMasa("A124", 750));

        List<OrdenPersonalizada> ordenesPersonalizadas = new ArrayList<>();
        ordenesPersonalizadas.add(new OrdenPersonalizada("P456", 100, "ClienteX"));
        ordenesPersonalizadas.add(new OrdenPersonalizada("P789", 150, "ClienteY"));

        List<OrdenPrototipo> ordenesPrototipo = new ArrayList<>();
        ordenesPrototipo.add(new OrdenPrototipo("T789", 10, "Diseño"));
        ordenesPrototipo.add(new OrdenPrototipo("T790", 5, "Pruebas"));

        mostrarOrdenes(ordenesMasa);
        mostrarOrdenes(ordenesPersonalizadas);
        mostrarOrdenes(ordenesPrototipo);

        procesarPersonalizadas(ordenesPersonalizadas, 200);

        mostrarOrdenes(ordenesPersonalizadas);

        List<OrdenProduccion> todasLasOrdenes = new ArrayList<>();
        todasLasOrdenes.addAll(ordenesMasa);
        todasLasOrdenes.addAll(ordenesPersonalizadas);
        todasLasOrdenes.addAll(ordenesPrototipo);

        contarOrdenesPorTipo(todasLasOrdenes);
    }
}