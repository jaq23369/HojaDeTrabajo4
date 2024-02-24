package uvg.edu.gt;

import java.util.Stack;

public class Calculator {
    private static Calculator instance;

    private Calculator() {
        // Constructor privado para el patrón Singleton
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    public String convertToPostfix(String infixExpression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
    
        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (stack.isEmpty()) {
                    // Manejar el error de paréntesis no balanceados
                    throw new RuntimeException("Expresión inválida: paréntesis no balanceados.");
                }
                stack.pop(); // pop the '('
            } else if (isOperator(c)) { // Asegúrate de que isOperator(char) esté implementado correctamente
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }
    
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                // Manejar el error de paréntesis no balanceados
                throw new RuntimeException("Expresión inválida: paréntesis no balanceados.");
            }
            postfix.append(stack.pop());
        }
    
        return postfix.toString();
    }
    
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    private int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
    

    public int evaluatePostfix(String postfixExpression) {
        Stack<Integer> stack = new Stack<>();
    
        for (char c : postfixExpression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0'); // Convertir char a int
            } else {
                if (stack.size() < 2) {
                    throw new RuntimeException("Expresión inválida para la evaluación.");
                }
                int val1 = stack.pop();
                int val2 = stack.pop();
                // Aquí, asegúrate de que la operación no cause una división por cero
                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;
                    case '-':
                        stack.push(val2 - val1);
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;
                    case '/':
                        if (val1 == 0) {
                            throw new RuntimeException("División por cero.");
                        }
                        stack.push(val2 / val1);
                        break;
                    default:
                        throw new RuntimeException("Operador desconocido: " + c);
                }
            }
        }
        return stack.pop();
    }
    
}