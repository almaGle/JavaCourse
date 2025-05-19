package JavaCourse.Módulo1.sesion1.reto1;
import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        Scanner text = new Scanner(System.in);
        Paciente p1 = new Paciente();
        System.out.println("Ingrese el nombre del paciente");
        p1.name=text.nextLine();
        System.out.println("Ingrese la edad del paciente");
        p1.age=  text.nextInt();
        text.nextLine();
        System.out.println("Ingrese el expediente del paciente");
        p1.exp= text.nextLine();
        text.close();
        p1.mostrarInformacion();
    }
}