package uvg.edu.gt;

public interface List<E> {
    void add(E element, int index); // Añade un elemento en la posición especificada
    E remove(int index); // Remueve el elemento en la posición especificada
    E get(int index); // Obtiene el elemento en la posición especificada
    int size(); // Obtiene el tamaño de la lista (cantidad de elementos)
    boolean isEmpty(); // Comprueba si la lista está vacía
}

