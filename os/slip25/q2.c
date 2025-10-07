//Q2 searchf


#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>

// Function to perform bubble sort on the array
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

// Function to convert an integer to string
char *itoa(int val) {
    static char buf[32] = {0};
    snprintf(buf, sizeof(buf), "%d", val);
    return buf;
}

int main(int argc, char *argv[]) {
    int arr[] = {23, 1, 45, 78, 12, 90};
    int n = sizeof(arr) / sizeof(arr[0]);
    pid_t pid;

    // Sorting the array
    bubbleSort(arr, n);

    // Forking the process
    pid = fork();

    if (pid < 0) {
        // Fork failed
        perror("fork failed");
        exit(1);
    } else if (pid == 0) {
        // Child process: Execute binary search program
        char *args[n+2]; // One extra for the search item, one for NULL termination
        args[0] = "./child_binary_search"; // Path to the binary search program

        // Pass sorted array to the child process
        for (int i = 0; i < n; i++) {
            args[i + 1] = itoa(arr[i]);
        }
        args[n+1] = NULL; // Last argument should be NULL for execve

        // Execute new program
        execve(args[0], args, NULL);
        perror("execve failed"); // If execve fails
        exit(1);
    } else {
        // Parent process: Wait for child to complete
        wait(NULL);
    }

    return 0;
}