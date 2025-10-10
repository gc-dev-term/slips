#include <stdio.h>

      int page[50];
      int n, frame[5], refLen, victim = -1, pf = 0;

      int searchPage(int p)
      {
          for (int i = 0; i < n; i++)
          {
              if (frame[i] == p)
                  return i;
          }
          return -1;
      }

      int selectVictim()
      {
          victim++;
          return victim % n;
      }

      int main()
      {
          int i, j;

          refLen = 15;
          int reference[] = {2, 4, 5, 6, 9, 4, 7, 3, 4, 5, 6, 7, 2, 4, 7, 1};

          printf("Enter number of frames: ");
          scanf("%d", &n);

          for (i = 0; i < n; i++)
              frame[i] = -1;

          printf("\nPage\tFrames\n");
          printf("-------------------\n");

          for (i = 0; i < refLen; i++)
          {
              int k = searchPage(reference[i]);

              if (k == -1)
              {
                  pf++;
                  int victimIndex = selectVictim();
                  frame[victimIndex] = reference[i];
              }

              printf("%d\t", reference[i]);
              for (j = 0; j < n; j++)
                  if (frame[j] != -1)
                      printf("%d ", frame[j]);
              printf("\n");
          }

          printf("\nTotal Page Faults = %d\n", pf);

          return 0;
      }