package org.alma.reto1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductoRepository repository) {
        return (args) -> {
            repository.save(new Producto("Laptop Lenovo", "Potente portátil para trabajo y gaming", 12500.00));
            repository.save(new Producto("Mouse Inalámbrico", "Logitech de alta precisión", 350.00));
            repository.save(new Producto("Teclado Mecánico", "Con switches Cherry MX Blue", 950.00));
            repository.save(new Producto("Monitor Curvo", "Ultra-wide de 34 pulgadas", 3200.00));
            repository.save(new Producto("Auriculares Bluetooth", "Cancelación de ruido activa", 700.00)); // Quinto producto

            System.out.println("--- Productos iniciales guardados ---");
            repository.findAll().forEach(System.out::println);
            System.out.println("\n");

            System.out.println("📦 Productos con precio mayor a 500:");
            repository.findByPrecioGreaterThan(500.00).forEach(System.out::println);
            System.out.println("\n");

            System.out.println("🔍 Productos que contienen 'lap':");
            repository.findByNombreContainingIgnoreCase("lap").forEach(System.out::println);
            System.out.println("\n");

            System.out.println("🎯 Productos con precio entre 400 y 1000:");
            repository.findByPrecioBetween(400.00, 1000.00).forEach(System.out::println);
            System.out.println("\n");

            System.out.println("📘 Productos cuyo nombre empieza con 'm':");
            repository.findByNombreStartingWithIgnoreCase("m").forEach(System.out::println);
            System.out.println("\n");

            
        };
    }
}