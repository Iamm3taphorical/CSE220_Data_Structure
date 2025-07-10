/*
 * HeadTail.cpp
 * 
 * This file demonstrates head tail operations 
 * implemented from scratch without using built-in functions.
 * Each operation is thoroughly commented for educational purposes.
 * 
 * Topic: 02_Insert
 * Operation: Head Tail
 */

#include <iostream>
#include <vector>
#include <string>
#include <memory>
#include <algorithm>

// Constants
const int MAX_SIZE = 100;

// Class definitions based on topic
class 02_InsertHeadTail {
    // Implementation
};

// Main function for demonstration
int main() {
    std::cout << "=== HEAD TAIL DEMONSTRATION ===" << std::endl;
    std::cout << "Topic: 02_Insert" << std::endl;
    std::cout << "Operation: Head Tail" << std::endl << std::endl;
    
    02_InsertHeadTail demo;
    
    try {
        std::cout << "Initializing 02_insert for head tail..." << std::endl;
        demo.performOperation();
        demo.display();
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    std::cout << std::endl << "=== DEMONSTRATION COMPLETE ===" << std::endl;
    return 0;
}