import models.Bussines;
import models.HashTable;
import models.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable tablaHash = new HashTable();

        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
            while ((line = br.readLine()) != null)
            {
                String[] bussines = line.split(splitBy);
                String name = bussines[1];
                String address = bussines[2];
                String city = bussines[3];
                String state = bussines[4];
                Bussines objBusiness = new Bussines(name,address,city,state);
                tablaHash.insercion(bussines[0],objBusiness);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("Escriba clave del registro: ");
        String clave = scanner.nextLine();
        System.out.println("Nombre del registro: ");
        String nombre = scanner.nextLine();
        System.out.println("Dirección del registro: ");
        String address = scanner.nextLine();


        Node nodo =  tablaHash.busqueda(clave,nombre,address);

        if (nodo == null){
            System.out.println("No se encontró");
        } else{
            String name = nodo.getObjBusiness().getName();
            String adress = nodo.getObjBusiness().getAddress();
            String city = nodo.getObjBusiness().getCity();
            String state = nodo.getObjBusiness().getState();
            System.out.println("El nombre es: " + name + ", con dirección: " + adress + " , ciudad: " +city+" , Estado: "+ state );
        }



    }
}