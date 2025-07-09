/**
 * InsertAtStart.java
 * 
 * This class demonstrates inserting elements at the start of an array
 * without using built-in functions, shifting elements as needed.
 * Each method is thoroughly commented to explain the insertion process
 * and challenges with array manipulation.
 * 
 * Learning Objectives:
 * - Implement basic array insertion techniques
 * - Understand element shifting and boundary handling
 * - Practice memory reallocation and index management
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

public class InsertAtStart {
    
    /**
     * Method to insert a new element at the start of the array
     * This shifts existing elements right and inserts at index 0
     * 
     * @param arr The original array
     * @param newElement The element to be inserted at the start
     * @return int[] New array with element inserted at the start
     */
    public static int[] insertAtStart(int[] arr, int newElement) {
        // Handle null input
        if (arr == null) {
            System.out.println("Array is null");
            return null;
        }
        
        // Create a new array with increased size
        int[] newArray = new int[arr.length + 1];
        
        // Insert new element at the first index
        newArray[0] = newElement;
        
        // Copy all original elements to new positions (index+1)
        for (int i = 0; i < arr.length; i++) {
            newArray[i + 1] = arr[i];
        }
        
        System.out.println("Element " + newElement + " inserted at start");
        return newArray;
    }
    
    /**
     * Helper method to display array contents
     * 
     * @param arr The array to display
     * @param label Label for the array
     */
    public static void displayArray(int[] arr, String label) {
        if (arr == null) {
            System.out.println(label + ": null");
            return;
        }
        
        System.out.print(label + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Main method to demonstrate insert at start operation
     */
    public static void main(String[] args) {
        System.out.println("=== INSERT AT START OPERATION DEMONSTRATION ===\n");
        
        // Create sample array
        int[] sampleArray = {1, 2, 3, 4, 5};
        displayArray(sampleArray, "Original Array");
        
        // Demonstrate insert at start
        System.out.println("\n--- Insert 99 at Start ---");
        int[] resultArray1 = insertAtStart(sampleArray, 99);
        displayArray(resultArray1, "Array after Insertion");
        
        System.out.println("\n--- Insert 42 at Start ---");
        int[] resultArray2 = insertAtStart(sampleArray, 42);
        displayArray(resultArray2, "Array after Insertion");
        
        // Edge cases
        System.out.println("\n--- Edge Cases ---");
        
        // Empty array
        int[] emptyArray = {};
        int[] insertedEmpty = insertAtStart(emptyArray, 10);
        displayArray(insertedEmpty, "Inserted into Empty Array");
        
        // Null array
        int[] nullArray = null;
        int[] insertedNull = insertAtStart(nullArray, 5);
        displayArray(insertedNull, "Inserted into Null Array");
        
        // Single element array
        int[] singleElement = {50};
        int[] insertedSingle = insertAtStart(singleElement, 3);
        displayArray(insertedSingle, "Inserted into Single Element Array");
    }
}
