package Módulo2.sesion3.reto1;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConfirmadorPedidosPizzeria {

    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
            new Pedido("Juan Pérez", "domicilio", "555-1234"),
            new Pedido("Ana Gómez", "local", null), 
            new Pedido("Luis García", "domicilio", "555-5678"),
            new Pedido("Marta López", "domicilio", null),
            new Pedido("Carlos Ruiz", "local", "555-9999") 
        );

        System.out.println("📞 Confirmaciones de pedidos a domicilio:");

        pedidos.stream()
              // 1. Filtrar solo los pedidos que sean para entrega a "domicilio"
              .filter(pedido -> "domicilio".equalsIgnoreCase(pedido.getTipoEntrega()))
              // 2. Mapear cada pedido a su Optional<String> de teléfono
              // Esto nos da un Stream de Optional<String>
              .map(Pedido::getTelefono)
              // 3. Filtrar solo los Optional que contienen un valor (es decir, el teléfono no es nulo)
              .filter(Optional::isPresent)
              // 4. Extraer el valor String del Optional (ahora sabemos que es seguro)
              .map(Optional::get)
              // 5. Transformar cada número de teléfono en el mensaje de confirmación deseado
              .map(telefono -> "📞 Confirmación enviada al número: " + telefono)
              // 6. Mostrar cada mensaje en la consola
              .forEach(System.out::println);
    }
}