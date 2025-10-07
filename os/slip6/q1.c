//Q1 MRU

#include <stdio.h>



#define MAX 100



int findMRU(int frames[], int ref[], int n, int currentIndex, int ref_len) {

    int mruIndex = 0, maxTime = -1;



    for (int i = 0; i < n; i++) {

        int j;

        for (j = currentIndex - 1; j >= 0; j--) {

            if (frames[i] == ref[j]) {

                if (j > maxTime) {

                    maxTime = j;

                    mruIndex = i;

                }

                break;

            }

        }

    }

    return mruIndex;

}



int main() {

    int frames[MAX], ref[MAX], page_faults = 0, n, ref_len;



    printf("Enter the number of frames: ");

    scanf("%d", &n);



    printf("Enter the number of pages in the reference string: ");

    scanf("%d", &ref_len);



    printf("Enter the reference string: ");

    for (int i = 0; i < ref_len; i++) {

        scanf("%d", &ref[i]);

    }



    for (int i = 0; i < n; i++) {

        frames[i] = -1;

    }



    for (int i = 0; i < ref_len; i++) {

        int page = ref[i], found = 0;



        for (int j = 0; j < n; j++) {

            if (frames[j] == page) {

                found = 1;

                break;

            }

        }



        if (!found) {

            if (i < n) {

                frames[i] = page;

            } else {

                int index = findMRU(frames, ref, n, i, ref_len);

                frames[index] = page;

            }

            page_faults++;



            printf("Page %d loaded. Current frames: ", page);

            for (int j = 0; j < n; j++) {

                if (frames[j] != -1) {

                    printf("%d ", frames[j]);

                } else {

                    printf("- ");

                }

            }

            printf("\n");

        }

    }



    printf("Total page faults: %d\n", page_faults);



    return 0;

}
