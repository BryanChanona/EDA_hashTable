package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashTable tablaHash = new HashTable();
        menu(tablaHash);
    }

    public static void menu(HashTable tablaHash) {
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        System.out.println("<----------------------- BIENVENIDO -------------------------------->");

        do {
            do {
                System.out.println("\n¿POR QUÉ MÉTODO LE GUSTARÍA REALIZAR LA BÚSQUEDA? \n\n \n1.DIVISIÓN \n2.MULTIPLICACIÓN ");


                opcion = entrada.nextInt();

                if (opcion < 1 || opcion > 4) {
                    System.out.println("INGRESE NÚMEROS VÁLIDOS");

                }

            } while (opcion < 1 || opcion > 4);

            entrada.nextLine();

            leerArchivoCsv(tablaHash, opcion);

            System.out.print("INGRESE EL ID DE DICHO ELEMENTO: ");


            String id = entrada.nextLine();

            Node nodo = tablaHash.busqueda(opcion, id);

            if (nodo == null) {
                System.out.println("No existe dicho elemento");
            } else {
                System.out.println("\nDatos de ese objeto { " +
                        "\nNombre: " + nodo.getObjBusiness().getName() +
                        "\nDirección: " + nodo.getObjBusiness().getAddress() +
                        "\nCiudad: " + nodo.getObjBusiness().getCity() +
                        "\nEstado: " + nodo.getObjBusiness().getState() +
                        "\n}");
            }


            System.out.println("\n¿DESEA SEGUIR BUSCANDO DICHOS ELEMENTOS? 1.Si 2.No");
           

            opcion = entrada.nextInt();

            entrada.nextLine();

        } while (opcion != 2);
    }

    public static void leerArchivoCsv(HashTable tablaHash, int opcion) {
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader("bussines.csv"))) {
            while ((line = br.readLine()) != null) {
                String[] bussines = line.split(splitBy);
                String id = bussines[0], name = bussines[1], address = bussines[2], city = bussines[3], state = bussines[4];
                Bussines objBusiness = new Bussines(id, name, address, city, state);
                tablaHash.insercion(opcion, id, objBusiness);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
* mWMc6_wTdE0EUBKIGXDVfA
* CF33F8-E6oudUQ46HnavjQ
* n_0UpQx1hsNbnPUSlodU8w*/