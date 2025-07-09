/**
 * ArrayIteration.java
 * 
 * This class demonstrates various array iteration techniques without using built-in functions.
 * Each method is thoroughly commented to explain the logic and implementation details.
 * 
 * Learning Objectives:
 * - Understand how to traverse arrays using different approaches
 * - Learn about index management and boundary conditions
 * - Practice implementing iteration patterns from scratch
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

public class ArrayIteration {
    
    /**
     * Method to perform forward iteration through an array
     * This traverses from index 0 to length-1
     * 
     * @param arr The input array to iterate through
     * @return void (prints each element)
     */
    public static void forwardIteration(int[] arr) {
        // Check if array is null to avoid NullPointerException
        if (arr == null) {
            System.out.println("Array is null");
            return;
        }
        
        System.out.print("Forward Iteration: ");
        
        // Classic for loop approach
        // i starts at 0 (first index)
        // continues while i is less than array length
        // increments i by 1 each time
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // New line after iteration
    }
    
    /**
     * Method to perform backward iteration through an array
     * This traverses from index length-1 to 0
     * 
     * @param arr The input array to iterate through
     * @return void (prints each element)
     */
    public static void backwardIteration(int[] arr) {
        // Check if array is null to avoid NullPointerException
        if (arr == null) {
            System.out.println("Array is null");
            return;
        }
        
        System.out.print("Backward Iteration: ");
        
        // Start from the last valid index (length - 1)
        // Continue while i is greater than or equal to 0
        // Decrement i by 1 each time
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // New line after iteration
    }
    
    /**
     * Method to perform conditional iteration
     * This demonstrates how to iterate while checking conditions
     * 
     * @param arr The input array to search through
     * @param target The value to search for
     * @return boolean indicating if target was found
     */
    public static boolean conditionalIteration(int[] arr, int target) {
        // Check if array is null to avoid NullPointerException
        if (arr == null) {
            System.out.println("Array is null");
            return false;
        }
        
        System.out.println("Searching for: " + target);
        
        // Iterate through array to find target
        for (int i = 0; i < arr.length; i++) {
            // Check current element against target
            if (arr[i] == target) {
                System.out.println("Found " + target + " at index " + i);
                return true; // Early termination when found
            }
        }
        
        System.out.println(target + " not found in array");
        return false; // Target not found after complete iteration
    }
    
    /**
     * Method to calculate sum using iteration
     * This demonstrates aggregation through iteration
     * 
     * @param arr The input array to sum
     * @return int representing the sum of all elements
     */
    public static int calculateSum(int[] arr) {
        // Check if array is null to avoid NullPointerException
        if (arr == null) {
            System.out.println("Array is null");
            return 0;
        }
        
        int sum = 0; // Initialize accumulator variable
        
        // Iterate through each element
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i]; // Add current element to sum
            // This could also be written as: sum += arr[i];
        }
        
        return sum; // Return accumulated sum
    }
    
    /**
     * Method to find maximum element using iteration
     * This demonstrates finding extremes through iteration
     * 
     * @param arr The input array to search
     * @return int representing the maximum value
     */
    public static int findMaximum(int[] arr) {
        // Check if array is null or empty
        if (arr == null || arr.length == 0) {
            System.out.println("Array is null or empty");
            return Integer.MIN_VALUE; // Return minimum possible value as indicator
        }
        
        // Assume first element is maximum
        int max = arr[0];
        
        // Start iteration from second element (index 1)
        for (int i = 1; i < arr.length; i++) {
            // If current element is greater than current max
            if (arr[i] > max) {
                max = arr[i]; // Update max to current element
            }
        }
        
        return max; // Return the maximum value found
    }
    
    /**
     * Method to demonstrate step-based iteration
     * This shows how to iterate with custom step sizes
     * 
     * @param arr The input array to iterate through
     * @param step The step size for iteration
     * @return void (prints every step-th element)
     */
    public static void stepIteration(int[] arr, int step) {
        // Check if array is null to avoid NullPointerException
        if (arr == null) {
            System.out.println("Array is null");
            return;
        }
        
        // Check if step is valid (positive)
        if (step <= 0) {
            System.out.println("Step must be positive");
            return;
        }
        
        System.out.print("Step Iteration (step=" + step + "): ");
        
        // Start at index 0 and increment by step each time
        for (int i = 0; i < arr.length; i += step) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // New line after iteration
    }
    
    /**
     * Method to demonstrate while loop iteration
     * This shows an alternative to for loops
     * 
     * @param arr The input array to iterate through
     * @return void (prints each element)
     */
    public static void whileLoopIteration(int[] arr) {
        // Check if array is null to avoid NullPointerException
        if (arr == null) {
            System.out.println("Array is null");
            return;
        }
        
        System.out.print("While Loop Iteration: ");
        
        int i = 0; // Initialize counter outside loop
        
        // Continue while counter is less than array length
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++; // Increment counter manually
        }
        System.out.println(); // New line after iteration
    }
    
    /**
     * Main method to demonstrate all iteration techniques
     * This serves as a comprehensive example of array iteration
     */
    public static void main(String[] args) {
        // Create a sample array for demonstration
        int[] sampleArray = {10, 25, 3, 47, 12, 89, 5, 33};
        
        System.out.println("=== ARRAY ITERATION DEMONSTRATIONS ===");
        System.out.println("Sample Array: [10, 25, 3, 47, 12, 89, 5, 33]");
        System.out.println();
        
        // Demonstrate forward iteration
        forwardIteration(sampleArray);
        
        // Demonstrate backward iteration
        backwardIteration(sampleArray);
        
        // Demonstrate conditional iteration
        conditionalIteration(sampleArray, 47);
        conditionalIteration(sampleArray, 100);
        
        // Demonstrate sum calculation
        int sum = calculateSum(sampleArray);
        System.out.println("Sum of all elements: " + sum);
        
        // Demonstrate finding maximum
        int max = findMaximum(sampleArray);
        System.out.println("Maximum element: " + max);
        
        // Demonstrate step iteration
        stepIteration(sampleArray, 2);
        stepIteration(sampleArray, 3);
        
        // Demonstrate while loop iteration
        whileLoopIteration(sampleArray);
        
        // Test with edge cases
        System.out.println("\n=== EDGE CASE TESTING ===");
        
        // Test with null array
        forwardIteration(null);
        
        // Test with empty array
        int[] emptyArray = {};
        forwardIteration(emptyArray);
        
        // Test with single element array
        int[] singleElement = {42};
        forwardIteration(singleElement);
        System.out.println("Single element max: " + findMaximum(singleElement));
    }
}
