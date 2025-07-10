/*
 * StackOperations.c
 * 
 * This file demonstrates stack operations (push, pop, peek) implemented from scratch
 * using array-based approach. Each operation is thoroughly commented.
 * 
 * Stack follows LIFO (Last In, First Out) principle.
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX_SIZE 100

typedef struct {
    int data[MAX_SIZE];
    int top;
    int max_size;
} Stack;

// Initialize stack
void initialize_stack(Stack* stack, int max_size) {
    stack->top = -1;  // Stack is empty initially
    stack->max_size = (max_size < MAX_SIZE) ? max_size : MAX_SIZE;
}

// Check if stack is empty
bool is_empty(Stack* stack) {
    return stack->top == -1;
}

// Check if stack is full
bool is_full(Stack* stack) {
    return stack->top == stack->max_size - 1;
}

// Push operation - add element to top
bool push(Stack* stack, int data) {
    if (is_full(stack)) {
        printf("Stack Overflow! Cannot push %d\n", data);
        return false;
    }
    
    stack->top++;
    stack->data[stack->top] = data;
    printf("Pushed %d to stack. Top index: %d\n", data, stack->top);
    return true;
}

// Pop operation - remove and return top element
int pop(Stack* stack) {
    if (is_empty(stack)) {
        printf("Stack Underflow! Cannot pop from empty stack\n");
        return -1;
    }
    
    int popped_element = stack->data[stack->top];
    stack->top--;
    printf("Popped %d from stack. Top index: %d\n", popped_element, stack->top);
    return popped_element;
}

// Peek operation - view top element without removing
int peek(Stack* stack) {
    if (is_empty(stack)) {
        printf("Stack is empty! Cannot peek\n");
        return -1;
    }
    
    return stack->data[stack->top];
}

// Get current size of stack
int size(Stack* stack) {
    return stack->top + 1;
}

// Display stack contents
void display(Stack* stack) {
    if (is_empty(stack)) {
        printf("Stack is empty\n");
        return;
    }
    
    printf("Stack contents (top to bottom): ");
    for (int i = stack->top; i >= 0; i--) {
        printf("%d ", stack->data[i]);
    }
    printf("\n");
}

int main() {
    Stack stack;
    initialize_stack(&stack, 5);
    
    printf("=== STACK OPERATIONS DEMONSTRATION ===\n");
    
    // Test push operations
    push(&stack, 10);
    push(&stack, 20);
    push(&stack, 30);
    display(&stack);
    
    // Test peek operation
    printf("Top element: %d\n", peek(&stack));
    
    // Test pop operations
    pop(&stack);
    pop(&stack);
    display(&stack);
    
    // Test size
    printf("Current stack size: %d\n", size(&stack));
    
    return 0;
}
