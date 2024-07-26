package models;

public class HashTable {
    int SIZE = 50021;
    private LinkedList[] linkedListDiv = new LinkedList[SIZE];
    private LinkedList[] linkedListMul = new LinkedList[SIZE];

    public void insercion(int opcion, String id, Bussines objBusiness) {
        int indiceReferencia = convertirASCII(id);
        int espacioTablaHashDiv = hashDivision(indiceReferencia);
        int espacioTablaHashMult = hashMultiplicacion(indiceReferencia);

        switch (opcion) {
            case 1:
                if (linkedListDiv[espacioTablaHashDiv] == null) {
                    linkedListDiv[espacioTablaHashDiv] = new LinkedList();
                }
                linkedListDiv[espacioTablaHashDiv].push(objBusiness);
                break;

            case 2:
                if (linkedListMul[espacioTablaHashMult] == null) {
                    linkedListMul[espacioTablaHashMult] = new LinkedList();
                }
                linkedListMul[espacioTablaHashMult].push(objBusiness);
                break;

            default:
                throw new IllegalArgumentException("Opción no válida");
        }
    }

    public int convertirASCII(String id) {
        int suma = 0;
        for (int i = 0; i < id.length(); i++) {
            suma += (int) id.charAt(i);
        }
        return suma;
    }

    public int hashDivision(int indiceReferencia) {
        return indiceReferencia % SIZE;
    }

    public int hashMultiplicacion(int indiceReferencia) {
        double aurea = 0.3565;
        double producto = (SIZE * ((indiceReferencia * aurea) % 1));
        return (int) producto;
    }

    public Node busqueda(int opcion, String clave) {
        int referencia = convertirASCII(clave);
        int espacioTablaHashDiv = hashDivision(referencia);
        int espacioTablaHashMult = hashMultiplicacion(referencia);
        long timeInicio = System.nanoTime();
        Node nodoEncontrado = null;

        switch (opcion) {
            case 1:
                if (linkedListDiv[espacioTablaHashDiv] != null) {
                    nodoEncontrado = buscarEnLista(linkedListDiv[espacioTablaHashDiv], clave);
                }
                break;

            case 2:
                if (linkedListMul[espacioTablaHashMult] != null) {
                    nodoEncontrado = buscarEnLista(linkedListMul[espacioTablaHashMult], clave);
                }
                break;

            default:
                throw new IllegalArgumentException("Opción no válida");
        }

        long timeFinal = System.nanoTime();
        double seconds = (timeFinal - timeInicio) / 1_000_000.0;
        System.out.println("El tiempo de ejecución fue: " + seconds);
        return nodoEncontrado;
    }

    private Node buscarEnLista(LinkedList list, String clave) {
        for (int i = 0; i < list.size(); i++) {
            Node nodoBuscar = list.getElementAt(i);
            if (nodoBuscar.getObjBusiness().getId().equals(clave)) {
                return nodoBuscar;
            }
        }
        return null;
    }
}
