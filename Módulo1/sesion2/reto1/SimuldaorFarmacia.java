package JavaCourse.Módulo1.sesion2.reto1;
import java.util.Scanner;
public class SimuldaorFarmacia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del medicamento:");
        String nombreMedicamento = scanner.nextLine();
        System.out.println("Ingrese la cantidad del medicamento:");
        int cantidadMedicamento = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("Ingrese el precio del medicamento:");
        double precioMedicamento = scanner.nextDouble();    
        scanner.nextLine(); // Consumir el salto de línea pendiente

        double total = cantidadMedicamento * precioMedicamento;

        double descuento = total > 500 ? total * 0.15 : 0;
        double totalConDescuento = total - descuento;
        System.out.println("Nombre del medicamento: " + nombreMedicamento);
        System.out.println("Cantidad: " + cantidadMedicamento);
        System.out.println("Precio unitario: " + precioMedicamento);
        System.out.println("Total: " + total);
        System.out.println("Aplica descuento: " + (descuento > 0 ? "Sí" : "No"));
        System.out.println("Descuento: " + descuento);
        System.out.println("Total a pagar: " + totalConDescuento);
        scanner.close();
    }
}
