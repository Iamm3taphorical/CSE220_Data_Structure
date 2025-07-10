/*
 * EnqueueDequeue.java
 * 
 * This file demonstrates the basic enqueue and dequeue operations of a queue
 * data structure implemented from scratch without using built-in functions.
 * Each line is thoroughly commented for educational purposes.
 * 
 * Queue follows FIFO (First In, First Out) principle:
 * - Elements are added at the rear (enqueue)
 * - Elements are removed from the front (dequeue)
 */

public class EnqueueDequeue {
    
    // Queue class implementation using array
    static class Queue {
        private int[] array;        // Array to store queue elements
        private int front;          // Index of the front element
        private int rear;           // Index of the rear element
        private int capacity;       // Maximum capacity of the queue
        private int size;           // Current number of elements in queue
        
        // Constructor to initialize the queue
        public Queue(int capacity) {
            this.capacity = capacity;           // Set the maximum capacity
            this.array = new int[capacity];     // Create array of given capacity
            this.front = 0;                     // Initialize front index to 0
            this.rear = -1;                     // Initialize rear to -1 (empty queue)
            this.size = 0;                      // Initialize size to 0
        }
        
        // Enqueue operation - add element to the rear of queue
        public void enqueue(int element) {
            // Check if queue is full before adding element
            if (isFull()) {
                System.out.println("Queue is full! Cannot enqueue " + element);
                return;
            }
            
            // Move rear pointer to next position
            rear = (rear + 1) % capacity;  // Use modulo for circular behavior
            
            // Add element at the rear position
            array[rear] = element;
            
            // Increment the size of queue
            size++;
            
            System.out.println("Enqueued: " + element);
        }
        
        // Dequeue operation - remove element from the front of queue
        public int dequeue() {
            // Check if queue is empty before removing element
            if (isEmpty()) {
                System.out.println("Queue is empty! Cannot dequeue");
                return -1;  // Return -1 to indicate empty queue
            }
            
            // Get the element at front position
            int element = array[front];
            
            // Move front pointer to next position
            front = (front + 1) % capacity;  // Use modulo for circular behavior
            
            // Decrement the size of queue
            size--;
            
            System.out.println("Dequeued: " + element);
            return element;
        }
        
        // Check if queue is empty
        public boolean isEmpty() {
            return size == 0;  // Queue is empty when size is 0
        }
        
        // Check if queue is full
        public boolean isFull() {
            return size == capacity;  // Queue is full when size equals capacity
        }
        
        // Get current size of queue
        public int getSize() {
            return size;
        }
        
        // Display current state of queue
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            
            System.out.print("Queue: ");
            
            // Traverse from front to rear considering circular nature
            int count = 0;
            int index = front;
            
            while (count < size) {
                System.out.print(array[index] + " ");
                index = (index + 1) % capacity;  // Move to next position circularly
                count++;
            }
            System.out.println();
        }
    }
    
    // Main method to demonstrate queue operations
    public static void main(String[] args) {
        // Create a queue with capacity 5
        Queue queue = new Queue(5);
        
        System.out.println("=== Queue Enqueue/Dequeue Operations Demo ===");
        System.out.println("Initial queue state:");
        queue.display();
        
        // Demonstrate enqueue operations
        System.out.println("\n--- Enqueue Operations ---");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        
        queue.enqueue(40);
        queue.enqueue(50);
        queue.display();
        
        // Try to enqueue when queue is full
        queue.enqueue(60);  // This should show "Queue is full" message
        
        // Demonstrate dequeue operations
        System.out.println("\n--- Dequeue Operations ---");
        queue.dequeue();
        queue.dequeue();
        queue.display();
        
        // Add more elements after dequeuing
        System.out.println("\n--- Adding elements after dequeue ---");
        queue.enqueue(70);
        queue.enqueue(80);
        queue.display();
        
        // Dequeue all remaining elements
        System.out.println("\n--- Dequeuing all elements ---");
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        queue.display();
        
        // Try to dequeue from empty queue
        queue.dequeue();  // This should show "Queue is empty" message
        
        System.out.println("\n=== Demo Complete ===");
    }
}
