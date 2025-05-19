package JavaCourse.Módulo1.sesion2.reto2;

import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner text = new Scanner (System.in);
        int saldo = 1000;
        int seleccion = 0;
        do{
            System.out.println("Bienvenido al cajero automático:");
            System.out.println("1: consultar saldo");
            System.out.println("2: Depositar dinero");
            System.out.println("3: Retirar dinero");
            System.out.println("4: Salir");

            System.out.println("Digite la operación que desea realizar:");
            seleccion = text.nextInt();
            text.nextLine(); // Consumir el salto de línea pendiente
            switch (seleccion) {
                case 1:
                    System.out.println("Tu saldo es: " + saldo);
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad que desea depositar: ");
                    int deposito = text.nextInt();
                    if (deposito<0){
                        System.out.println("Debe ingresar una cantidad mayor a 0");
                    } else {
                        saldo+=deposito;
                        System.out.println("Su deposito se ha realizado con exito");
                        System.out.println("Su saldo es: "+ saldo);
                    }
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad que desea retirar");
                    int retiro = text.nextInt();
                    if (saldo < retiro){
                        System.out.println("No tiene saldo suficiente para hacer el retiro, usted puede retirar hasta " + saldo);
                    }else {
                        saldo -=retiro;
                        System.out.println("Retiro realizado con exito");
                        System.out.println("su saldo es: " + saldo);
                    }
                    break;
                case 4:
                        System.out.println("Gracias por usar el cajero automatico");
                        break;
                default:
                System.out.println("Opcion invalida, seleccione una opcion de la lista para poder hacer una operación");
                    break;
                    
               

                 }
            }while (seleccion != 4); 
            
            text.close();  
        } 
    }
  

