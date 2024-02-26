package uvg.edu.gt;

/**
 * Clase que representa un nodo en una estructura de datos.
 *
 * @param <E> Tipo de datos almacenados en el nodo.
 */
class Node<E> {
    E data; // Datos almacenados en el nodo
    Node<E> next; // Referencia al siguiente nodo
    Node<E> prev; // Referencia al nodo anterior (solo para listas doblemente enlazadas)

    /**
     * Constructor para crear un nuevo nodo con los datos especificados.
     *
     * @param data Datos a almacenar en el nodo.
     */
    Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null; // Inicializa prev a null para listas doblemente enlazadas
    }
}
