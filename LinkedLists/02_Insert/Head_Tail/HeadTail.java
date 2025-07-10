/*
 * HeadTail.java
 * 
 * This file demonstrates linked list head and tail insertion operations
 * implemented from scratch without using built-in functions.
 * Each operation is thoroughly commented for educational purposes.
 * 
 * Topic: LinkedLists
 * Operation: Head Tail
 */

public class HeadTail {
    
    // Node class for linked list
    static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Linked list class
    static class LinkedList {
        private Node head;
        private Node tail;
        private int size;
        
        // Constructor to initialize empty list
        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }
        
        // Insert at head (beginning of list)
        public void insertAtHead(int data) {
            Node newNode = new Node(data);
            
            if (head == null) {
                // List is empty
                head = newNode;
                tail = newNode;
            } else {
                // List is not empty
                newNode.next = head;
                head = newNode;
            }
            
            size++;
            System.out.println("Inserted " + data + " at head. Size: " + size);
        }
        
        // Insert at tail (end of list)
        public void insertAtTail(int data) {
            Node newNode = new Node(data);
            
            if (tail == null) {
                // List is empty
                head = newNode;
                tail = newNode;
            } else {
                // List is not empty
                tail.next = newNode;
                tail = newNode;
            }
            
            size++;
            System.out.println("Inserted " + data + " at tail. Size: " + size);
        }
        
        // Display the list
        public void display() {
            if (head == null) {
                System.out.println("List is empty");
                return;
            }
            
            System.out.print("List: ");
            Node current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println(" (Size: " + size + ")");
        }
        
        // Get head value
        public int getHead() {
            if (head == null) {
                System.out.println("List is empty");
                return -1;
            }
            return head.data;
        }
        
        // Get tail value
        public int getTail() {
            if (tail == null) {
                System.out.println("List is empty");
                return -1;
            }
            return tail.data;
        }
        
        // Get size
        public int getSize() {
            return size;
        }
        
        // Check if list is empty
        public boolean isEmpty() {
            return head == null;
        }
    }
    
    // Main method to demonstrate head/tail operations
    public static void main(String[] args) {
        System.out.println("=== LINKED LIST HEAD TAIL DEMONSTRATION ===");
        
        LinkedList list = new LinkedList();
        
        System.out.println("Initial state:");
        list.display();
        
        System.out.println("\n--- Inserting at head ---");
        list.insertAtHead(10);
        list.insertAtHead(20);
        list.insertAtHead(30);
        list.display();
        
        System.out.println("\n--- Inserting at tail ---");
        list.insertAtTail(40);
        list.insertAtTail(50);
        list.insertAtTail(60);
        list.display();
        
        System.out.println("\n--- Mixed insertions ---");
        list.insertAtHead(5);
        list.insertAtTail(70);
        list.insertAtHead(1);
        list.display();
        
        System.out.println("\n--- Head and Tail values ---");
        System.out.println("Head value: " + list.getHead());
        System.out.println("Tail value: " + list.getTail());
        System.out.println("List size: " + list.getSize());
        
        System.out.println("\n=== DEMONSTRATION COMPLETE ===");
    }
}
