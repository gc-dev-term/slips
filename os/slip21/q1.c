//Q1 childpp

#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>

int main(){
    
    int pid,ppid;
    pid=getpid();
    printf("pid before fork %d\n",pid);
    pid=fork();
    if(pid<0){
        printf("fork faild");
        return 1;
    }
    if(pid==0){
        pid=getpid();
        ppid=getppid();
        printf("I am child\n");
        printf("newly creatd process pid %d parent id %d\n",pid,ppid);
        sleep(5);
    }
    else{
        pid=getpid();
        ppid=getppid();
        printf("I am parent\n");
        printf("process pid %d parent id%d \n",pid,ppid);
    }
    
}
