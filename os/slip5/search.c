#include <stdio.h>
      #include <stdlib.h>
      #include <string.h>
      #include <unistd.h>

      void search(char *tok2, char *tok3, char *tok4)
      {
          FILE *fp;
          char str[256];
          fp = fopen(tok4, "r");
          if (fp == NULL)
          {
              printf("File does not exist!");
          }
          else
          {
              int lineno = 0;
              int count = 0;

              if (strcmp(tok2, "f") == 0)
              {
                  while (!feof(fp))
                  {
                      fgets(str, sizeof(str), fp);
                      lineno++;
                      if (strstr(str, tok3))
                      {
                          printf("First Occurance of %s is on line no : %d", tok3, lineno);
                          break;
                      }
                  }
              }

              if (strcmp(tok2, "c") == 0)
              {
                  while (!feof(fp))
                  {
                      fgets(str, sizeof(str), fp);
                      if (strstr(str, tok3))
                      {
                          count++;
                      }
                  }
                  printf("TOtal number of Occurance of pattern ( %s ) is : %d", tok3, count);
              }

              if (strcmp(tok2, "a") == 0)
              {
                  while (!feof(fp))
                  {
                      fgets(str, sizeof(str), fp);
                      lineno++;
                      if (strstr(str, tok3))
                      {
                          printf("line no : %d and pattern is : %s\n", lineno, tok3);
                      }
                  }
              }
          }
      }

      void main(int args, char *argv[])
      {
          char tok1[20], tok2[20], tok3[20], tok4[20], fname[20];
          char cmd[40];
          while (1)
          {
              printf("\nMyshells : ");
              gets(cmd);

              if (strcmp(cmd, "exit") == 0)
              {
                  exit(0);
              }

              int ch = sscanf(cmd, "%s%s%s%s", &tok1, &tok2, &tok3, &tok4);
              if (ch == 4)
              {
                  if (strcmp(tok1, "search") == 0)
                  {
                      search(tok2, tok3, tok4);
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
                  case 4:
                      execlp(tok1, tok2, tok3, tok4, NULL);
                      break;
                  }
              }
          }
      }
      