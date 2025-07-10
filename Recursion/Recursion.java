/*
 * Recursion.java
 *
 * This file contains Java implementations of various recursion techniques and patterns
 * without using any built-in functions. Each section is thoroughly commented
 * to explain each step and logic behind the recursion process.
 *
 */

public class Recursion {
    
    // Direct Recursion Example
    public static int factorial(int n) {
        // Base case: if n is 0, the factorial is 1
        if (n == 0) return 1;
        // Recursive case: n * factorial of (n-1)
        return n * factorial(n - 1);
    }

    // Indirect Recursion Example
    public static void indirectA(int n) {
        if (n > 0) {
            System.out.println("A: " + n);
            indirectB(n - 1);
        }
    }

    public static void indirectB(int n) {
        if (n > 0) {
            System.out.println("B: " + n);
            indirectA(n - 2);
        }
    }

    // Tail Recursion Example
    public static void tailRec(int n, int result) {
        if (n == 0) {
            System.out.println("Result: " + result);
            return;
        }
        // Tail call optimization: recursive call is the last operation
        tailRec(n - 1, n + result);
    }

    public static void main(String[] args) {
        // Test the recursion methods
        System.out.println("Factorial of 5: " + factorial(5));
        indirectA(5);
        tailRec(5, 0);
    }
}

