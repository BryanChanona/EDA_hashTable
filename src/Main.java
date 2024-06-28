import models.Bussines;
import models.HashTable;
import models.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
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
        Node nodo =  tablaHash.busqueda("U41-TDkb3V8S8vEOCrpP7Q","Ironwood Golf Club", "10955 Fall Rd");

        if (nodo == null){
            System.out.println("No se encontró");
        } else{
            String name = nodo.getObjBusiness().getName();
            String adress = nodo.getObjBusiness().getAddress();
            System.out.println("El nombre es: " + name + ", con dirección: " + adress );
        }



    }
}