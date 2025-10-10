#include <stdio.h>

struct node
{
    int pno, freq;
} frames[20];

int n;

int page_found(int pno)
{
    for (int fno = 0; fno < n; fno++)
        if (frames[fno].pno == pno)
            return fno;
    return -1;
}

int get_free_frame()
{
    for (int fno = 0; fno < n; fno++)
        if (frames[fno].pno == -1)
            return fno;
    return -1;
}

int get_mfu_frame()
{
    int selfno = 0;
    for (int fno = 1; fno < n; fno++)
        if (frames[fno].freq > frames[selfno].freq)
            selfno = fno;
    return selfno;
}

int main()
{
    int p_request[100];
    int size, page_fault = 0, i, j, fno;

    printf("\nEnter how many pages: ");
    scanf("%d", &size);

    printf("\nEnter Reference string: ");
    for (i = 0; i < size; i++)
        scanf("%d", &p_request[i]);

    printf("\nHow many frames: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        frames[i].pno = -1;
        frames[i].freq = 0;
    }

    printf("\nPageNo\tFrames\t\tPage Fault\n");
    printf("---------------------------------------------\n");

    for (i = 0; i < size; i++)
    {
        j = page_found(p_request[i]);

        if (j == -1)
        {
            j = get_free_frame();
            if (j == -1)
                j = get_mfu_frame();

            page_fault++;
            frames[j].pno = p_request[i];
            frames[j].freq = 1;

            printf("%d\t", p_request[i]);
            for (fno = 0; fno < n; fno++)
                printf("%d ", frames[fno].pno);
            printf("\tYES\n");
        }
        else
        {
            frames[j].freq++;
            printf("%d\t", p_request[i]);
            for (fno = 0; fno < n; fno++)
                printf("%d ", frames[fno].pno);
            printf("\tNO\n");
        }
    }

    printf("---------------------------------------------\n");
    printf("Total Page Faults = %d\n", page_fault);

    return 0;
}
