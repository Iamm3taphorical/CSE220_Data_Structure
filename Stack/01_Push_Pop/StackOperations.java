/**
 * StackOperations.java
 * 
 * This class demonstrates stack operations (push, pop, peek) implemented from scratch
 * using both array-based and linked list-based approaches. It also shows how to use
 * built-in Java Stack class for comparison.
 * 
 * Learning Objectives:
 * - Understand LIFO (Last In, First Out) principle
 * - Implement stack operations without built-in functions
 * - Compare manual implementation with built-in Stack class
 * - Handle edge cases like stack overflow and underflow
 * 
 * @author CSE220 Faculty
 * @version 1.0
 */

import java.util.Stack; // For built-in stack demonstration
import java.util.EmptyStackException;

public class StackOperations {
    
    // ==================== ARRAY-BASED STACK IMPLEMENTATION ====================
    
    /**
     * Array-based stack implementation without using built-in functions
     */
    static class ArrayStack {
        private int[] stack;
        private int top;
        private int maxSize;
        
        /**
         * Constructor to initialize the stack
         * @param maxSize Maximum capacity of the stack
         */
        public ArrayStack(int maxSize) {
            this.maxSize = maxSize;
            this.stack = new int[maxSize];
            this.top = -1; // Stack is empty initially
        }
        
        /**
         * Push operation - Add element to top of stack
         * WITHOUT using built-in functions
         * 
         * @param data Element to be pushed
         * @return true if push successful, false if stack is full
         */
        public boolean push(int data) {
            // Check for stack overflow
            if (isFull()) {
                System.out.println("Stack Overflow! Cannot push " + data);
                return false;
            }
            
            // Increment top pointer and add element
            top++;
            stack[top] = data;
            System.out.println("Pushed " + data + " to stack. Top index: " + top);
            return true;
        }
        
        /**
         * Pop operation - Remove and return top element
         * WITHOUT using built-in functions
         * 
         * @return The popped element, or -1 if stack is empty
         */
        public int pop() {
            // Check for stack underflow
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop from empty stack");
                return -1;
            }
            
            // Get the top element and decrement top pointer
            int poppedElement = stack[top];
            top--;
            System.out.println("Popped " + poppedElement + " from stack. Top index: " + top);
            return poppedElement;
        }
        
        /**
         * Peek operation - View top element without removing it
         * WITHOUT using built-in functions
         * 
         * @return The top element, or -1 if stack is empty
         */
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty! Cannot peek");
                return -1;
            }
            
            return stack[top];
        }
        
        /**
         * Check if stack is empty
         * @return true if stack is empty, false otherwise
         */
        public boolean isEmpty() {
            return top == -1;
        }
        
        /**
         * Check if stack is full
         * @return true if stack is full, false otherwise
         */
        public boolean isFull() {
            return top == maxSize - 1;
        }
        
        /**
         * Get current size of stack
         * @return Current number of elements in stack
         */
        public int size() {
            return top + 1;
        }
        
        /**
         * Display all elements in the stack
         */
        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }
            
            System.out.print("Stack contents (top to bottom): ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
    
    // ==================== LINKED LIST-BASED STACK IMPLEMENTATION ====================
    
    /**
     * Linked list-based stack implementation without using built-in functions
     */
    static class LinkedStack {
        private Node top;
        private int size;
        
        /**
         * Inner Node class for linked list
         */
        private class Node {
            int data;
            Node next;
            
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        
        /**
         * Constructor to initialize empty stack
         */
        public LinkedStack() {
            this.top = null;
            this.size = 0;
        }
        
        /**
         * Push operation - Add element to top of stack
         * WITHOUT using built-in functions
         * 
         * @param data Element to be pushed
         */
        public void push(int data) {
            // Create new node
            Node newNode = new Node(data);
            
            // Point new node to current top
            newNode.next = top;
            
            // Update top to point to new node
            top = newNode;
            
            // Increment size
            size++;
            
            System.out.println("Pushed " + data + " to linked stack. Size: " + size);
        }
        
        /**
         * Pop operation - Remove and return top element
         * WITHOUT using built-in functions
         * 
         * @return The popped element, or -1 if stack is empty
         */
        public int pop() {
            // Check for empty stack
            if (isEmpty()) {
                System.out.println("Stack Underflow! Cannot pop from empty stack");
                return -1;
            }
            
            // Get data from top node
            int poppedData = top.data;
            
            // Update top to point to next node
            top = top.next;
            
            // Decrement size
            size--;
            
            System.out.println("Popped " + poppedData + " from linked stack. Size: " + size);
            return poppedData;
        }
        
        /**
         * Peek operation - View top element without removing it
         * WITHOUT using built-in functions
         * 
         * @return The top element, or -1 if stack is empty
         */
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty! Cannot peek");
                return -1;
            }
            
            return top.data;
        }
        
        /**
         * Check if stack is empty
         * @return true if stack is empty, false otherwise
         */
        public boolean isEmpty() {
            return top == null;
        }
        
        /**
         * Get current size of stack
         * @return Current number of elements in stack
         */
        public int size() {
            return size;
        }
        
        /**
         * Display all elements in the stack
         */
        public void display() {
            if (isEmpty()) {
                System.out.println("Linked stack is empty");
                return;
            }
            
            System.out.print("Linked stack contents (top to bottom): ");
            Node current = top;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
    
    // ==================== BUILT-IN STACK DEMONSTRATION ====================
    
    /**
     * Demonstrate built-in Java Stack class operations
     */
    public static void demonstrateBuiltInStack() {
        System.out.println("\\n=== BUILT-IN JAVA STACK DEMONSTRATION ===");
        
        // Create a built-in stack
        Stack<Integer> builtInStack = new Stack<>();
        
        // Push elements using built-in method
        System.out.println("\\n--- Built-in Push Operations ---");
        builtInStack.push(10);
        builtInStack.push(20);
        builtInStack.push(30);
        System.out.println("Stack after pushes: " + builtInStack);
        
        // Peek operation using built-in method
        System.out.println("\\n--- Built-in Peek Operation ---");
        System.out.println("Top element: " + builtInStack.peek());
        System.out.println("Stack after peek: " + builtInStack);
        
        // Pop operations using built-in method
        System.out.println("\\n--- Built-in Pop Operations ---");
        System.out.println("Popped: " + builtInStack.pop());
        System.out.println("Popped: " + builtInStack.pop());
        System.out.println("Stack after pops: " + builtInStack);
        
        // Check empty status
        System.out.println("\\n--- Built-in Status Check ---");
        System.out.println("Is stack empty? " + builtInStack.isEmpty());
        System.out.println("Stack size: " + builtInStack.size());
        
        // Pop remaining elements
        while (!builtInStack.isEmpty()) {
            System.out.println("Popped: " + builtInStack.pop());
        }
        
        // Try to pop from empty stack (built-in throws exception)
        try {
            builtInStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Built-in stack threw EmptyStackException when trying to pop from empty stack");
        }
    }
    
    /**
     * Main method to demonstrate all stack implementations
     */
    public static void main(String[] args) {
        System.out.println("=== STACK OPERATIONS DEMONSTRATION ===\\n");
        
        // ==================== ARRAY-BASED STACK DEMO ====================
        System.out.println("=== ARRAY-BASED STACK (WITHOUT BUILT-IN FUNCTIONS) ===");
        
        ArrayStack arrayStack = new ArrayStack(5);
        
        // Push operations
        System.out.println("\\n--- Push Operations ---");
        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);
        arrayStack.push(40);
        arrayStack.push(50);
        arrayStack.display();
        
        // Try to push when stack is full
        arrayStack.push(60); // Should show stack overflow
        
        // Peek operation
        System.out.println("\\n--- Peek Operation ---");
        System.out.println("Top element: " + arrayStack.peek());
        
        // Pop operations
        System.out.println("\\n--- Pop Operations ---");
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.display();
        
        // Stack status
        System.out.println("\\n--- Stack Status ---");
        System.out.println("Is empty? " + arrayStack.isEmpty());
        System.out.println("Is full? " + arrayStack.isFull());
        System.out.println("Size: " + arrayStack.size());
        
        // ==================== LINKED LIST-BASED STACK DEMO ====================
        System.out.println("\\n\\n=== LINKED LIST-BASED STACK (WITHOUT BUILT-IN FUNCTIONS) ===");
        
        LinkedStack linkedStack = new LinkedStack();
        
        // Push operations
        System.out.println("\\n--- Push Operations ---");
        linkedStack.push(100);
        linkedStack.push(200);
        linkedStack.push(300);
        linkedStack.display();
        
        // Peek operation
        System.out.println("\\n--- Peek Operation ---");
        System.out.println("Top element: " + linkedStack.peek());
        
        // Pop operations
        System.out.println("\\n--- Pop Operations ---");
        linkedStack.pop();
        linkedStack.display();
        
        // Stack status
        System.out.println("\\n--- Stack Status ---");
        System.out.println("Is empty? " + linkedStack.isEmpty());
        System.out.println("Size: " + linkedStack.size());
        
        // Pop all remaining elements
        while (!linkedStack.isEmpty()) {
            linkedStack.pop();
        }
        
        // Try to pop from empty stack
        linkedStack.pop(); // Should show underflow
        
        // ==================== BUILT-IN STACK DEMO ====================
        demonstrateBuiltInStack();
        
        // ==================== COMPARISON SUMMARY ====================
        System.out.println("\\n\\n=== COMPARISON SUMMARY ===");
        System.out.println("Array-based Stack:");
        System.out.println("  - Fixed size, fast operations");
        System.out.println("  - Can have stack overflow");
        System.out.println("  - Memory efficient for known size");
        
        System.out.println("\\nLinked List-based Stack:");
        System.out.println("  - Dynamic size, flexible");
        System.out.println("  - No size limit (only system memory)");
        System.out.println("  - Extra memory for pointers");
        
        System.out.println("\\nBuilt-in Java Stack:");
        System.out.println("  - Easy to use, well-tested");
        System.out.println("  - Throws exceptions for errors");
        System.out.println("  - Built on Vector (synchronized)");
    }
}
