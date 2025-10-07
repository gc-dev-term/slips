//Q1 optimal

#include <stdio.h>
int main() {
int frames, n;
// Ask the user to enter the number of frames
        printf("Enter the number of frames: ");
        scanf("%d", &frames);
// Ask the user to enter the number of pages in the reference string
        printf("Enter the number of pages in the reference string: ");
        scanf("%d", &n);
        int pages[n];
        int frame[frames];
        int pageFaults = 0;
// Initialize the frame array with -1 (to represent empty frames)
        for (int i = 0; i < frames; i++) 
      {
        frame[i] = -1;
      }
// Ask the user to input the reference string
        printf("Enter the reference string: ");
        for (int i = 0; i < n; i++) {
        scanf("%d", &pages[i]);
      }
// Loop through the reference string and simulate page replacement
           for (int i = 0; i < n; i++) {
           int page = pages[i];
           int pageFound = 0;
// Check if the page is already in a frame
           for (int j = 0; j < frames; j++) {
           if (frame[j] == page) {
           pageFound = 1;break;
        }
                                            }
if (!pageFound) {
int replaceIndex = -1;
// Find the page in the future reference string that will be used farthest
for (int j = 0; j < frames; j++) {
int nextPage = -1;
for (int k = i + 1; k < n; k++) {
if (pages[k] == frame[j]) {
nextPage = k;
break;
}
}
// If the page won't be used in the future, or it hasn't been set yet, replace it
if (nextPage == -1) {
replaceIndex = j;
break;
}
// If the page will be used farther in the future,update the replacement index
if (replaceIndex == -1 || nextPage > i + 1) {
replaceIndex = j;
}
}
// Replace the page in the frame and count the page fault
frame[replaceIndex] = page;
pageFaults++;
}
// Print the current state of frames and the total page faults
printf("Page %d -> [", page);for (int j = 
0; j < frames; j++) {
printf("%d ", frame[j]);
}
printf("] Page Faults: %d\n", pageFaults);
}
// Print the total number of page faults
printf("Total Page Faults: %d\n", pageFaults);
return 0;
}
