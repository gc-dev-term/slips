#include <stdio.h>
      #include <sys/types.h>
      #include <unistd.h>
      #include <stdlib.h>

      void bass(int arr[], int n)
      {
          int i, j, temp;
          for (i = 0; i < n - 1; i++)
          {
              for (j = 0; j < n - i - 1; j++)
              {
                  if (arr[j] > arr[j + 1])
                  {
                      temp = arr[j];
                      arr[j] = arr[j + 1];
                      arr[j + 1] = temp;
                  }
              }
          }
          printf("\nAscending order\n");
          for (i = 0; i < n; i++)
              printf("\t%d", arr[i]);
          printf("\n\n\n");
      }

      void bdsc(int arr[], int n)
      {
          int i, j, temp;
          for (i = 0; i < n; i++)
          {
              for (j = 0; j < n - 1; j++)
              {
                  if (arr[j] < arr[j + 1])
                  {
                      temp = arr[j];
                      arr[j] = arr[j + 1];
                      arr[j + 1] = temp;
                  }
              }
          }
          printf("\nDescending Sorting\n\n");
          for (i = 0; i < n; i++)
              printf("\t%d", arr[i]);
          printf("\n\n\n");
      }

      void forkeg()
      {
          int arr[25], n, i, status;
          printf("\nEnter the no. of values of array");
          scanf("%d", &n);
          printf("Enter the array elements:");
          for (i = 0; i < n; i++)
              scanf("%d", &arr[i]);
          int pid = fork();
          if (pid == 0)
          {
              sleep(10);
              printf("\n child process \n");
              printf("child process id=%d\n", getpid());
              bass(arr, n);
              printf("\nElements Sorted using insertion sort\n");
              for (i = 0; i < n; i++)
                  printf("%d ", arr[i]);
              printf("\nParent process id=%d\n", getppid());
              system("ps -x");
          }
          else
          {
              printf("\nparent process \n");
              printf("\nparent process id=%d\n", getppid());
              bdsc(arr, n);
              printf("Elements sorted using bubble sort\n");
              for (i = 0; i < n; i++)
                  printf("%d ", arr[i]);
              printf("\n\n\n");
          }
      }

      int main()
      {
          forkeg();
          return 0;
      }