package uvg.edu.gt;

/**
 * Implementación de una lista doblemente enlazada.
 *
 * @param <E> Tipo de elementos almacenados en la lista.
 */
public class DoublyLinkedList<E> implements List<E> {

    private Node<E> head; // Referencia al primer nodo de la lista
    private Node<E> tail; // Referencia al último nodo de la lista
    private int size; // Número de elementos en la lista

    /**
     * Construye una lista doblemente enlazada vacía.
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Clase interna Node para DoublyLinkedList.
     */
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Añade un elemento en la posición especificada.
     *
     * @param element Elemento a añadir.
     * @param index   Índice en el que se añadirá el elemento.
     * @throws IndexOutOfBoundsException Si el índice está fuera de rango.
     */
    @Override
    public void add(E element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    /**
     * Elimina el elemento en la posición especificada.
     *
     * @param index Índice del elemento a eliminar.
     * @return El elemento eliminado.
     * @throws IndexOutOfBoundsException Si el índice está fuera de rango.
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return unlink(node(index));
    }

    /**
     * Obtiene el elemento en la posición especificada.
     *
     * @param index Índice del elemento a obtener.
     * @return El elemento en la posición especificada.
     * @throws IndexOutOfBoundsException Si el índice está fuera de rango.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return node(index).element;
    }

    /**
     * Obtiene el tamaño de la lista.
     *
     * @return Tamaño de la lista.
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

    // Enlaza el elemento como último elemento
    private void linkLast(E e) {
        final Node<E> l = tail;
        final Node<E> newNode = new Node<>(l, e, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    // Enlaza el elemento justo antes del nodo succ
    private void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            head = newNode;
        else
            pred.next = newNode;
        size++;
    }

    // Desenlaza el nodo no nulo x
    private E unlink(Node<E> x) {
        final E element = x.element;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.element = null;
        size--;
        return element;
    }

    // Devuelve el nodo en el índice especificado
    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
}
