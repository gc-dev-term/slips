#include <stdio.h>
      int main()
      {
          int frames, n;

          printf("Enter the number of frames: ");
          scanf("%d", &frames);

          printf("Enter the number of pages in the reference string: ");
          scanf("%d", &n);
          int pages[n];
          int frame[frames];
          int pageFaults = 0;

          for (int i = 0; i < frames; i++)
          {
              frame[i] = -1;
          }

          printf("Enter the reference string: ");
          for (int i = 0; i < n; i++)
          {
              scanf("%d", &pages[i]);
          }

          for (int i = 0; i < n; i++)
          {
              int page = pages[i];
              int pageFound = 0;

              for (int j = 0; j < frames; j++)
              {
                  if (frame[j] == page)
                  {
                      pageFound = 1;
                      break;
                  }
              }
              if (!pageFound)
              {
                  int replaceIndex = -1;

                  for (int j = 0; j < frames; j++)
                  {
                      int nextPage = -1;
                      for (int k = i + 1; k < n; k++)
                      {
                          if (pages[k] == frame[j])
                          {
                              nextPage = k;
                              break;
                          }
                      }

                      if (nextPage == -1)
                      {
                          replaceIndex = j;
                          break;
                      }

                      if (replaceIndex == -1 || nextPage > i + 1)
                      {
                          replaceIndex = j;
                      }
                  }

                  frame[replaceIndex] = page;
                  pageFaults++;
              }

              printf("Page %d -> [", page);
              for (int j = 0; j < frames; j++)
              {
                  printf("%d ", frame[j]);
              }
              printf("] Page Faults: %d\n", pageFaults);
          }

          printf("Total Page Faults: %d\n", pageFaults);
          return 0;
      }