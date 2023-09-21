package Ejercicio4;

import Ejercicio4.DTO;
import Ejercicio4.Interface;
import Ejercicio4.Servicio;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainTurno {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String opc = "1";
        Interface repo = new Servicio();
        Scanner s = new Scanner(System.in);

        while (!opc.equals("5")) {
            System.out.println("Menu \n" +
                    " digite 1 para Tomar un turno \n digite 2 para Llamar a un cliente  \n digite 3 para ver cuantos turnos faltan \n digite 4 para Salir");
            opc = s.next();

            if (opc.equals("1")) {
                System.out.println("Ingrese su nombre");
                String nom = s.next();
                System.out.println("Ingrese su numero de cedula");
                Integer ced = s.nextInt();
                repo.save(new DTO(nom, ced));
            }  else if (opc.equals("2")) {
                System.out.println("Ingrese su numero de cedula");
                Integer ced = s.nextInt();
                repo.delete(repo.findById(ced));
                repo.findAll().forEach(System.out::println);
            } else if (opc.equals("3")) {
                System.out.print("Turnos totales: " + repo.total());
            }
        }
    }
}
