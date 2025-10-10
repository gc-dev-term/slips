#include <stdio.h>
      #include <stdlib.h>
      #include <string.h>
      #include <unistd.h>

      void typeline(char *tok2, char *tok3)
      {
          FILE *fp;
          int lc = 0;
          char str[256];
          fp = fopen(tok3, "r");
          if (fp == NULL)
          {
              printf("File does not exist!");
          }
          else
          {
              int n = atoi(tok2); // number of lines to print
              while (lc < n && fgets(str, sizeof(str), fp) != NULL)
              {
                  printf("%s", str);
                  lc++;
              }
          }
      }

      void main(int args, char *argv[])
      {
          char tok1[20], tok2[20], tok3[20];
          char cmd[40];
          while (1)
          {
              printf("\nMyshells : ");
              gets(cmd);

              if (strcmp(cmd, "exit") == 0)
                  exit(0);

              int ch = sscanf(cmd, "%s%s%s", &tok1, &tok2, &tok3);
              if (ch == 3)
              {
                  if (strcmp(tok1, "typeline") == 0)
                  {
                      typeline(tok2, tok3);
                      continue;
                  }
              }
              if (fork() == 0)
              {
                  switch (ch)
                  {
                  case 1:
                      execlp(tok1, NULL);
                      break;
                  case 2:
                      execlp(tok1, tok2, NULL);
                      break;
                  case 3:
                      execlp(tok1, tok2, tok3, NULL);
                      break;
                  }
                  exit(0);
              }
          }
      }
      // Example usage: Myshells : typeline 2 data.txt