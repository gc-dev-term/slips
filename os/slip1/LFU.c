#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n, i, j, k, page_faults = 0, min_freq, replace_index;

    printf("Enter number of frames: ");
    scanf("%d", &n);

    int frames[n];
    int freq[n];
    for (i = 0; i < n; i++)
    {
        frames[i] = -1;
        freq[i] = 0;
    }

    int ref_str[] = {3, 4, 5, 4, 3, 4, 7, 2, 4, 5, 6, 7, 2, 4, 6};
    int ref_len = sizeof(ref_str) / sizeof(ref_str[0]);

    printf("\nPage reference string: ");
    for (i = 0; i < ref_len; i++)
        printf("%d ", ref_str[i]);
    printf("\n\n");

    printf("Page frames status:\n");

    for (i = 0; i < ref_len; i++)
    {
        int found = 0;
        for (j = 0; j < n; j++)
        {
            if (frames[j] == ref_str[i])
            {
                freq[j]++;
                found = 1;
                break;
            }
        }

        if (!found)
        {
            page_faults++;
            int empty_found = 0;
            for (j = 0; j < n; j++)
            {
                if (frames[j] == -1)
                {
                    frames[j] = ref_str[i];
                    freq[j] = 1;
                    empty_found = 1;
                    break;
                }
            }

            if (!empty_found)
            {
                min_freq = freq[0];
                replace_index = 0;
                for (j = 1; j < n; j++)
                {
                    if (freq[j] < min_freq)
                    {
                        min_freq = freq[j];
                        replace_index = j;
                    }
                }
                frames[replace_index] = ref_str[i];
                freq[replace_index] = 1;
            }
        }

        for (k = 0; k < n; k++)
        {
            if (frames[k] != -1)
                printf("%d\t", frames[k]);
            else
                printf("-\t");
        }
        if (found)
            printf("No Page Fault\n");
        else
            printf("Page Fault\n");
    }

    printf("\nTotal Page Faults = %d\n", page_faults);

    return 0;
}
