package uvg.edu.gt;

import java.util.ArrayList;

public class ArrayListStack<E> implements Stack<E> {
    private ArrayList<E> stack;

    public ArrayListStack() {
        stack = new ArrayList<>();
    }

    @Override
    public void push(E item) {
        stack.add(item);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty.");
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    private static class EmptyStackException extends RuntimeException {
        public EmptyStackException(String message) {
            super(message);
        }
    }
}

