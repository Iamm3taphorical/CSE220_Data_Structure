/*
 * 01InitializeInsert.java
 * 
 * This file demonstrates hashtable initialization and insertion operations
 * implemented from scratch without using built-in functions.
 * Each operation is thoroughly commented for educational purposes.
 * 
 * Topic: Hashtable
 * Operation: Initialize Insert
 */

public class InitializeInsert {
    
    // Hash table entry class
    static class HashEntry {
        String key;
        int value;
        HashEntry next; // For chaining collision resolution
        
        public HashEntry(String key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    
    // Hash table class
    static class HashTable {
        private HashEntry[] buckets;
        private int capacity;
        private int size;
        
        // Constructor to initialize hash table
        public HashTable(int capacity) {
            this.capacity = capacity;
            this.buckets = new HashEntry[capacity];
            this.size = 0;
            
            // Initialize all buckets to null
            for (int i = 0; i < capacity; i++) {
                buckets[i] = null;
            }
        }
        
        // Hash function to compute bucket index
        private int hash(String key) {
            int hash = 0;
            for (int i = 0; i < key.length(); i++) {
                hash = (hash * 31 + key.charAt(i)) % capacity;
            }
            return Math.abs(hash);
        }
        
        // Insert key-value pair into hash table
        public void insert(String key, int value) {
            int index = hash(key);
            
            // Check if key already exists
            HashEntry current = buckets[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    // Update existing key
                    current.value = value;
                    System.out.println("Updated key '" + key + "' with value " + value);
                    return;
                }
                current = current.next;
            }
            
            // Insert new entry at the beginning of the chain
            HashEntry newEntry = new HashEntry(key, value);
            newEntry.next = buckets[index];
            buckets[index] = newEntry;
            size++;
            
            System.out.println("Inserted key '" + key + "' with value " + value + " at index " + index);
        }
        
        // Display hash table contents
        public void display() {
            System.out.println("Hash Table Contents:");
            for (int i = 0; i < capacity; i++) {
                System.out.print("Bucket " + i + ": ");
                HashEntry current = buckets[i];
                if (current == null) {
                    System.out.println("empty");
                } else {
                    while (current != null) {
                        System.out.print("[" + current.key + ":" + current.value + "]");
                        if (current.next != null) {
                            System.out.print(" -> ");
                        }
                        current = current.next;
                    }
                    System.out.println();
                }
            }
            System.out.println("Size: " + size);
        }
        
        // Get current size
        public int getSize() {
            return size;
        }
        
        // Get capacity
        public int getCapacity() {
            return capacity;
        }
    }
    
    // Main method to demonstrate hashtable operations
    public static void main(String[] args) {
        System.out.println("=== HASHTABLE INITIALIZE INSERT DEMONSTRATION ===");
        
        // Create hash table with capacity 7
        HashTable hashTable = new HashTable(7);
        
        System.out.println("Initial hash table:");
        hashTable.display();
        
        System.out.println("\n--- Inserting key-value pairs ---");
        hashTable.insert("apple", 100);
        hashTable.insert("banana", 200);
        hashTable.insert("orange", 300);
        hashTable.insert("grape", 400);
        hashTable.insert("mango", 500);
        
        System.out.println("\nHash table after insertions:");
        hashTable.display();
        
        System.out.println("\n--- Testing collision handling ---");
        hashTable.insert("cherry", 600);
        hashTable.insert("peach", 700);
        
        System.out.println("\nFinal hash table:");
        hashTable.display();
        
        System.out.println("\n--- Testing update operation ---");
        hashTable.insert("apple", 150); // Update existing key
        
        System.out.println("\nHash table after update:");
        hashTable.display();
        
        System.out.println("\n=== DEMONSTRATION COMPLETE ===");
    }
}
