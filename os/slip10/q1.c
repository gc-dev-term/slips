//Q1 FIFO


#include<stdio.h>

int page[40];
int n,frame[5],ref[50],victim=-1,pf=0;

int searchp(int p)
{
	int i;
	for(i=0;i<n;i++)
	if(frame[i]==p)
	return i;
	return -1;
}

int selectvictim()
{
	victim++;
	return victim%n;
}

main()
{
	int i,m;
	printf("\nEnter the no. of pages:");
	scanf("%d",&m);

	printf("\nEnter the reference string:");
	for(i=0;i<m;i++)
		scanf("%d",&page[i]);

	printf("\nEnter the no. of frames:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	frame[i]=-1;
	for(i=0;i<m;i++)
	{
		int k,j;
		k=searchp(page[i]);
		if(k==-1)
		{
			pf++;
			k=selectvictim();
			frame[k]=page[i];
		}
	 
		printf("\n req=%d",page[i]);
		for(j=0;j<n;j++)
		printf("\t%d",frame[j]);
	}

	printf("\nPage Fault = %d",pf);
}
