/**
 * LinkedListCreation.java
 * 
 * This class demonstrates the creation and initialization of a linked list from scratch
 * without using built-in functions. Each method is thoroughly commented to explain the
 * structure and setup process.
 * 
 * Learning Objectives:
 * - Initialize an empty linked list
 * - Understand node creation and linking
 * - Manage memory through dynamic allocation
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

public class LinkedListCreation {

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

    /**
     * Constructor to initialize an empty linked list
     */
    public LinkedListCreation() {
        this.head = null;  // Start with an empty list
    }

    /**
     * Method to add an element at the beginning of the list
     * 
     * @param newData The data for the new node to be added
     */
    public void addAtStart(int newData) {
        Node newNode = new Node(newData);  // Allocate the Node & Put in the data
        newNode.next = head;               // Make next of new Node as head
        head = newNode;                    // Move the head to point to new Node
        System.out.println(newData + " inserted at the start.");
    }

    /**
     * Method to print the linked list
     */
    public void printList() {
        Node currentNode = head;
        System.out.print("Linked List: ");
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /**
     * Main method to demonstrate linked list creation
     */
    public static void main(String[] args) {
        LinkedListCreation list = new LinkedListCreation();

        // Demonstrate insertion
        list.addAtStart(10);
        list.addAtStart(20);
        list.addAtStart(30);

        // Print the linked list
        list.printList();
    }
}

