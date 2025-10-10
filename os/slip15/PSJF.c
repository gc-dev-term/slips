#include <stdio.h>
      #include <stdbool.h>

      typedef struct process
      {
          bool isc;
          int bt, at, st, wt, ft, tat, nst, oft, pcount;
      } PP;

      PP P[100];
      int tm = 0, n, arr[100], arrv = 0, count = 0;
      float atat = 0, awt = 0;

      void minb(int a[], int k);
      void finda();
      int proc(int s);

      void main()
      {
          int i, a[100], k = 0;
          printf("How many process : ");
          scanf("%d", &n);
          printf("Enter:-\nprocess BTime ATime \n");
          for (i = 1; i <= n; i++)
          {
              printf("P%d\t", i);
              scanf("%d%d", &P[i].bt, &P[i].at);
              P[i].isc = false;
              P[i].pcount = 0;
              count += P[i].bt;
              P[i].wt = 0;
          }

          printf("\nDetails about processes as follows\n\n");
          printf("Process\tBTime\tATime \n");
          for (i = 1; i <= n; i++)
              printf("P%d\t%d\t%d\n", i, P[i].bt, P[i].at);

          printf("\nGantt chart\n");
          for (i = 1; i <= n; i++)
              if (P[i].at == 0) a[++k] = i;

          minb(a, k);

          while (tm != count)
          {
              finda();
              if (arrv == 0)
              {
                  printf("|idl");
                  tm++;
                  count++;
              }
              else
              {
                  minb(arr, arrv);
                  arrv = 0;
              }
          }

          printf("|\n\nDetails about processes as follows\n");
          printf("Process\tBT\tAT \tST\tWT\tFT\tTAT\n");
          for (i = 1; i <= n; i++)
              printf("P%d\t%d\t%d\t%d\t%d\t%d\t%d\n", i, P[i].bt, P[i].at, P[i].st, P[i].wt, P[i].ft, P[i].tat);

          printf("\nAvg wait time=%f\nAvg TAT=%f\n", awt / n, atat / n);
      }

      void finda()
      {
          for (int l = 1; l <= n; l++)
          {
              if (P[l].at <= tm && P[l].isc == false)
                  arr[++arrv] = l;
          }
      }

      void minb(int a[], int k)
      {
          int min = P[a[1]].bt, i, m = a[1];
          for (i = 1; i <= k; i++)
          {
              if (P[a[i]].bt < min)
              {
                  min = P[a[i]].bt;
                  m = a[i];
              }
          }
          proc(m);
      }

      int proc(int s)
      {
          P[s].pcount++;
          if (P[s].pcount == 1)
          {
              P[s].st = tm;
              P[s].wt = P[s].st - P[s].at;
          }
          P[s].nst = tm;
          tm++;
          int k = P[s].nst - P[s].oft;
          P[s].oft = tm;
          if (k > 0) P[s].wt += k;
          if (P[s].pcount == P[s].bt)
          {
              P[s].isc = true;
              P[s].ft = tm;
              P[s].tat = P[s].ft - P[s].at;
              atat += P[s].tat;
              awt += P[s].wt;
          }
          printf("| P%d", s);
          return 0;
      }