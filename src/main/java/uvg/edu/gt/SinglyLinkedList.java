package uvg.edu.gt;

/**
 * Implementación de una lista enlazada simple.
 *
 * @param <E> Tipo de elementos almacenados en la lista.
 */
public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head; // referencia al primer nodo de la lista
    private int size; // número de elementos en la lista

    /**
     * Constructor para crear una lista enlazada simple vacía.
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // Clase interna Node para SinglyLinkedList
    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    /**
     * Agrega un elemento en la posición especificada en la lista.
     *
     * @param element Elemento a agregar.
     * @param index   Índice donde se agregará el elemento.
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    @Override
    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = new Node<>(element, prev.next);
        }
        size++;
    }

    /**
     * Elimina y devuelve el elemento en la posición especificada en la lista.
     *
     * @param index Índice del elemento a eliminar.
     * @return Elemento eliminado.
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E element;
        if (index == 0) {
            element = head.element;
            head = head.next;
        } else {
            Node<E> prev = getNode(index - 1);
            element = prev.next.element;
            prev.next = prev.next.next;
        }
        size--;
        return element;
    }

    /**
     * Obtiene el elemento en la posición especificada en la lista.
     *
     * @param index Índice del elemento a obtener.
     * @return Elemento en la posición especificada.
     * @throws IndexOutOfBoundsException si el índice está fuera de los límites de la lista.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = getNode(index);
        return current.element;
    }

    /**
     * Obtiene el número de elementos en la lista.
     *
     * @return Número de elementos en la lista.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false de lo contrario.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Método auxiliar para obtener el nodo en el índice especificado.
     *
     * @param index Índice del nodo a obtener.
     * @return Nodo en el índice especificado.
     */
    private Node<E> getNode(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
