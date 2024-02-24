package uvg.edu.gt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConcreteDataStructureFactory factory = new ConcreteDataStructureFactory();

        String filePath = "expression.txt";
        String expression;
        try {
            expression = FileReaderImpl.readFile(filePath);
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            scanner.close();
            return;
        }

        System.out.println("Por favor, elige la implementación de Stack que deseas usar:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");

        String stackType = scanner.nextLine();
        Stack<Integer> stack = null;

        switch (stackType) {
            case "1":
                stack = factory.createStack("ARRAYLIST");
                break;
            case "2":
                stack = factory.createStack("VECTOR");
                break;
            case "3":
                System.out.println("Elige la implementación de List que deseas usar para el Stack:");
                System.out.println("1. Lista simplemente encadenada");
                System.out.println("2. Lista doblemente encadenada");
                String listType = scanner.nextLine();
                // Asumimos que la fábrica sabe qué hacer con estas entradas.
                stack = factory.createStack(listType.toUpperCase());
                break;
            default:
                System.out.println("Opción no válida. Saliendo del programa.");
                scanner.close();
                return;
        }

        Calculator calculator = Calculator.getInstance();
        String postfixExpression = calculator.convertToPostfix(expression);
        int result = calculator.evaluatePostfix(postfixExpression);

        System.out.println("La expresión infija es: " + expression);
        System.out.println("La expresión posfija es: " + postfixExpression);
        System.out.println("El resultado de evaluar la expresión es: " + result);

        scanner.close();
    }
}
