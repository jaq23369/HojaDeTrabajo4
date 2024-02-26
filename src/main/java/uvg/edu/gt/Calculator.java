package uvg.edu.gt;

import java.util.Stack;

/**
 * Clase que proporciona métodos para convertir una expresión infija a posfija y para evaluar una expresión posfija.
 */
public class Calculator {
    private static Calculator instance;

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private Calculator() {
        // Constructor privado para el patrón Singleton
    }

    /**
     * Método estático para obtener la instancia única de Calculator utilizando el patrón Singleton.
     *
     * @return La instancia única de Calculator.
     */
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    /**
     * Convierte una expresión infija en una expresión posfija.
     *
     * @param infixExpression Expresión infija a convertir.
     * @return Expresión posfija.
     * @throws RuntimeException si la expresión contiene paréntesis no balanceados.
     */
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
                    throw new RuntimeException("Expresión inválida: paréntesis no balanceados.");
                }
                stack.pop(); // pop el '('
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                throw new RuntimeException("Expresión inválida: paréntesis no balanceados.");
            }
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    /**
     * Evalúa una expresión posfija y devuelve el resultado.
     *
     * @param postfixExpression Expresión posfija a evaluar.
     * @return Resultado de la evaluación de la expresión posfija.
     * @throws RuntimeException si la expresión posfija es inválida o si hay una división por cero.
     */
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

    /**
     * Verifica si un carácter es un operador matemático válido.
     *
     * @param c Carácter a verificar.
     * @return true si el carácter es un operador válido, false de lo contrario.
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Obtiene la precedencia de un operador.
     *
     * @param ch Operador para el cual se desea obtener la precedencia.
     * @return La precedencia del operador.
     */
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
}