package uvg.edu.gt;

// ConcreteDataStructureFactory.java
public class ConcreteDataStructureFactory implements DataStructureFactory {

    @Override
    public <E> Stack<E> createStack(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("ARRAYLIST")) {
            return new ArrayListStack<E>();
        } else if (type.equalsIgnoreCase("VECTOR")) {
            return new VectorStack<E>();
        }
        // Puedes agregar más condiciones para otros tipos de Stack
        return null;
    }

    @Override
    public <E> List<E> createList(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("SINGLYLINKEDLIST")) {
            return new SinglyLinkedList<E>();
        } else if (type.equalsIgnoreCase("DOUBLYLINKEDLIST")) {
            return new DoublyLinkedList<E>();
        }
        // Puedes agregar más condiciones para otros tipos de List
        return null;
    }
}
