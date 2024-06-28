package models;

public class HashTable {
    LinkedList[] linkedList = new LinkedList[100003];

    public void insercion(String id, Bussines objBusiness) {
        int indiceReferencia = this.convertirASCII(id);
        int espacioTablaHash = this.hashDivision(indiceReferencia);


        if (this.linkedList[espacioTablaHash] == null) {
            this.linkedList[espacioTablaHash] = new LinkedList();
        }

        this.linkedList[espacioTablaHash].push(objBusiness);
    }

    public int convertirASCII(String id) {
        int suma = 0;

        for (int i = 0; i < id.length(); i++) {
            char caracter = id.charAt(i);
            int valorASCCI = (int) caracter;
            suma += valorASCCI;
        }

        return suma;
    }

    public int hashDivision(int indiceReferencia) {
        int clave = indiceReferencia % this.linkedList.length;
        return clave;
    }

    public int hashMultiplicacion(int indiceReferencia) {
        double aurea = 0.3565;
        double producto = (this.linkedList.length * ((indiceReferencia * aurea) % 1));

        int clave = (int) producto;
        return clave;
    }

    public Node busqueda(String clave, String name, String address) {
        int referencia = this.convertirASCII(clave);
        int espacioTabla = this.hashDivision(referencia);

        for (int i = 0; i < this.linkedList.length; i++) {
            if (this.linkedList[i] != null) {
                if (i == espacioTabla) {
                    for (int j = 0; j < this.linkedList[i].size(); j++) {
                        Node nodoBuscar = this.linkedList[i].getElementAt(j);
                        if (nodoBuscar.getObjBusiness().getName().equals(name) && nodoBuscar.getObjBusiness().getAddress().equals(address)) {
                            return nodoBuscar;
                        }
                    }
                }
            }
        }
        return null;
    }

}