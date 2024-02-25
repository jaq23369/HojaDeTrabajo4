package uvg.edu.gt;


/**
 * Fábrica concreta que implementa la interfaz DataStructureFactory para crear estructuras de datos específicas.
 */
public class ConcreteDataStructureFactory implements DataStructureFactory {

    /**
     * Crea una instancia de la implementación adecuada de la interfaz Stack según el tipo especificado.
     *
     * @param type Tipo de estructura de datos de pila deseada.
     * @param <E>  Tipo de elementos almacenados en la pila.
     * @return Una instancia de la implementación adecuada de la interfaz Stack, o null si el tipo no es válido.
     */
    @Override
    public <E> Stack<E> createStack(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("ARRAYLIST")) {
            return new ArrayListStack<>();
        } else if (type.equalsIgnoreCase("VECTOR")) {
            return new VectorStack<>();
        }

        return null;
    }

    /**
     * Crea una instancia de la implementación adecuada de la interfaz List según el tipo especificado.
     *
     * @param type Tipo de estructura de datos de lista deseada.
     * @param <E>  Tipo de elementos almacenados en la lista.
     * @return Una instancia de la implementación adecuada de la interfaz List, o null si el tipo no es válido.
     */
    @Override
    public <E> List<E> createList(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("SINGLYLINKEDLIST")) {
            return new SinglyLinkedList<>();
        } else if (type.equalsIgnoreCase("DOUBLYLINKEDLIST")) {
            return new DoublyLinkedList<>();
        }
        
        return null;
    }
}
