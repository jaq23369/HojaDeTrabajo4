package uvg.edu.gt;

class Node<E> {
    E data;
    Node<E> next;
    Node<E> prev; // Solo para listas doblemente enlazadas

    Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null; // Inicializa prev a null para listas doblemente enlazadas
    }
}

