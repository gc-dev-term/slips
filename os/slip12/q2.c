//Q2 list

/*Operating system List.

$Shell = list operation Dir.

f-> dirname filename.

n- > count of filenmae.

i -> filename & inode.

*/

#include<stdio.h>
#include<unistd.h>
#include<stdlib.h>
#include<string.h>
#include<dirent.h>

//struct dirent{
//	char d_name[20];
//	int ino;
//};

void list(char *tok2,char *tok3){
	int c = 0;
	struct dirent *dir;
	
//	dir -> d_name, dir->ino 
	DIR *dr;
	
	dr = opendir(tok3);
	if(dr == NULL){
		printf("Dir does not exist.");
	}
	
	if(strcmp(tok2,"f") == 0){
		while(dir = readdir(dr))
		printf("\n%s",dir->d_name);
	}else if(strcmp(tok2,"n") == 0){
		while(dir = readdir(dr))
		c++;
		printf("\nttoal number of files :%d",c);
	}else if(strcmp(tok2,"i") == 0){
		while(dir = readdir(dr))
		printf("\n%s\t%d",dir->d_name,dir->d_ino);
	}
	
}

int main(){
	char tok1[10],tok2[10],tok3[10],tok4[10],cmd[30];
	int choice;
	
	while(1){
		printf("\n$shell$:");
		gets(cmd);
		
		if(strcmp(cmd,"exit") == 0){
			exit(0);
		}
		
		int choice = sscanf(cmd,"%s%s%s%s",&tok1,&tok2,&tok3,&tok4);
		if(choice == 3){
			if(strcmp(tok1,"list") == 0){
				list(tok2,tok3);
				continue;
			}
		}
	}
	
}
