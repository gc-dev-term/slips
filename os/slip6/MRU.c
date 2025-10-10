#include <stdio.h>

      int main()
      {
          int n, pages[50], frames[10], pageCount, i, j;
          int pageFaults = 0, mru = 0;
          int lastUsed[10];

          for (i = 0; i < 10; i++)
              frames[i] = -1, lastUsed[i] = -1;

          printf("Enter number of frames: ");
          scanf("%d", &n);

          printf("Enter number of pages: ");
          scanf("%d", &pageCount);

          printf("Enter reference string: ");
          for (i = 0; i < pageCount; i++)
              scanf("%d", &pages[i]);

          printf("\nPage\tFrames\n");

          for (i = 0; i < pageCount; i++)
          {
              int k, replaceIndex = 0, found = 0;

              for (k = 0; k < n; k++)
              {
                  if (frames[k] == pages[i])
                  {
                      found = 1;
                      mru = i;
                      lastUsed[k] = i;
                      break;
                  }
              }

              if (!found)
              {
                  pageFaults++;

                  int maxUsed = -1;
                  for (k = 0; k < n; k++)
                  {
                      if (lastUsed[k] > maxUsed)
                      {
                          maxUsed = lastUsed[k];
                          replaceIndex = k;
                      }
                  }

                  frames[replaceIndex] = pages[i];
                  lastUsed[replaceIndex] = i;
                  mru = i;
              }

              printf("%d\t", pages[i]);
              for (j = 0; j < n; j++)
                  printf("%d\t", frames[j]);
              printf("\n");
          }

          printf("\nTotal Page Faults = %d\n", pageFaults);

          return 0;
      }
      