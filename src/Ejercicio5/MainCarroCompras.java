package Ejercicio5;

import Ejercicio5.DTO;
import Ejercicio5.Interface;
import Ejercicio5.Servicio;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainCarroCompras {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc;
        Interface repo = new Servicio();
        boolean salir = false;

        Scanner s = new Scanner(System.in);

        while (!salir) {
            System.out.println("Menu \n digite 1 para Agregar producto \n digite 2 para Listar producto \n digite 3 para ver el Total de compra \n digite 4 para Eliminar producto \n digite 5 para Salir");

            opc = s.next();

            if ("1".equals(opc)) {
                System.out.println("ingrese el Id del producto: ");
                Integer id = s.nextInt();
                System.out.println("ingrese el Nombre producto: ");
                String nom = s.next();
                System.out.println("ingrese el Precio ");
                Integer p = s.nextInt();
                System.out.println("que Cantidad llevará?: ");
                double ca = s.nextDouble();
                repo.save(new DTO(id, nom, p, ca));
            } else if ("2".equals(opc)) {
                List<DTO> carrito = repo.findall();
                if (!carrito.isEmpty()) {
                    carrito.forEach(System.out::println);
                } else {
                    System.out.println("No hay productos en el carrito");
                }
            } else if ("3".equals(opc)) {
                double total = repo.findall().stream().mapToDouble(DTO::getPrecio).sum();
                System.out.println("Total de compra:" + total);
            } else if ("4".equals(opc)) {
                System.out.println("Eliminar producto del carrito");
                System.out.println("Ingrese el id del producto a eliminar");
                Integer id = s.nextInt();
                repo.delete(repo.findById(id));
                repo.findall().forEach(System.out::println);
            } else if ("5".equals(opc)) {
                salir = true;
            } else {
                System.out.println("Opción no válida, por favor, ingrese una opción válida.");
            }
        }
    }
}
