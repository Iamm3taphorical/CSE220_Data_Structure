"""
ArrayIteration.py

This file demonstrates various array iteration techniques without using built-in functions.
Each method is thoroughly commented to explain the logic and implementation details.

Learning Objectives:
- Understand how to traverse arrays using different approaches
- Learn about index management and boundary conditions
- Practice implementing iteration patterns from scratch
"""

class ArrayIteration:
    
    @staticmethod
    def forward_iteration(arr):
        """
        Method to perform forward iteration through an array
        This traverses from index 0 to length-1
        
        Args:
            arr: The input list to iterate through
        """
        # Check if array is None to avoid AttributeError
        if arr is None:
            print("Array is None")
            return
        
        print("Forward Iteration: ", end="")
        
        # Classic for loop approach using range
        # range(len(arr)) generates 0, 1, 2, ..., len(arr)-1
        for i in range(len(arr)):
            print(arr[i], end=" ")
        print()  # New line after iteration
    
    @staticmethod
    def backward_iteration(arr):
        """
        Method to perform backward iteration through an array
        This traverses from index length-1 to 0
        
        Args:
            arr: The input list to iterate through
        """
        # Check if array is None to avoid AttributeError
        if arr is None:
            print("Array is None")
            return
        
        print("Backward Iteration: ", end="")
        
        # Start from the last valid index (length - 1)
        # range(len(arr)-1, -1, -1) generates len(arr)-1, len(arr)-2, ..., 0
        for i in range(len(arr) - 1, -1, -1):
            print(arr[i], end=" ")
        print()  # New line after iteration
    
    @staticmethod
    def conditional_iteration(arr, target):
        """
        Method to perform conditional iteration
        This demonstrates how to iterate while checking conditions
        
        Args:
            arr: The input list to search through
            target: The value to search for
            
        Returns:
            bool: True if target was found, False otherwise
        """
        # Check if array is None to avoid AttributeError
        if arr is None:
            print("Array is None")
            return False
        
        print(f"Searching for: {target}")
        
        # Iterate through array to find target
        for i in range(len(arr)):
            # Check current element against target
            if arr[i] == target:
                print(f"Found {target} at index {i}")
                return True  # Early termination when found
        
        print(f"{target} not found in array")
        return False  # Target not found after complete iteration
    
    @staticmethod
    def calculate_sum(arr):
        """
        Method to calculate sum using iteration
        This demonstrates aggregation through iteration
        
        Args:
            arr: The input list to sum
            
        Returns:
            int: The sum of all elements
        """
        # Check if array is None to avoid AttributeError
        if arr is None:
            print("Array is None")
            return 0
        
        sum_result = 0  # Initialize accumulator variable
        
        # Iterate through each element
        for i in range(len(arr)):
            sum_result = sum_result + arr[i]  # Add current element to sum
            # This could also be written as: sum_result += arr[i]
        
        return sum_result  # Return accumulated sum
    
    @staticmethod
    def find_maximum(arr):
        """
        Method to find maximum element using iteration
        This demonstrates finding extremes through iteration
        
        Args:
            arr: The input list to search
            
        Returns:
            int: The maximum value, or None if array is empty/None
        """
        # Check if array is None or empty
        if arr is None or len(arr) == 0:
            print("Array is None or empty")
            return None
        
        # Assume first element is maximum
        max_val = arr[0]
        
        # Start iteration from second element (index 1)
        for i in range(1, len(arr)):
            # If current element is greater than current max
            if arr[i] > max_val:
                max_val = arr[i]  # Update max to current element
        
        return max_val  # Return the maximum value found
    
    @staticmethod
    def step_iteration(arr, step):
        """
        Method to demonstrate step-based iteration
        This shows how to iterate with custom step sizes
        
        Args:
            arr: The input list to iterate through
            step: The step size for iteration
        """
        # Check if array is None to avoid AttributeError
        if arr is None:
            print("Array is None")
            return
        
        # Check if step is valid (positive)
        if step <= 0:
            print("Step must be positive")
            return
        
        print(f"Step Iteration (step={step}): ", end="")
        
        # Start at index 0 and increment by step each time
        # range(0, len(arr), step) generates 0, step, 2*step, ...
        for i in range(0, len(arr), step):
            print(arr[i], end=" ")
        print()  # New line after iteration
    
    @staticmethod
    def while_loop_iteration(arr):
        """
        Method to demonstrate while loop iteration
        This shows an alternative to for loops
        
        Args:
            arr: The input list to iterate through
        """
        # Check if array is None to avoid AttributeError
        if arr is None:
            print("Array is None")
            return
        
        print("While Loop Iteration: ", end="")
        
        i = 0  # Initialize counter outside loop
        
        # Continue while counter is less than array length
        while i < len(arr):
            print(arr[i], end=" ")
            i += 1  # Increment counter manually
        print()  # New line after iteration


def main():
    """
    Main function to demonstrate all iteration techniques
    This serves as a comprehensive example of array iteration
    """
    # Create a sample list for demonstration
    sample_array = [10, 25, 3, 47, 12, 89, 5, 33]
    
    print("=== ARRAY ITERATION DEMONSTRATIONS ===")
    print("Sample Array: [10, 25, 3, 47, 12, 89, 5, 33]")
    print()
    
    # Demonstrate forward iteration
    ArrayIteration.forward_iteration(sample_array)
    
    # Demonstrate backward iteration
    ArrayIteration.backward_iteration(sample_array)
    
    # Demonstrate conditional iteration
    ArrayIteration.conditional_iteration(sample_array, 47)
    ArrayIteration.conditional_iteration(sample_array, 100)
    
    # Demonstrate sum calculation
    sum_result = ArrayIteration.calculate_sum(sample_array)
    print(f"Sum of all elements: {sum_result}")
    
    # Demonstrate finding maximum
    max_val = ArrayIteration.find_maximum(sample_array)
    print(f"Maximum element: {max_val}")
    
    # Demonstrate step iteration
    ArrayIteration.step_iteration(sample_array, 2)
    ArrayIteration.step_iteration(sample_array, 3)
    
    # Demonstrate while loop iteration
    ArrayIteration.while_loop_iteration(sample_array)
    
    # Test with edge cases
    print("\n=== EDGE CASE TESTING ===")
    
    # Test with None array
    ArrayIteration.forward_iteration(None)
    
    # Test with empty array
    empty_array = []
    ArrayIteration.forward_iteration(empty_array)
    
    # Test with single element array
    single_element = [42]
    ArrayIteration.forward_iteration(single_element)
    print(f"Single element max: {ArrayIteration.find_maximum(single_element)}")


if __name__ == "__main__":
    main()
