#include <stdio.h>

      #define MAX_FRAMES 10
      #define MAX_REF 50

      int main() {
          int n, m, i, j, k, page, found, minFreq, lfuIndex;
          int frames[MAX_FRAMES], freq[MAX_FRAMES], refString[MAX_REF];

          // Reference string
          int refLen = 15;
          int reference[] = {3,4,5,4,3,4,7,2,4,5,6,7,2,4,6};

          printf("Enter number of frames (n): ");
          scanf("%d", &n);

          // Initialize frames and frequency
          for(i = 0; i < n; i++) {
              frames[i] = -1;
              freq[i] = 0;
          }

          int pageFaults = 0;

          printf("\nPage\tFrames\n");
          printf("--------------------\n");

          for(i = 0; i < refLen; i++) {
              page = reference[i];
              found = 0;

              // Check if page is already in frames
              for(j = 0; j < n; j++) {
                  if(frames[j] == page) {
                      freq[j]++;
                      found = 1;
                      break;
                  }
              }

              if(!found) {
                  pageFaults++;

                  // Find empty frame
                  int emptyFound = 0;
                  for(j = 0; j < n; j++) {
                      if(frames[j] == -1) {
                          frames[j] = page;
                          freq[j] = 1;
                          emptyFound = 1;
                          break;
                      }
                  }

                  // If no empty frame, replace LFU page
                  if(!emptyFound) {
                      minFreq = freq[0];
                      lfuIndex = 0;
                      for(j = 1; j < n; j++) {
                          if(freq[j] < minFreq) {
                              minFreq = freq[j];
                              lfuIndex = j;
                          }
                      }

                      frames[lfuIndex] = page;
                      freq[lfuIndex] = 1; // reset frequency for new page
                  }
              }

              // Print current frames
              printf("%d\t", page);
              for(j = 0; j < n; j++) {
                  if(frames[j] != -1)
                      printf("%d ", frames[j]);
              }
              printf("\n");
          }

          printf("\nTotal Page Faults: %d\n", pageFaults);

          return 0;
      }