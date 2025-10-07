//Q2 fcfs

#include <stdio.h>



struct Process {

    int pid;

    int arrival_time;

    int burst_time;

    int completion_time;

    int turnaround_time;

    int waiting_time;

};



void sort_by_arrival(struct Process p[], int n) {

    struct Process temp;

    for (int i = 0; i < n - 1; i++) {

        for (int j = i + 1; j < n; j++) {

            if (p[i].arrival_time > p[j].arrival_time) {

                temp = p[i];

                p[i] = p[j];

                p[j] = temp;

            }

        }

    }

}



void fcfs_scheduling(struct Process p[], int n) {

    int current_time = 0;

    printf("\nGantt Chart:\n");

    for (int i = 0; i < n; i++) {

        if (current_time < p[i].arrival_time) {

            current_time = p[i].arrival_time;

        }

        printf("P%d [%d - %d] -> ", p[i].pid, current_time, current_time + p[i].burst_time);

        p[i].completion_time = current_time + p[i].burst_time;

        p[i].turnaround_time = p[i].completion_time - p[i].arrival_time;

        p[i].waiting_time = p[i].turnaround_time - p[i].burst_time;

        current_time += p[i].burst_time;

    }

    printf("Finish\n");

}



void calculate_and_display_avg_times(struct Process p[], int n) {

    float total_turnaround_time = 0, total_waiting_time = 0;

    printf("\nProcess\tArrival\tBurst\tCompletion\tTAT\tWT\n");

    for (int i = 0; i < n; i++) {

        total_turnaround_time += p[i].turnaround_time;

        total_waiting_time += p[i].waiting_time;

        printf("P%d\t%d\t%d\t%d\t\t%d\t%d\n", p[i].pid, p[i].arrival_time, p[i].burst_time,

               p[i].completion_time, p[i].turnaround_time, p[i].waiting_time);

    }

    printf("\nAverage Turnaround Time: %.2f", total_turnaround_time / n);

    printf("\nAverage Waiting Time: %.2f\n", total_waiting_time / n);

}



int main() {

    int n;

    printf("Enter the number of processes: ");

    scanf("%d", &n);

    struct Process p[n];

    for (int i = 0; i < n; i++) {

        p[i].pid = i + 1;

        printf("Enter arrival time for process P%d: ", i + 1);

        scanf("%d", &p[i].arrival_time);

        printf("Enter burst time for process P%d: ", i + 1);

        scanf("%d", &p[i].burst_time);

    }

    sort_by_arrival(p, n);

    fcfs_scheduling(p, n);

    calculate_and_display_avg_times(p, n);

    return 0;

}
