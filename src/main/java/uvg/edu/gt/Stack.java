package uvg.edu.gt;

/**
 * Interfaz que define las operaciones básicas de una pila (stack).
 *
 * @param <E> Tipo de elementos almacenados en la pila.
 */
public interface Stack<E> {
    /**
     * Inserta un elemento en el tope de la pila.
     *
     * @param item Elemento a insertar.
     */
    void push(E item);

    /**
     * Remueve y retorna el elemento del tope de la pila.
     *
     * @return Elemento removido del tope de la pila.
     */
    E pop();

    /**
     * Mira el elemento del tope de la pila sin removerlo.
     *
     * @return Elemento en el tope de la pila.
     */
    E peek();

    /**
     * Comprueba si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario.
     */
    boolean isEmpty();

    /**
     * Obtiene el tamaño de la pila (cantidad de elementos).
     *
     * @return Tamaño de la pila.
     */
    int size();
}

