#include <stdio.h>
#include <stdlib.h>

struct job
{
    int atime;
    int btime;
    int ft;
    int tat;
    int wt;
} p[10];

int arr[10], burst[10], rq[10], no_rq = 0, time = 0, n;

void addrq();
int selectjob();
void delq(int j);
int finishall();

void main()
{
    int i;
    printf("Enter number of jobs : ");
    scanf("%d", &n);

    for (i = 0; i < n; i++)
    {
        printf("Enter arrival time of p%d : ", i);
        scanf("%d", &p[i].atime);
        arr[i] = p[i].atime;
    }

    for (i = 0; i < n; i++)
    {
        printf("Enter burst time of p%d : ", i);
        scanf("%d", &p[i].btime);
        burst[i] = p[i].btime;
    }

    addrq();

    while (1)
    {
        int j = selectjob();
        if (j == -1)
        {
            printf("CPU is Idle\n");
            time++;
            addrq();
        }
        else
        {
            while (burst[j] != 0)
            {
                printf("\tj%d", j);
                burst[j]--;
                time++;
                addrq();
            }
            p[j].ft = time;
        }
        if (finishall() == 1)
            break;
    }

    int Ttat = 0, Twt = 0;
    printf("\n\n Job\t Finish time\t TAT\t WT\n");
    for (i = 0; i < n; i++)
    {
        p[i].tat = p[i].ft - p[i].atime;
        p[i].wt = p[i].tat - p[i].btime;
        printf("job%d \t %d\t \t%d\t %d\n", i, p[i].ft, p[i].tat, p[i].wt);
        Ttat += p[i].tat;
        Twt += p[i].wt;
    }

    printf("\nAverage Turn Around Time = %f", (float)Ttat / n);
    printf("\nAverage Waiting Time = %f", (float)Twt / n);
}

void addrq()
{
    for (int i = 0; i < n; i++)
        if (arr[i] == time)
            rq[no_rq++] = i;
}

int selectjob()
{
    if (no_rq == 0)
        return -1;
    int j = rq[0];
    delq(j);
    return j;
}

void delq(int j)
{
    int i;
    for (i = 0; i < no_rq; i++)
        if (rq[i] == j)
            break;
    for (i = i + 1; i < no_rq; i++)
        rq[i - 1] = rq[i];
    no_rq--;
}

int finishall()
{
    for (int i = 0; i < n; i++)
        if (burst[i] != 0)
            return -1;
    return 1;
      }