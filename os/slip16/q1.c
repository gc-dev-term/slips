//Q1 count.c

/*Opereating System Program on Count
				c \w\l
$shell = count operation filename;

filename
w->Word .
c->charater
l->line.
*/

#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<string.h>

void count(char *tok2,char *tok3){
	int c=0,l=0,w=0;
	FILE *fp;
	fp = fopen(tok3,"r");
	
	if(fp == NULL){
		printf("File does not exist.");
	}else{
		printf("File exist");
	}
	
	while(!feof(fp)){
		char ch;
		ch = fgetc(fp);
		
		c++;
		// sanket nalage
		if(ch == ' ' || ch == '\t'){
			w++;
		}
		//sanket
		//tejas
		if(ch == '\n'){
			w++;
			l++;
		}
	}
	
	if(strstr(tok2,"c") != NULL){
		printf("No. of character:%d",c);
	}
	
	if(strstr(tok2,"w") != NULL){
		printf("No. of Word:%d",w);
	}
	
	if(strstr(tok2,"l") != NULL){
		printf("No. of line:%d",l);
	}
}

int main(int argc,char *argv){
	char tok1[10],tok2[10],tok3[10],tok4[10],cmd[30];
	int choice;
	
	while(1){
		printf("\n$MYShell$:");
		gets(cmd);
		
		if(strcmp(cmd,"exit") == 0){
			exit(0);
		}
		
		int choice = sscanf(cmd,"%s%s%s%s",&tok1,&tok2,&tok3,&tok4);
		if(choice == 3){
			if(strcmp(tok1,"count") == 0){
				count(tok2,tok3);
				continue;
			}
		/*	if(fork() == 0){
				switch(choice){
					case 1:
						excelp(tok1,NULL);
						break;
						
					case 2:
						excelp(tok1,tok2,NULL);
						break;
						
					case 3:
						excelp(tok1,tok2,tok3,NULL);
						break;
						
					case 4:
						excelp(tok1,tok2,tok3,tok4,NULL);
						break;
				}
				exit(0);
			}*/
		}
	}
}
