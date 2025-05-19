package JavaCourse.Módulo1.sesion3.reto2;

public class Principal {
    public static void main(String[] args) {
      
        Factura facturaConRFC = new Factura(1000.0, "Compra de productos", "ABC123456789");
        System.out.println(facturaConRFC.getResumen());

        System.out.println(); 
        
        Factura facturaSinRFC = new Factura(500.0, "Servicio de limpieza", null);
        System.out.println(facturaSinRFC.getResumen());
    }
}
