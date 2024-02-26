package uvg.edu.gt;

import java.util.Scanner;

/**
 * Clase principal que permite al usuario ingresar una expresión matemática en notación infija,
 * elegir el tipo de implementación de Stack y List que desea usar, y luego muestra la expresión
 * en notación posfija y su resultado después de evaluarla.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConcreteDataStructureFactory factory = new ConcreteDataStructureFactory();

        // Solicitar al usuario que ingrese la expresión matemática infija
        System.out.println("Por favor, ingresa la expresión matemática en notación infija:");
        String infixExpression = scanner.nextLine();

        // Solicitar al usuario que elija la implementación de Stack
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
        String postfixExpression = calculator.convertToPostfix(infixExpression);
        int result = calculator.evaluatePostfix(postfixExpression);

        // Mostrar los resultados
        System.out.println("La expresión infija es: " + infixExpression);
        System.out.println("La expresión posfija es: " + postfixExpression);
        System.out.println("El resultado de evaluar la expresión es: " + result);

        scanner.close();
    }
}