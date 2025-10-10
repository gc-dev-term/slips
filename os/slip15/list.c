#include <stdio.h>
      #include <unistd.h>
      #include <string.h>
      #include <stdlib.h>
      #include <dirent.h>

      void list(char *tok2, char *tok3)
      {
         DIR *dp;
         struct dirent *dir;
         dp = opendir(tok3);
         if (dp == NULL)
             printf("%s directory not exist", tok3);
         else
         {
             if (strcmp(tok2, "f") == 0)
             {
                 while ((dir = readdir(dp)) != NULL)
                     printf("%s\n", dir->d_name);
             }
         }
      }

      void main(int argc, char *argv[])
      {
         char cmd[100], tok1[20], tok2[20], tok3[20];
         while (1)
         {
             printf("\nMyShell $:");
             fgets(cmd, sizeof(cmd), stdin);

             if (strncmp(cmd, "exit", 4) == 0)
                 exit(0);

             int ch = sscanf(cmd, "%s%s%s", tok1, tok2, tok3);
             if (ch == 3 && strcmp(tok1, "list") == 0)
             {
                 list(tok2, tok3);
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
                 exit(0);
             }
         }
      }