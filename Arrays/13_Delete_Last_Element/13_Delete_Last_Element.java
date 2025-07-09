/**
 * 13_Delete_Last_Element.java
 * 
 * This class demonstrates the 13_Delete_Last_Element operation without using built-in functions.
 * Each method is thoroughly commented to explain the logic and implementation.
 * 
 * Learning Objectives:
 * - Understand the 13_Delete_Last_Element operation
 * - Learn implementation techniques
 * - Practice manual array manipulation
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

public class 13_Delete_Last_Element {
    
    /**
     * Main method to demonstrate 13_Delete_Last_Element operation
     */
    public static void main(String[] args) {
        System.out.println("=== 13_DELETE_LAST_ELEMENT DEMONSTRATION ===");
        
        // Create sample array
        int[] sampleArray = {1, 2, 3, 4, 5};
        
        // TODO: Implement 13_Delete_Last_Element operation
        
        System.out.println("Implementation needed for 13_Delete_Last_Element");
    }
    
    /**
     * Helper method to display array contents
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
}
