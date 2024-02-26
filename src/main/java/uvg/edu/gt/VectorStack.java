package uvg.edu.gt;

import java.util.Vector;

/**
 * Implementación de una pila (stack) utilizando la clase Vector de Java.
 *
 * @param <E> Tipo de elementos almacenados en la pila.
 */
public class VectorStack<E> implements Stack<E> {
    private Vector<E> stack;

    /**
     * Constructor para crear una pila vacía utilizando Vector.
     */
    public VectorStack() {
        stack = new Vector<>();
    }

    /**
     * Inserta un elemento en el tope de la pila.
     *
     * @param item Elemento a insertar.
     */
    @Override
    public void push(E item) {
        stack.add(item);
    }

    /**
     * Remueve y retorna el elemento del tope de la pila.
     *
     * @return Elemento removido del tope de la pila.
     * @throws EmptyStackException si la pila está vacía.
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * Mira el elemento del tope de la pila sin removerlo.
     *
     * @return Elemento en el tope de la pila.
     * @throws EmptyStackException si la pila está vacía.
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }
        return stack.get(stack.size() - 1);
    }

    /**
     * Comprueba si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario.
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Obtiene el tamaño de la pila (cantidad de elementos).
     *
     * @return Tamaño de la pila.
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * Excepción personalizada para indicar que la pila está vacía.
     */
    private static class EmptyStackException extends RuntimeException {
        public EmptyStackException(String message) {
            super(message);
        }
    }
}