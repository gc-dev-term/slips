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

      int arr[10], burst[10], n, rq[10], no_rq = 0, time = 0;

      int addrq();
      int selectionjob();
      int deleteq(int j);
      int fsahll();

      void main()
      {
          int i, j;
          printf("Enter the job number:");
          scanf("%d", &n);

          for (i = 0; i < n; i++)
          {
              printf("Enter the arrival time p%d:", i);
              scanf("%d", &p[i].atime);
              arr[i] = p[i].atime;
          }

          for (i = 0; i < n; i++)
          {
              printf("Enter the burst time p%d:", i);
              scanf("%d", &p[i].btime);
              burst[i] = p[i].btime;
          }

          addrq();
          printf("Gantt Chart is:");

          while (1)
          {
              j = selectionjob();
              if (j == -1)
              {
                  printf("CPU is ideal");
                  time++;
                  addrq();
              }
              else
              {
                  while (burst[j] != 0)
                  {
                      printf("\t j %d", j);
                      burst[j]--;
                      time++;
                      addrq();
                  }
                  p[j].ft = time;
              }
              if (fsahll() == 1)
                  break;
          }

          int Tat = 0, Twt = 0;
          printf("\n\nJob \t FT \t TAT \t WT");
          for (i = 0; i < n; i++)
          {
              p[i].tat = p[i].ft - p[i].atime;
              p[i].wt = p[i].tat - p[i].btime;
              printf("\nJob %d \t %d \t %d \t %d", i, p[i].ft, p[i].tat, p[i].wt);
              Tat += p[i].tat;
              Twt += p[i].wt;
          }

          float avgtat = (float)Tat / n;
          float avgwt = (float)Twt / n;
          printf("\nAverage turnaround time: %f", avgtat);
          printf("\nAverage waiting time: %f\n", avgwt);
      }

      int addrq()
      {
          int i;
          for (i = 0; i < n; i++)
          {
              if (arr[i] == time)
              {
                  rq[no_rq] = i;
                  no_rq++;
              }
          }
      }

      int selectionjob()
      {
          int i, j;
          if (no_rq == 0)
              return -1;
          j = rq[0];
          for (i = 1; i < no_rq; i++)
              if (burst[j] > burst[rq[i]])
                  j = rq[i];
          deleteq(j);
          return j;
      }

      int deleteq(int j)
      {
          int i;
          for (i = 0; i < no_rq; i++)
              if (rq[i] == j)
                  break;
          for (i = i + 1; i < no_rq; i++)
              rq[i - 1] = rq[i];
          no_rq--;
      }

      int fsahll()
      {
          int i;
          for (i = 0; i < n; i++)
              if (burst[i] != 0)
                  return -1;
          return 1;
      }