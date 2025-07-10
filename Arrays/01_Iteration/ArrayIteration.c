/*
 * ArrayIteration.c
 * 
 * This file demonstrates various array iteration techniques without using built-in functions.
 * Each method is thoroughly commented to explain the logic and implementation details.
 */

#include <stdio.h>

void forward_iteration(int arr[], int length) {
    if (arr == NULL) {
        printf("Array is null\n");
        return;
    }
    printf("Forward Iteration: ");
    for (int i = 0; i < length; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void backward_iteration(int arr[], int length) {
    if (arr == NULL) {
        printf("Array is null\n");
        return;
    }
    printf("Backward Iteration: ");
    for (int i = length - 1; i >= 0; i--) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int calculate_sum(int arr[], int length) {
    if (arr == NULL) {
        printf("Array is null\n");
        return 0;
    }
    int sum = 0;
    for (int i = 0; i < length; i++) {
        sum += arr[i];
    }
    return sum;
}

int find_maximum(int arr[], int length) {
    if (arr == NULL || length == 0) {
        printf("Array is null or empty\n");
        return -1; // Indicator for failure
    }
    int max = arr[0];
    for (int i = 1; i < length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

int main() {
    int sample_array[] = {10, 25, 3, 47, 12, 89, 5, 33};
    int length = sizeof(sample_array) / sizeof(sample_array[0]);
    printf("=== ARRAY ITERATION DEMONSTRATIONS ===\n");
    forward_iteration(sample_array, length);
    backward_iteration(sample_array, length);
    int sum = calculate_sum(sample_array, length);
    printf("Sum of all elements: %d\n", sum);
    int max = find_maximum(sample_array, length);
    printf("Maximum element: %d\n", max);
    return 0;
}
