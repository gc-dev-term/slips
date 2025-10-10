#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/wait.h>


int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int main() {
    int n, i;
    printf("Enter number of elements: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter %d integers:\n", n);
    for (i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    qsort(arr, n, sizeof(int), compare);

    printf("\nSorted Array: ");
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");

    char *args[n + 3];
    args[0] = "./child";
    char size_str[10];
    sprintf(size_str, "%d", n);
    args[1] = size_str;

    for (i = 0; i < n; i++) {
        char *num_str = malloc(10);
        sprintf(num_str, "%d", arr[i]);
        args[i + 2] = num_str;
    }

    args[n + 2] = NULL;

    pid_t pid = fork();

    if (pid == 0) {
        execve(args[0], args, NULL);
        perror("execve failed");
        exit(1);
    } else if (pid > 0) {
        wait(NULL);
        printf("\nParent: Child process finished.\n");
    } else {
        perror("Fork failed");
    }

    return 0;
}
// cc child.c -o child
// cc parent.c -o parent
// ./parent
// Enter number of elements : 5
// 8 2 9 1 4
// Enter element to search : 8
