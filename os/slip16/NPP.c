#include <stdio.h>
      #include <stdlib.h>

      struct job
      {
          int atime;
          int btime;
          int ft;
          int tat;
          int wt;
          int pri;
      } p[10];

      int arr[10], brust[10], n, rq[10], no_rq = 0, time = 0, j = -1;

      int addrq();
      int selectionjob();
      int deleteq(int k);
      int fsahll();

      void main()
      {
          int i;
          printf("Enter the number of jobs: ");
          scanf("%d", &n);

          for (i = 0; i < n; i++)
          {
              printf("Enter arrival time p%d: ", i);
              scanf("%d", &p[i].atime);
              arr[i] = p[i].atime;
          }

          for (i = 0; i < n; i++)
          {
              printf("Enter burst time p%d: ", i);
              scanf("%d", &p[i].btime);
              brust[i] = p[i].btime;
          }

          for (i = 0; i < n; i++)
          {
              printf("Enter priority p%d: ", i);
              scanf("%d", &p[i].pri);
          }

          addrq();

          while (1)
          {
              j = selectionjob();
              if (j == -1)
              {
                  printf("CPU is idle\n");
                  time++;
                  addrq();
              }
              else
              {
                  while (brust[j] != 0)
                  {
                      printf("\t j %d", j);
                      brust[j]--;
                      time++;
                      addrq();
                  }
                  p[j].ft = time;
              }
              if (fsahll() == 1)
                  break;
          }

          int Tat = 0, Twt = 0;
          printf("\nJob \t FT \t TAT \t WT\n");
          for (i = 0; i < n; i++)
          {
              p[i].tat = p[i].ft - p[i].atime;
              p[i].wt = p[i].tat - p[i].btime;
              printf("Job %d \t %d \t %d \t %d\n", i, p[i].ft, p[i].tat, p[i].wt);
              Tat += p[i].tat;
              Twt += p[i].wt;
          }
          printf("Average Turnaround Time: %f\n", (float)Tat / n);
          printf("Average Waiting Time: %f\n", (float)Twt / n);
      }

      int addrq()
      {
          for (int i = 0; i < n; i++)
          {
              if (arr[i] == time)
              {
                  rq[no_rq++] = i;
              }
          }
      }

      int selectionjob()
      {
          if (no_rq == 0)
              return -1;
          int k = rq[0];
          for (int i = 1; i < no_rq; i++)
              if (p[k].pri < p[rq[i]].pri)
                  k = rq[i];
          deleteq(k);
          return k;
      }

      int deleteq(int k)
      {
          int i;
          for (i = 0; i < no_rq; i++)
              if (rq[i] == k)
                  break;
          for (i = i + 1; i < no_rq; i++)
              rq[i - 1] = rq[i];
          no_rq--;
      }

      int fsahll()
      {
          for (int i = 0; i < n; i++)
              if (brust[i] != 0)
                  return -1;
          return 1;
      }