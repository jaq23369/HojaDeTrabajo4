package uvg.edu.gt;

public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head; // referencia al primer nodo de la lista
    private int size; // número de elementos en la lista

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

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = getNode(index);
        return current.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Método auxiliar para obtener el nodo en el índice especificado
    private Node<E> getNode(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}
