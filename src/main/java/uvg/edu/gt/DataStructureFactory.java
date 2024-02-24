package uvg.edu.gt;

// DataStructureFactory.java
public interface DataStructureFactory {
    <E> Stack<E> createStack(String type);
    <E> List<E> createList(String type);
}

