package uvg.edu.gt;

/**
 * Interfaz para una fábrica de estructuras de datos.
 */
public interface DataStructureFactory {
    /**
     * Crea una instancia de la implementación adecuada de la interfaz Stack según el tipo especificado.
     *
     * @param type Tipo de estructura de datos de pila deseada.
     * @param <E>  Tipo de elementos almacenados en la pila.
     * @return Una instancia de la implementación adecuada de la interfaz Stack, o null si el tipo no es válido.
     */
    <E> Stack<E> createStack(String type);

    /**
     * Crea una instancia de la implementación adecuada de la interfaz List según el tipo especificado.
     *
     * @param type Tipo de estructura de datos de lista deseada.
     * @param <E>  Tipo de elementos almacenados en la lista.
     * @return Una instancia de la implementación adecuada de la interfaz List, o null si el tipo no es válido.
     */
    <E> List<E> createList(String type);
}

