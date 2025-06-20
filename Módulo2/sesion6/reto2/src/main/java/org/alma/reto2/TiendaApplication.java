package org.alma.reto2;


import org.alma.reto2.model.Marca;
import org.alma.reto2.model.Producto;
import org.alma.reto2.repository.MarcaRepository;
import org.alma.reto2.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TiendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(ProductoRepository productoRepo, MarcaRepository marcaRepo) {
        return (args) -> {
            Marca apple = new Marca("Apple");
            Marca samsung = new Marca("Samsung");
            Marca xiaomi = new Marca("Xiaomi");

            marcaRepo.save(apple);
            marcaRepo.save(samsung);
            marcaRepo.save(xiaomi);

            System.out.println("--- Marcas iniciales guardadas ---");
            marcaRepo.findAll().forEach(System.out::println);
            System.out.println("\n");

            productoRepo.save(new Producto("iPhone 15", "Smartphone de última generación", 22000.00, apple));
            productoRepo.save(new Producto("iPad Pro M2", "Tablet potente con chip M2", 18000.00, apple));

            productoRepo.save(new Producto("Galaxy S24 Ultra", "Smartphone Android de gama alta", 18500.00, samsung));
            productoRepo.save(new Producto("Smart TV QLED 75\"", "Televisor 4K con tecnología QLED", 35000.00, samsung));

            productoRepo.save(new Producto("Redmi Note 13 Pro", "Smartphone con gran cámara", 5800.00, xiaomi));
            productoRepo.save(new Producto("Mi Band 8", "Pulsera inteligente con monitor de salud", 750.00, xiaomi));

            System.out.println("--- Productos con marcas asociadas guardados ---");
            productoRepo.findAll().forEach(System.out::println);
            System.out.println("\n");

            System.out.println("📚 Productos por marca:");
            marcaRepo.findAll().forEach(marca -> {
                System.out.println("🏷️ " + marca.getNombre() + ":");
                productoRepo.findAll().stream()
                    .filter(p -> p.getMarca() != null && p.getMarca().getId().equals(marca.getId()))
                    .forEach(p -> System.out.println("   - " + p.getNombre()));
            });
            System.out.println("\n");
        };
    }
}