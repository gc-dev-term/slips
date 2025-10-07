//Q1 LRU



#include<stdio.h>

int pf=0,pg;
int f,frame[5],ref[50],victim=0,time[50];

int searchpage(int p)
{
	int i;
	for(i=0;i<f;i++)
	if(frame[i]==p)
	return i;
	return -1;
}

int selectvictim()
{
	int min=0,i;
	for(i=1;i<f;i++)
	{
		if(time[i]<time[min])
		min=i;
	}
	return min;
}

main()
{
	int i;
	printf("\nEnter the no.of frames : ");
	scanf("%d",&f);
	for(i=0;i<f;i++)
	frame[i]=-1;
	for(i=0;i<f;i++)
	time[i]=-1;

	printf("\nEnter the no. of pages : ");
	scanf("%d",&pg);

	printf("\nEnter the page(reference string) : ");
	for(i=0;i<pg;i++)
	scanf("%d",&ref[i]);

	for(i=0;i<pg;i++)
	{
		int k,j;
		k=searchpage(ref[i]);
		if(k==-1)
		{
			pf++;
			k=selectvictim();
			frame[k]=ref[i];
		}
		time[k]=i;
		printf("\n pg=%d |",ref[i]);
		for(j=0;j<f;j++)
		printf("\t%d",frame[j]);
	}
	printf("\nPage Fault is = %d",pf);
}
