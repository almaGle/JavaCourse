package JavaCourse.Módulo1.sesion4.reto1;

public class principal {
    public static void main(String[] args) {
        factura f1 = new factura("F001", "Cliente A", 100.0);
        factura f2 = new factura("F001", "Cliente B", 200.0);

    System.out.println(f1.toString());
    System.out.println(f2.toString());

    System.out.println("¿Son iguales? " + f1.equals(f2));}
}
