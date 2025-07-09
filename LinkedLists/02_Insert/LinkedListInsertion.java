/**
 * LinkedListInsertion.java
 * 
 * This class demonstrates various insertion operations in a linked list
 * both with and without using built-in methods. Each method is thoroughly 
 * commented to explain the insertion process.
 * 
 * Learning Objectives:
 * - Implement insertion at head, tail, and specific positions
 * - Understand pointer manipulation in linked lists
 * - Handle edge cases in insertion operations
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

public class LinkedListInsertion {

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
    private Node tail;  // Tail of the linked list (for efficient tail insertion)
    private int size;   // Size of the linked list

    /**
     * Constructor to initialize an empty linked list
     */
    public LinkedListInsertion() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Method to insert a node at the head of the list
     * WITHOUT using built-in functions
     * 
     * @param data The data to be inserted
     */
    public void insertAtHead(int data) {
        // Create a new node
        Node newNode = new Node(data);
        
        // If the list is empty, both head and tail point to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // Point the new node to the current head
            newNode.next = head;
            // Update the head to point to the new node
            head = newNode;
        }
        
        size++;
        System.out.println("Inserted " + data + " at head. List size: " + size);
    }

    /**
     * Method to insert a node at the tail of the list
     * WITHOUT using built-in functions
     * 
     * @param data The data to be inserted
     */
    public void insertAtTail(int data) {
        // Create a new node
        Node newNode = new Node(data);
        
        // If the list is empty, both head and tail point to the new node
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            // Point the current tail to the new node
            tail.next = newNode;
            // Update the tail to point to the new node
            tail = newNode;
        }
        
        size++;
        System.out.println("Inserted " + data + " at tail. List size: " + size);
    }

    /**
     * Method to insert a node at a specific position (0-indexed)
     * WITHOUT using built-in functions
     * 
     * @param data The data to be inserted
     * @param position The position where the node should be inserted
     */
    public void insertAtPosition(int data, int position) {
        // Validate position
        if (position < 0 || position > size) {
            System.out.println("Invalid position: " + position);
            return;
        }
        
        // If position is 0, insert at head
        if (position == 0) {
            insertAtHead(data);
            return;
        }
        
        // If position is at the end, insert at tail
        if (position == size) {
            insertAtTail(data);
            return;
        }
        
        // Create a new node
        Node newNode = new Node(data);
        
        // Traverse to the node just before the insertion position
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        
        // Insert the new node
        newNode.next = current.next;
        current.next = newNode;
        
        size++;
        System.out.println("Inserted " + data + " at position " + position + ". List size: " + size);
    }

    /**
     * Method to insert after a given node
     * WITHOUT using built-in functions
     * 
     * @param prevNode The node after which the new node will be inserted
     * @param data The data to be inserted
     */
    public void insertAfterNode(Node prevNode, int data) {
        // Check if the given node is null
        if (prevNode == null) {
            System.out.println("Previous node cannot be null");
            return;
        }
        
        // Create a new node
        Node newNode = new Node(data);
        
        // Point the new node to the next node of the previous node
        newNode.next = prevNode.next;
        
        // Point the previous node to the new node
        prevNode.next = newNode;
        
        // If the previous node was the tail, update the tail
        if (prevNode == tail) {
            tail = newNode;
        }
        
        size++;
        System.out.println("Inserted " + data + " after a given node. List size: " + size);
    }

    /**
     * Method to insert before a given node
     * WITHOUT using built-in functions
     * 
     * @param nextNode The node before which the new node will be inserted
     * @param data The data to be inserted
     */
    public void insertBeforeNode(Node nextNode, int data) {
        // Check if the given node is null
        if (nextNode == null) {
            System.out.println("Next node cannot be null");
            return;
        }
        
        // If the next node is the head, insert at head
        if (nextNode == head) {
            insertAtHead(data);
            return;
        }
        
        // Find the node before the next node
        Node current = head;
        while (current != null && current.next != nextNode) {
            current = current.next;
        }
        
        // If the next node is not found in the list
        if (current == null) {
            System.out.println("Next node not found in the list");
            return;
        }
        
        // Create a new node
        Node newNode = new Node(data);
        
        // Insert the new node between current and nextNode
        newNode.next = nextNode;
        current.next = newNode;
        
        size++;
        System.out.println("Inserted " + data + " before a given node. List size: " + size);
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
     * Method to get the size of the list
     * 
     * @return The size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Method to get the head node (for demonstration purposes)
     * 
     * @return The head node
     */
    public Node getHead() {
        return head;
    }

    /**
     * Method to get the tail node (for demonstration purposes)
     * 
     * @return The tail node
     */
    public Node getTail() {
        return tail;
    }

    /**
     * Main method to demonstrate linked list insertion operations
     */
    public static void main(String[] args) {
        LinkedListInsertion list = new LinkedListInsertion();
        
        System.out.println("=== LINKED LIST INSERTION DEMONSTRATION ===\n");
        
        // Insert at head
        System.out.println("--- Insert at Head ---");
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);
        list.printList();
        
        System.out.println("\n--- Insert at Tail ---");
        list.insertAtTail(40);
        list.insertAtTail(50);
        list.printList();
        
        System.out.println("\n--- Insert at Position ---");
        list.insertAtPosition(25, 2);  // Insert 25 at position 2
        list.printList();
        
        System.out.println("\n--- Insert After Node ---");
        Node headNode = list.getHead();
        list.insertAfterNode(headNode, 35);  // Insert after head
        list.printList();
        
        System.out.println("\n--- Insert Before Node ---");
        Node tailNode = list.getTail();
        list.insertBeforeNode(tailNode, 45);  // Insert before tail
        list.printList();
        
        // Test edge cases
        System.out.println("\n--- Edge Cases ---");
        
        // Insert at invalid position
        list.insertAtPosition(100, -1);  // Invalid position
        list.insertAtPosition(100, 20);  // Position beyond size
        
        // Insert after null node
        list.insertAfterNode(null, 100);
        
        // Insert before null node
        list.insertBeforeNode(null, 100);
        
        // Final list
        System.out.println("\nFinal List:");
        list.printList();
        System.out.println("Final Size: " + list.getSize());
    }
}
