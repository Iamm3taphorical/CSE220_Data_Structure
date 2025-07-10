/*
 * ArrayIteration.cpp
 * 
 * This file demonstrates various array iteration techniques without using built-in functions.
 * Each method is thoroughly commented to explain the logic and implementation details.
 */

#include <iostream>
#include <vector>
#include <climits>

class ArrayIteration {
public:
    static void forwardIteration(const std::vector<int>& arr) {
        if (arr.empty()) {
            std::cout << "Array is empty" << std::endl;
            return;
        }
        std::cout << "Forward Iteration: ";
        for (size_t i = 0; i < arr.size(); i++) {
            std::cout << arr[i] << " ";
        }
        std::cout << std::endl;
    }
    
    static void backwardIteration(const std::vector<int>& arr) {
        if (arr.empty()) {
            std::cout << "Array is empty" << std::endl;
            return;
        }
        std::cout << "Backward Iteration: ";
        for (int i = arr.size() - 1; i >= 0; i--) {
            std::cout << arr[i] << " ";
        }
        std::cout << std::endl;
    }
    
    static int calculateSum(const std::vector<int>& arr) {
        if (arr.empty()) {
            std::cout << "Array is empty" << std::endl;
            return 0;
        }
        int sum = 0;
        for (size_t i = 0; i < arr.size(); i++) {
            sum += arr[i];
        }
        return sum;
    }
    
    static int findMaximum(const std::vector<int>& arr) {
        if (arr.empty()) {
            std::cout << "Array is empty" << std::endl;
            return INT_MIN;
        }
        int max = arr[0];
        for (size_t i = 1; i < arr.size(); i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    static bool conditionalIteration(const std::vector<int>& arr, int target) {
        if (arr.empty()) {
            std::cout << "Array is empty" << std::endl;
            return false;
        }
        std::cout << "Searching for: " << target << std::endl;
        for (size_t i = 0; i < arr.size(); i++) {
            if (arr[i] == target) {
                std::cout << "Found " << target << " at index " << i << std::endl;
                return true;
            }
        }
        std::cout << target << " not found in array" << std::endl;
        return false;
    }
};

int main() {
    std::vector<int> sampleArray = {10, 25, 3, 47, 12, 89, 5, 33};
    
    std::cout << "=== ARRAY ITERATION DEMONSTRATIONS ===" << std::endl;
    
    ArrayIteration::forwardIteration(sampleArray);
    ArrayIteration::backwardIteration(sampleArray);
    ArrayIteration::conditionalIteration(sampleArray, 47);
    
    int sum = ArrayIteration::calculateSum(sampleArray);
    std::cout << "Sum of all elements: " << sum << std::endl;
    
    int max = ArrayIteration::findMaximum(sampleArray);
    std::cout << "Maximum element: " << max << std::endl;
    
    return 0;
}
