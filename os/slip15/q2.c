//Q2 psjf

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

struct job{
	bool isc;
	int at; //arraival time.
	int bt; //brust time.
	int st; //Start time.
	int nst; //new start time.
	int oft; //old finish time;
	int pcount; // preocess to be count.
	int ft; //finish time.
	int tat; //Trun around time.
	int wt; // waiting time.
}p[100];

int n,arr[100],tm=0,arrv=0,count=0;

float Tat,Wt;

void main(){
	int i,k=0,a[100];
	
	printf("How many Process: ");
	scanf("%d",&n);
	
	printf("Enter :-\nProcess BT AT\n");
	for(i=1;i<=n;i++){
		printf("p%d\t",i);
		scanf("%d%d",&p[i].bt,&p[i].at);
		p[i].isc=false;
		p[i].pcount=0;
		count += p[i].bt;
		p[i].wt=0;
	}
	
	printf("Process BT AT \n");
	for(i=1;i<=n;i++)
		printf("p%d %d %d\n",i,p[i].bt,p[i].at);
		
	
	printf("\nGantt chart\n");
	for(i=1;i<=n;i++)
		{
		if(p[i].at==0)
			{
			a[++k]=i;
			}
		}
	minbrust(a,k);
	while(tm!=count)
	{
		selecta();
		
		if(arrv==0)
			{
			printf("|idl");
			tm+=1;
			count+=1;
			}
		else
			{
			minbrust(arr,arrv);
			arrv=0;
			}

	}
	
	printf("\n _________________________#######################______________________\n");
	printf("\nProcess\tBT\tAT \tST\tWT\tFT\tTAT\n");
	for(i=1;i<=n;i++)
		printf("P%d\t%d\t%d\t%d\t%d\t%d\t%d\n",i,p[i].bt,p[i].at,p[i].st,p[i].wt,p[i].ft,p[i].tat);
	
	printf("\nAvg wait time=%f",Wt/n);
	printf("\nAvg TAT=%f\n",Tat/n);
}


void minbrust(int a[],int k){

	int min=p[a[1]].bt,i,m=a[1];
	for(i=1;i<=k;i++)
	{
		if(p[a[i]].bt<min)
		{
			min=p[a[i]].bt;
			m=a[i];
		}
	}
	process(m);
}


process(int s)
{
	int k;
	p[s].pcount++;
	if(p[s].pcount==1)
	{
		p[s].wt=p[s].st-p[s].at;
		p[s].st=tm;
	}
	p[s].nst=tm;
	tm++;
	
	k=p[s].nst-p[s].oft;
	p[s].oft=tm;
	
	if(k>0)
	p[s].wt+=k;
	if(p[s].pcount==p[s].bt)
	{
		p[s].isc=true;
		p[s].ft=tm;
		p[s].tat=p[s].ft-p[s].at;
		Tat+=p[s].tat;
		Wt+=p[s].wt;
	}

	printf("p%d   ",s);
}


selecta(){
	int i;
	for(i=1;i<=n;i++)
	{
		if(p[i].at<=tm && p[i].isc==false)
		arr[++arrv]=i;	
	}
}
