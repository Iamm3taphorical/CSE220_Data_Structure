/**
 * ArrayResize.java
 * 
 * This class demonstrates various array resizing techniques without using built-in functions.
 * Since Java arrays have fixed size, resizing involves creating new arrays and copying elements.
 * Each method is thoroughly commented to explain the resizing logic and implementation details.
 * 
 * Learning Objectives:
 * - Understand why and how array resizing works
 * - Learn different growth and shrinking strategies
 * - Practice manual element copying techniques
 * - Understand memory management implications
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

public class ArrayResize {
    
    /**
     * Method to resize an array to exact new size
     * This creates a new array with specified size and copies elements
     * 
     * @param originalArray The original array to resize
     * @param newSize The desired new size
     * @return int[] The new resized array
     */
    public static int[] resizeExact(int[] originalArray, int newSize) {
        // Handle null input
        if (originalArray == null) {
            System.out.println("Original array is null");
            return null;
        }
        
        // Handle negative size
        if (newSize < 0) {
            System.out.println("New size cannot be negative");
            return null;
        }
        
        // Create new array with specified size
        int[] newArray = new int[newSize];
        
        // Determine how many elements to copy
        // We copy the minimum of original length and new size
        int elementsToCopy = Math.min(originalArray.length, newSize);
        
        // Copy elements from original array to new array
        for (int i = 0; i < elementsToCopy; i++) {
            newArray[i] = originalArray[i];
        }
        
        // If new array is larger, remaining elements are automatically 0
        // If new array is smaller, some elements are lost (truncated)
        
        System.out.println("Resized from " + originalArray.length + " to " + newSize);
        return newArray;
    }
    
    /**
     * Method to expand array using doubling strategy
     * This doubles the array size, commonly used in dynamic arrays
     * 
     * @param originalArray The original array to expand
     * @return int[] The expanded array with double size
     */
    public static int[] expandDouble(int[] originalArray) {
        // Handle null input
        if (originalArray == null) {
            System.out.println("Original array is null");
            return null;
        }
        
        // Handle empty array case
        if (originalArray.length == 0) {
            // Create array with initial capacity of 1
            return new int[1];
        }
        
        // Calculate new size (double the current size)
        int newSize = originalArray.length * 2;
        
        // Create new array with double size
        int[] expandedArray = new int[newSize];
        
        // Copy all elements from original array
        for (int i = 0; i < originalArray.length; i++) {
            expandedArray[i] = originalArray[i];
        }
        
        // Remaining elements in new array are automatically initialized to 0
        
        System.out.println("Expanded from " + originalArray.length + " to " + newSize);
        return expandedArray;
    }
    
    /**
     * Method to expand array using 1.5x growth strategy
     * This provides good balance between space and time efficiency
     * 
     * @param originalArray The original array to expand
     * @return int[] The expanded array with 1.5x size
     */
    public static int[] expandHalf(int[] originalArray) {
        // Handle null input
        if (originalArray == null) {
            System.out.println("Original array is null");
            return null;
        }
        
        // Handle empty array case
        if (originalArray.length == 0) {
            return new int[1];
        }
        
        // Calculate new size (1.5 times current size)
        // We use integer arithmetic: (length * 3) / 2
        int newSize = (originalArray.length * 3) / 2;
        
        // Ensure minimum growth of 1
        if (newSize <= originalArray.length) {
            newSize = originalArray.length + 1;
        }
        
        // Create new array with calculated size
        int[] expandedArray = new int[newSize];
        
        // Copy all elements from original array
        for (int i = 0; i < originalArray.length; i++) {
            expandedArray[i] = originalArray[i];
        }
        
        System.out.println("Expanded (1.5x) from " + originalArray.length + " to " + newSize);
        return expandedArray;
    }
    
    /**
     * Method to shrink array to fit only used elements
     * This removes unused capacity to save memory
     * 
     * @param originalArray The original array to shrink
     * @param usedElements Number of elements actually being used
     * @return int[] The shrunken array
     */
    public static int[] shrinkToFit(int[] originalArray, int usedElements) {
        // Handle null input
        if (originalArray == null) {
            System.out.println("Original array is null");
            return null;
        }
        
        // Validate usedElements parameter
        if (usedElements < 0) {
            System.out.println("Used elements cannot be negative");
            return null;
        }
        
        // Ensure usedElements doesn't exceed array length
        if (usedElements > originalArray.length) {
            System.out.println("Used elements cannot exceed array length");
            return null;
        }
        
        // If already optimal size, return copy of original
        if (usedElements == originalArray.length) {
            System.out.println("Array already optimal size");
            return copyArray(originalArray);
        }
        
        // Create new array with exact size needed
        int[] shrunkenArray = new int[usedElements];
        
        // Copy only the used elements
        for (int i = 0; i < usedElements; i++) {
            shrunkenArray[i] = originalArray[i];
        }
        
        System.out.println("Shrunken from " + originalArray.length + " to " + usedElements);
        return shrunkenArray;
    }
    
    /**
     * Method to create a copy of an array
     * This is a helper method for other resize operations
     * 
     * @param originalArray The array to copy
     * @return int[] A new array with same elements
     */
    public static int[] copyArray(int[] originalArray) {
        // Handle null input
        if (originalArray == null) {
            return null;
        }
        
        // Create new array with same size
        int[] copy = new int[originalArray.length];
        
        // Copy all elements manually
        for (int i = 0; i < originalArray.length; i++) {
            copy[i] = originalArray[i];
        }
        
        return copy;
    }
    
    /**
     * Method to demonstrate dynamic resizing based on load factor
     * This shows how real dynamic arrays decide when to resize
     * 
     * @param originalArray The original array
     * @param usedElements Current number of used elements
     * @param loadFactor Threshold for resizing (0.0 to 1.0)
     * @return int[] Resized array or original if no resize needed
     */
    public static int[] dynamicResize(int[] originalArray, int usedElements, double loadFactor) {
        // Handle null input
        if (originalArray == null) {
            System.out.println("Original array is null");
            return null;
        }
        
        // Validate parameters
        if (usedElements < 0 || usedElements > originalArray.length) {
            System.out.println("Invalid used elements count");
            return null;
        }
        
        if (loadFactor <= 0.0 || loadFactor > 1.0) {
            System.out.println("Load factor must be between 0.0 and 1.0");
            return null;
        }
        
        // Calculate current utilization
        double currentUtilization = (double) usedElements / originalArray.length;
        
        System.out.println("Current utilization: " + (currentUtilization * 100) + "%");
        
        // Check if expansion is needed (utilization above threshold)
        if (currentUtilization >= loadFactor) {
            System.out.println("Expanding due to high utilization");
            return expandDouble(originalArray);
        }
        
        // Check if shrinking is needed (utilization below quarter of threshold)
        if (currentUtilization < loadFactor / 4.0 && originalArray.length > 4) {
            System.out.println("Shrinking due to low utilization");
            return shrinkToFit(originalArray, usedElements);
        }
        
        // No resize needed
        System.out.println("No resize needed");
        return originalArray;
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
     * Main method to demonstrate all resize techniques
     */
    public static void main(String[] args) {
        System.out.println("=== ARRAY RESIZE DEMONSTRATIONS ===\n");
        
        // Create original array
        int[] original = {1, 2, 3, 4, 5};
        displayArray(original, "Original Array");
        
        // Demonstrate exact resize (expand)
        System.out.println("\n--- Exact Resize (Expand to 8) ---");
        int[] resized1 = resizeExact(original, 8);
        displayArray(resized1, "Resized Array");
        
        // Demonstrate exact resize (shrink)
        System.out.println("\n--- Exact Resize (Shrink to 3) ---");
        int[] resized2 = resizeExact(original, 3);
        displayArray(resized2, "Resized Array");
        
        // Demonstrate doubling expansion
        System.out.println("\n--- Double Expansion ---");
        int[] expanded1 = expandDouble(original);
        displayArray(expanded1, "Expanded Array");
        
        // Demonstrate 1.5x expansion
        System.out.println("\n--- 1.5x Expansion ---");
        int[] expanded2 = expandHalf(original);
        displayArray(expanded2, "Expanded Array");
        
        // Demonstrate shrink to fit
        System.out.println("\n--- Shrink to Fit ---");
        int[] shrunken = shrinkToFit(expanded1, 3);
        displayArray(shrunken, "Shrunken Array");
        
        // Demonstrate dynamic resizing
        System.out.println("\n--- Dynamic Resize Simulation ---");
        int[] dynamicArray = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0}; // 50% utilization
        displayArray(dynamicArray, "Dynamic Array");
        
        // Test with high utilization (should expand)
        int[] result1 = dynamicResize(dynamicArray, 8, 0.75);
        displayArray(result1, "After High Utilization Check");
        
        // Test with low utilization (should shrink)
        int[] result2 = dynamicResize(dynamicArray, 2, 0.75);
        displayArray(result2, "After Low Utilization Check");
        
        // Test edge cases
        System.out.println("\n--- Edge Cases ---");
        
        // Empty array
        int[] empty = {};
        displayArray(empty, "Empty Array");
        int[] expandedEmpty = expandDouble(empty);
        displayArray(expandedEmpty, "Expanded Empty");
        
        // Single element
        int[] single = {42};
        displayArray(single, "Single Element");
        int[] expandedSingle = expandHalf(single);
        displayArray(expandedSingle, "Expanded Single");
        
        // Null array
        int[] nullResult = resizeExact(null, 5);
        displayArray(nullResult, "Null Resize Result");
    }
}
