//Q1 LFU

#include <stdio.h>



#define MAX 100



int findLFU(int freq[], int n, int frames[], int size) {

    int min = freq[frames[0]], minIndex = 0;



    for (int i = 1; i < size; i++) {

        if (freq[frames[i]] < min) {

            min = freq[frames[i]];

            minIndex = i;

        }

    }

    return minIndex;

}



int main() {

    int n, frames[MAX], freq[MAX] = {0}, pages[MAX], page_faults = 0, size = 0;



    printf("Enter the number of frames: ");

    scanf("%d", &n);



    printf("Enter the number of pages: ");

    int page_count;

    scanf("%d", &page_count);



    printf("Enter the reference string: ");

    for (int i = 0; i < page_count; i++) {

        scanf("%d", &pages[i]);

    }



    for (int i = 0; i < page_count; i++) {

        int page = pages[i];

        freq[page]++;



        int found = 0;

        for (int j = 0; j < size; j++) {

            if (frames[j] == page) {

                found = 1;

                break;

            }

        }



        if (!found) {

            if (size < n) {

                frames[size++] = page;

            } else {

                int lfuIndex = findLFU(freq, n, frames, size);

                frames[lfuIndex] = page;

            }

            page_faults++;

        }



        printf("Frames: ");

        for (int j = 0; j < size; j++) {

            printf("%d ", frames[j]);

        }

        printf("\n");

    }



    printf("Total page faults: %d\n", page_faults);



    return 0;

}
