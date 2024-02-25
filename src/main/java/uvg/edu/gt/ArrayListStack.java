
package uvg.edu.gt;

import java.util.ArrayList;

/**
 * Implementación de una pila utilizando un ArrayList.
 *
 * @param <E> Tipo de elementos almacenados en la pila.
 */
public class ArrayListStack<E> implements Stack<E> {
    /**
     * La pila se implementa utilizando un ArrayList.
     */
    private ArrayList<E> stack;

    /**
     * Construye una nueva pila vacía.
     */
    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    /**
     * Añade un elemento a la parte superior de la pila.
     *
     * @param item Elemento a añadir.
     */
    @Override
    public void push(E item) {
        stack.add(item);
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return Elemento eliminado de la parte superior de la pila.
     * @throws EmptyStackException si la pila está vacía.
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("La pila está vacía.");
        }
        return stack.remove(stack.size() - 1);
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return Elemento en la parte superior de la pila.
     * @throws EmptyStackException si la pila está vacía.
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException("La pila está vacía.");
        }
        return stack.get(stack.size() - 1);
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario.
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Devuelve el tamaño actual de la pila.
     *
     * @return Tamaño de la pila.
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * Excepción lanzada cuando se intenta realizar una operación en una pila vacía.
     */
    private static class EmptyStackException extends RuntimeException {
        /**
         * Construye una nueva excepción de pila vacía con el mensaje especificado.
         *
         * @param message Mensaje de error.
         */
        public EmptyStackException(String message) {
            super(message);
        }
    }
}


