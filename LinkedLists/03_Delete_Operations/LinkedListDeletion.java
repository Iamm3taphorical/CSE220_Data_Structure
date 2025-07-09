/**
 * LinkedListDeletion.java
 * 
 * This class demonstrates various deletion operations in a linked list
 * both with and without using built-in methods. Each method is thoroughly 
 * commented to explain the deletion process.
 * 
 * Learning Objectives:
 * - Implement deletion from head, tail, and specific positions
 * - Understand pointer manipulation during deletion
 * - Handle edge cases and memory management
 * - Compare manual implementation with built-in methods
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

import java.util.LinkedList; // For built-in comparison

public class LinkedListDeletion {

    /**
     * Inner Node class to define the structure of linked list nodes
     */
    private static class Node {
        int data;    // Data portion of the node
        Node next;   // Pointer to the next node

        // Node constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;  // Head of the linked list
    private Node tail;  // Tail of the linked list (for efficient operations)
    private int size;   // Size of the linked list

    /**
     * Constructor to initialize an empty linked list
     */
    public LinkedListDeletion() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Helper method to insert at head (for testing purposes)
     */
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Delete from head of the list
     * WITHOUT using built-in functions
     * 
     * @return The data of the deleted node, or -1 if list is empty
     */
    public int deleteFromHead() {
        // Check if list is empty
        if (head == null) {
            System.out.println("List is empty, cannot delete from head");
            return -1;
        }
        
        // Store the data to be returned
        int deletedData = head.data;
        
        // If there's only one node
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            // Move head to the next node
            head = head.next;
        }
        
        size--;
        System.out.println("Deleted " + deletedData + " from head. Size: " + size);
        return deletedData;
    }

    /**
     * Delete from tail of the list
     * WITHOUT using built-in functions
     * 
     * @return The data of the deleted node, or -1 if list is empty
     */
    public int deleteFromTail() {
        // Check if list is empty
        if (head == null) {
            System.out.println("List is empty, cannot delete from tail");
            return -1;
        }
        
        // Store the data to be returned
        int deletedData = tail.data;
        
        // If there's only one node
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            // Find the second-to-last node
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            // Update tail and break the link
            tail = current;
            tail.next = null;
        }
        
        size--;
        System.out.println("Deleted " + deletedData + " from tail. Size: " + size);
        return deletedData;
    }

    /**
     * Delete node at a specific position (0-indexed)
     * WITHOUT using built-in functions
     * 
     * @param position The position of the node to delete
     * @return The data of the deleted node, or -1 if position is invalid
     */
    public int deleteAtPosition(int position) {
        // Validate position
        if (position < 0 || position >= size) {
            System.out.println("Invalid position: " + position);
            return -1;
        }
        
        // If position is 0, delete from head
        if (position == 0) {
            return deleteFromHead();
        }
        
        // If position is at the end, delete from tail
        if (position == size - 1) {
            return deleteFromTail();
        }
        
        // Find the node just before the position to delete
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        // Store the data to be returned
        int deletedData = current.next.data;
        
        // Skip the node to be deleted
        current.next = current.next.next;
        
        size--;
        System.out.println("Deleted " + deletedData + " from position " + position + ". Size: " + size);
        return deletedData;
    }

    /**
     * Delete node by value (first occurrence)
     * WITHOUT using built-in functions
     * 
     * @param value The value to search for and delete
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteByValue(int value) {
        // Check if list is empty
        if (head == null) {
            System.out.println("List is empty, cannot delete value " + value);
            return false;
        }
        
        // If the head node contains the value
        if (head.data == value) {
            deleteFromHead();
            return true;
        }
        
        // Search for the value in the rest of the list
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                // Found the value, delete the node
                Node nodeToDelete = current.next;
                current.next = nodeToDelete.next;
                
                // If deleted node was the tail, update tail
                if (nodeToDelete == tail) {
                    tail = current;
                }
                
                size--;
                System.out.println("Deleted value " + value + " from list. Size: " + size);
                return true;
            }
            current = current.next;
        }
        
        System.out.println("Value " + value + " not found in list");
        return false;
    }

    /**
     * Delete all nodes with a specific value
     * WITHOUT using built-in functions
     * 
     * @param value The value to search for and delete all occurrences
     * @return Number of nodes deleted
     */
    public int deleteAllByValue(int value) {
        int deletedCount = 0;
        
        // Delete from head while it matches the value
        while (head != null && head.data == value) {
            deleteFromHead();
            deletedCount++;
        }
        
        // If list became empty
        if (head == null) {
            System.out.println("Deleted " + deletedCount + " occurrences of " + value);
            return deletedCount;
        }
        
        // Delete from the rest of the list
        Node current = head;
        while (current.next != null) {
            if (current.next.data == value) {
                Node nodeToDelete = current.next;
                current.next = nodeToDelete.next;
                
                // If deleted node was the tail, update tail
                if (nodeToDelete == tail) {
                    tail = current;
                }
                
                size--;
                deletedCount++;
            } else {
                current = current.next;
            }
        }
        
        System.out.println("Deleted " + deletedCount + " occurrences of " + value);
        return deletedCount;
    }

    /**
     * Delete all nodes (clear the list)
     * WITHOUT using built-in functions
     */
    public void deleteAll() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("All nodes deleted. List is now empty.");
    }

    /**
     * Method to print the linked list
     */
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Get the size of the list
     * 
     * @return The size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Demonstrate built-in LinkedList deletion operations
     */
    public static void demonstrateBuiltInDeletion() {
        System.out.println("\\n=== BUILT-IN LINKEDLIST DELETION DEMONSTRATION ===");
        
        // Create a built-in LinkedList
        LinkedList<Integer> builtInList = new LinkedList<>();
        
        // Add elements using built-in methods
        builtInList.add(10);
        builtInList.add(20);
        builtInList.add(30);
        builtInList.add(20);
        builtInList.add(40);
        System.out.println("Built-in list after additions: " + builtInList);
        
        // Delete from head using built-in method
        System.out.println("\\n--- Built-in Delete from Head ---");
        int removedHead = builtInList.removeFirst();
        System.out.println("Removed from head: " + removedHead);
        System.out.println("List after head deletion: " + builtInList);
        
        // Delete from tail using built-in method
        System.out.println("\\n--- Built-in Delete from Tail ---");
        int removedTail = builtInList.removeLast();
        System.out.println("Removed from tail: " + removedTail);
        System.out.println("List after tail deletion: " + builtInList);
        
        // Delete by value using built-in method
        System.out.println("\\n--- Built-in Delete by Value ---");
        boolean removed = builtInList.remove(Integer.valueOf(20));
        System.out.println("Removed value 20: " + removed);
        System.out.println("List after value deletion: " + builtInList);
        
        // Delete at position using built-in method
        System.out.println("\\n--- Built-in Delete at Position ---");
        int removedAtPos = builtInList.remove(0);
        System.out.println("Removed at position 0: " + removedAtPos);
        System.out.println("List after position deletion: " + builtInList);
        
        // Clear all using built-in method
        System.out.println("\\n--- Built-in Clear All ---");
        builtInList.clear();
        System.out.println("List after clear: " + builtInList);
        System.out.println("Is empty: " + builtInList.isEmpty());
    }

    /**
     * Main method to demonstrate all deletion operations
     */
    public static void main(String[] args) {
        System.out.println("=== LINKED LIST DELETION DEMONSTRATION ===\\n");
        
        LinkedListDeletion list = new LinkedListDeletion();
        
        // Add some elements for testing
        System.out.println("--- Setting up test data ---");
        list.insertAtHead(50);
        list.insertAtHead(40);
        list.insertAtHead(30);
        list.insertAtHead(20);
        list.insertAtHead(10);
        list.insertAtHead(20); // Duplicate for testing
        list.printList();
        
        // Test delete from head
        System.out.println("\\n--- Delete from Head ---");
        list.deleteFromHead();
        list.printList();
        
        // Test delete from tail
        System.out.println("\\n--- Delete from Tail ---");
        list.deleteFromTail();
        list.printList();
        
        // Test delete at position
        System.out.println("\\n--- Delete at Position ---");
        list.deleteAtPosition(1); // Delete second element
        list.printList();
        
        // Test delete by value
        System.out.println("\\n--- Delete by Value ---");
        list.deleteByValue(30);
        list.printList();
        
        // Add more duplicates for testing
        list.insertAtHead(20);
        list.insertAtHead(20);
        list.printList();
        
        // Test delete all by value
        System.out.println("\\n--- Delete All by Value ---");
        list.deleteAllByValue(20);
        list.printList();
        
        // Test edge cases
        System.out.println("\\n--- Edge Cases ---");
        
        // Delete from empty list
        LinkedListDeletion emptyList = new LinkedListDeletion();
        emptyList.deleteFromHead();
        emptyList.deleteFromTail();
        emptyList.deleteAtPosition(0);
        emptyList.deleteByValue(10);
        
        // Delete all
        System.out.println("\\n--- Delete All ---");
        list.deleteAll();
        list.printList();
        
        // Demonstrate built-in deletion
        demonstrateBuiltInDeletion();
        
        // Final comparison
        System.out.println("\\n\\n=== COMPARISON SUMMARY ===");
        System.out.println("Manual Implementation:");
        System.out.println("  - Complete control over memory management");
        System.out.println("  - Custom error handling");
        System.out.println("  - Educational value for understanding pointers");
        
        System.out.println("\\nBuilt-in LinkedList:");
        System.out.println("  - Convenient methods for all operations");
        System.out.println("  - Automatic memory management");
        System.out.println("  - Exception handling built-in");
        System.out.println("  - Optimized and well-tested implementation");
    }
}
