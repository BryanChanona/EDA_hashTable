package models;

public class Node{

    Node next;
    Bussines objBusiness;

    public Node (Bussines objBusiness){
        this.objBusiness = objBusiness;
        this.next = null;
    }

    public Bussines getObjBusiness() {
        return objBusiness;
    }
}