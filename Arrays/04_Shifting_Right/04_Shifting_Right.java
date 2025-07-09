/**
 * RightShift.java
 * 
 * This class demonstrates various right shift operations on arrays without using built-in functions.
 * Each method is thoroughly commented to explain the shifting logic and implementation details.
 * 
 * Learning Objectives:
 * - Understand different types of right shift operations
 * - Learn how to handle boundary conditions
 * - Practice manual element movement techniques
 * - Understand the difference between linear and circular shifts
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

public class RightShift {
    
    /**
     * Method to perform linear right shift (elements beyond bounds are lost)
     * This shifts all elements to the right by specified positions
     * 
     * @param arr The array to shift
     * @param positions Number of positions to shift right
     * @return int[] New array with elements shifted right
     */
    public static int[] linearRightShift(int[] arr, int positions) {
        // Handle null input
        if (arr == null) {
            System.out.println("Array is null");
            return null;
        }
        
        // Handle invalid positions
        if (positions < 0) {
            System.out.println("Shift positions cannot be negative");
            return null;
        }
        
        // Create new array with same size
        int[] shiftedArray = new int[arr.length];
        
        // If positions >= array length, all elements are lost
        if (positions >= arr.length) {
            // Return array filled with zeros (default int value)
            System.out.println("Shift amount exceeds array length - all elements lost");
            return shiftedArray;
        }
        
        // Shift elements to the right
        for (int i = 0; i < arr.length - positions; i++) {
            // Move element at index i to index i + positions
            shiftedArray[i + positions] = arr[i];
        }
        
        // Elements at the beginning remain 0 (default initialization)
        // Elements that would go beyond bounds are lost
        
        System.out.println("Linear right shift by " + positions + " positions completed");
        return shiftedArray;
    }
    
    /**
     * Method to perform circular right shift (elements wrap around)
     * This shifts elements right with wraparound to the beginning
     * 
     * @param arr The array to shift
     * @param positions Number of positions to shift right
     * @return int[] New array with elements circularly shifted right
     */
    public static int[] circularRightShift(int[] arr, int positions) {
        // Handle null input
        if (arr == null) {
            System.out.println("Array is null");
            return null;
        }
        
        // Handle empty array
        if (arr.length == 0) {
            return new int[0];
        }
        
        // Handle invalid positions
        if (positions < 0) {
            System.out.println("Shift positions cannot be negative");
            return null;
        }
        
        // Optimize: reduce positions using modulo
        positions = positions % arr.length;
        
        // If positions is 0, return copy of original array
        if (positions == 0) {
            return copyArray(arr);
        }
        
        // Create new array with same size
        int[] shiftedArray = new int[arr.length];
        
        // Perform circular shift
        for (int i = 0; i < arr.length; i++) {
            // Calculate new position with wraparound
            int newPosition = (i + positions) % arr.length;
            shiftedArray[newPosition] = arr[i];
        }
        
        System.out.println("Circular right shift by " + positions + " positions completed");
        return shiftedArray;
    }
    
    /**
     * Method to perform in-place right shift (modifies original array)
     * This shifts elements right without creating new array
     * 
     * @param arr The array to shift (will be modified)
     * @param positions Number of positions to shift right
     */
    public static void inPlaceRightShift(int[] arr, int positions) {
        // Handle null input
        if (arr == null) {
            System.out.println("Array is null");
            return;
        }
        
        // Handle invalid positions
        if (positions < 0) {
            System.out.println("Shift positions cannot be negative");
            return;
        }
        
        // Handle empty array or no shift needed
        if (arr.length == 0 || positions == 0) {
            return;
        }
        
        // If positions >= array length, clear the array
        if (positions >= arr.length) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 0;
            }
            System.out.println("In-place shift: all elements cleared");
            return;
        }
        
        // Shift elements from right to left to avoid overwriting
        for (int i = arr.length - 1; i >= positions; i--) {
            arr[i] = arr[i - positions];
        }
        
        // Clear the leftmost positions
        for (int i = 0; i < positions; i++) {
            arr[i] = 0;
        }
        
        System.out.println("In-place right shift by " + positions + " positions completed");
    }
    
    /**
     * Method to perform right shift with custom fill value
     * This shifts elements right and fills empty positions with specified value
     * 
     * @param arr The array to shift
     * @param positions Number of positions to shift right
     * @param fillValue Value to fill empty positions
     * @return int[] New array with elements shifted and filled
     */
    public static int[] rightShiftWithFill(int[] arr, int positions, int fillValue) {
        // Handle null input
        if (arr == null) {
            System.out.println("Array is null");
            return null;
        }
        
        // Handle invalid positions
        if (positions < 0) {
            System.out.println("Shift positions cannot be negative");
            return null;
        }
        
        // Create new array with same size
        int[] shiftedArray = new int[arr.length];
        
        // Fill entire array with fill value first
        for (int i = 0; i < shiftedArray.length; i++) {
            shiftedArray[i] = fillValue;
        }
        
        // If positions >= array length, return array filled with fillValue
        if (positions >= arr.length) {
            System.out.println("Shift amount exceeds array length - filled with " + fillValue);
            return shiftedArray;
        }
        
        // Shift elements to the right
        for (int i = 0; i < arr.length - positions; i++) {
            shiftedArray[i + positions] = arr[i];
        }
        
        System.out.println("Right shift with fill value " + fillValue + " completed");
        return shiftedArray;
    }
    
    /**
     * Helper method to copy an array
     * 
     * @param arr The array to copy
     * @return int[] Copy of the array
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        return copy;
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
     * Main method to demonstrate all right shift operations
     */
    public static void main(String[] args) {
        System.out.println("=== RIGHT SHIFT OPERATIONS DEMONSTRATION ===\n");
        
        // Create sample array
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8};
        displayArray(originalArray, "Original Array");
        
        // Demonstrate linear right shift
        System.out.println("\n--- Linear Right Shift ---");
        int[] linearShift2 = linearRightShift(originalArray, 2);
        displayArray(linearShift2, "Linear Shift by 2");
        
        int[] linearShift5 = linearRightShift(originalArray, 5);
        displayArray(linearShift5, "Linear Shift by 5");
        
        // Demonstrate circular right shift
        System.out.println("\n--- Circular Right Shift ---");
        int[] circularShift2 = circularRightShift(originalArray, 2);
        displayArray(circularShift2, "Circular Shift by 2");
        
        int[] circularShift10 = circularRightShift(originalArray, 10);
        displayArray(circularShift10, "Circular Shift by 10");
        
        // Demonstrate in-place right shift
        System.out.println("\n--- In-Place Right Shift ---");
        int[] inPlaceArray = copyArray(originalArray);
        displayArray(inPlaceArray, "Before In-Place Shift");
        inPlaceRightShift(inPlaceArray, 3);
        displayArray(inPlaceArray, "After In-Place Shift by 3");
        
        // Demonstrate right shift with fill
        System.out.println("\n--- Right Shift with Fill ---");
        int[] fillShift = rightShiftWithFill(originalArray, 3, -1);
        displayArray(fillShift, "Shift by 3 with fill -1");
        
        // Test edge cases
        System.out.println("\n--- Edge Cases ---");
        
        // Empty array
        int[] emptyArray = {};
        displayArray(emptyArray, "Empty Array");
        int[] emptyShift = circularRightShift(emptyArray, 2);
        displayArray(emptyShift, "Empty Array Shifted");
        
        // Single element
        int[] singleElement = {42};
        displayArray(singleElement, "Single Element");
        int[] singleShift = circularRightShift(singleElement, 5);
        displayArray(singleShift, "Single Element Shifted");
        
        // Shift by 0
        int[] zeroShift = linearRightShift(originalArray, 0);
        displayArray(zeroShift, "Shift by 0");
        
        // Null array
        int[] nullShift = linearRightShift(null, 2);
        displayArray(nullShift, "Null Array Shifted");
    }
}
