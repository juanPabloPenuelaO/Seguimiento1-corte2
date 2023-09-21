package Ejercicio3;

import Ejercicio3.DTO;
import Ejercicio3.Interface;
import Ejercicio3.Servicio;

import java.io.IOException;
import java.util.*;

public class MainAtencion {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        Interface repo = new Servicio();
        Scanner s = new Scanner(System.in);

        while (!opc.equals("5")) {
            System.out.println("Atencion al cliente");
            System.out.println("Ingrese su cedula:");
            Integer id = Integer.valueOf(s.next());
            System.out.println("""
                    que atención necesita solicitar?:\s
                     digite 1 para atención telefonica\s
                     digite 2 para asesoria a estudiante\s
                     digite 3 para asesoria a directivo\s
                     digite 4 para consultas estadisticas\s
                     digite 5 para Salir""");
            String elect = s.next();

            if (elect.equals("1")) {
                String tip = "telefonica";
                System.out.println("telefonica");
                repo.save(new DTO(id,tip));
                System.out.println("gracias por preferirnos");
            } else if (elect.equals("2") || elect.equals("3")) {
                String tip = elect.equals("2") ? "estudiantes" : "directivos";
                System.out.println("Asesoría" + (tip.equals("estudiantes") ? "Estudiantes" : "Directivos"));
                repo.save(new DTO(id,tip));
                System.out.println("quiere un cambio a servicio telefonico?");
                String decision = s.next().toLowerCase();
                if (!decision.equals("no")) {
                    String tipo = "Atencion diferente";
                    repo.update(new DTO(id,tipo));
                    System.out.println("Cambio exitoso!");
                } else {
                    System.out.println("Muchas gracias por preferirnos");
                }
            } else if (elect.equals("4")) {
                List<DTO> a = repo.findAll();
                List<DTO> b = new ArrayList<>();
                List<DTO> c = new ArrayList<>();
                List<DTO> d = new ArrayList<>();
                List<DTO> e = new ArrayList<>();
                b = a.stream().filter(x -> x.getTipAtencion().equalsIgnoreCase("estudiantes")).toList();
                c = a.stream().filter(x -> x.getTipAtencion().equalsIgnoreCase("directivos")).toList();
                e = a.stream().filter(x -> x.getTipAtencion().equalsIgnoreCase("telefonica")).toList();
                d = a.stream().filter(x -> x.getTipAtencion().equalsIgnoreCase("Atencion diferente")).toList();
                int estud = b.size();
                int direc = c.size();
                int atdif = d.size();
                int tel = e.size();
                int total = estud + direc + atdif + tel;
                System.out.println("estadisticas" +
                        "\nTelefonica:" + tel + "\nEstudiantes:" + estud + "\nDirectivos:" + direc +
                        "\nAtencion diferente:" + atdif + "\nTotal:" + total);
            } else if (elect.equals("5")) {
                opc = "5";
            }
        }
    }
}
