#include <stdio.h>
      #include <unistd.h>
      #include <string.h>
      #include <stdlib.h>

      void count(char *tok2, char *tok3)
      {
         int w = 0, c = 0, l = 0;
         FILE *fp;
         fp = fopen(tok3, "r");
         if (fp == NULL)
             printf("File does not exist");
         else
         {
             while (!feof(fp))
             {
                 char ch;
                 ch = fgetc(fp);
                 if (ch == ' ')
                     w++;
                 else if (ch == '\n')
                 {
                     w++;
                     l++;
                 }
                 else
                     c++;
             }
             if (strcmp(tok2, "w") == 0)
                 printf("Word count = %d", w);
             if (strcmp(tok2, "c") == 0)
                 printf("Character count = %d", c);
             if (strcmp(tok2, "l") == 0)
                 printf("Line count = %d", l);
         }
      }

      int main(int argc, char *argv[])
      {
         char cmd[100], tok1[20], tok2[20], tok3[20];
         while (1)
         {
             printf("\nMyshell$:");
             fgets(cmd, sizeof(cmd), stdin);
             if (strncmp(cmd, "exit", 4) == 0)
                 exit(0);
             int ch = sscanf(cmd, "%s%s%s", tok1, tok2, tok3);
             if (ch == 3)
             {
                 if (strcmp(tok1, "count") == 0)
                     count(tok2, tok3);
                 continue;
             }
             if (fork() == 0)
             {
                 switch (ch)
                 {
                 case 1:
                     execlp(tok1, tok1, NULL);
                     break;
                 case 2:
                     execlp(tok1, tok1, tok2, NULL);
                     break;
                 case 3:
                     execlp(tok1, tok1, tok2, tok3, NULL);
                     break;
                 }
             }
         }
      }