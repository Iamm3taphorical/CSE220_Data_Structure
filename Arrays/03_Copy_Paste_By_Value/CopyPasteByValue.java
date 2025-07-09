/**
 * CopyPasteByValue.java
 * 
 * This class demonstrates the technique of copying and pasting arrays by value,
 * ensuring each element in the original array is replicated in a new array.
 * Detailed comments explain each part of the copy process.
 * 
 * Learning Objectives:
 * - Understand the concept of copying arrays by value
 * - Differentiate between shallow and deep copying
 * - Practice manual element copying techniques
 * - Learn best practices for data independence
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

public class CopyPasteByValue {
    
    /**
     * Method to perform copy by value on an array
     * This creates an exact duplicate array with independent elements
     * 
     * @param originalArray The original array to copy
     * @return int[] The new array created by copying values
     */
    public static int[] copyArrayByValue(int[] originalArray) {
        // Handle null input
        if (originalArray == null) {
            System.out.println("Original array is null");
            return null;
        }
        
        // Create a new array with the same length as the original
        int[] newArray = new int[originalArray.length];
        
        // Copy each element from the original to the new array
        for (int i = 0; i < originalArray.length; i++) {
            // Assign element from original to new array by value
            newArray[i] = originalArray[i];
        }
        
        // Return the new, independent array
        System.out.println("Array copied by value");
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
        
        System.out.print(label + " (size " + arr.length + "): [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Main method to demonstrate the copy by value operation
     */
    public static void main(String[] args) {
        System.out.println("=== COPY AND PASTE BY VALUE DEMONSTRATION ===\n");
        
        // Create an original array
        int[] originalArray = {10, 20, 30, 40, 50};
        displayArray(originalArray, "Original Array");
        
        // Copy the array by value
        int[] copiedArray = copyArrayByValue(originalArray);
        displayArray(copiedArray, "Copied Array");
        
        // Modify the original array and show independence
        System.out.println("\n--- Modifying Original Array ---");
        originalArray[0] = 99;
        displayArray(originalArray, "Original Array (Modified)");
        displayArray(copiedArray, "Copied Array (Unchanged)");
        
        // Edge case: empty array
        System.out.println("\n--- Copying Empty Array ---");
        int[] emptyArray = {};
        int[] copiedEmptyArray = copyArrayByValue(emptyArray);
        displayArray(copiedEmptyArray, "Copied Empty Array");
        
        // Edge case: null array
        System.out.println("\n--- Copying Null Array ---");
        int[] copiedNullArray = copyArrayByValue(null);
        displayArray(copiedNullArray, "Copied Null Array");
        
        // Edge case: single element array
        System.out.println("\n--- Copying Single Element Array ---");
        int[] singleElementArray = {42};
        int[] copiedSingleArray = copyArrayByValue(singleElementArray);
        displayArray(copiedSingleArray, "Copied Single Element Array");
    }
}

