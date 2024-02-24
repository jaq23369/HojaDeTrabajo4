package uvg.edu.gt;

public interface Stack<E> {
    void push(E item); // Inserta un elemento en el tope de la pila
    E pop(); // Remueve y retorna el elemento del tope de la pila
    E peek(); // Mira el elemento del tope de la pila sin removerlo
    boolean isEmpty(); // Comprueba si la pila está vacía
    int size(); // Obtiene el tamaño de la pila (cantidad de elementos)
}

