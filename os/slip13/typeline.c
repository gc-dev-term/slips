#include <stdio.h>
      #include <stdlib.h>
      #include <string.h>
      #include <unistd.h>

      void typeline(char *tok2, char *tok3)
      {
          FILE *fp;
          int lc = 0;
          int count = 0;
          char str[256];
          fp = fopen(tok3, "r");
          if (fp == NULL)
          {
              printf("File does not exist!");
          }
          else
          {
              if (strcmp(tok2, "-a") == 0)
              {
                  while (!feof(fp))
                  {
                      char ch = fgetc(fp);
                      printf("%c", ch);
                  }
              }
              else
              {
                  int n = atoi(tok2);
                  if (n > 0)
                  {
                      while (lc < n)
                      {
                          char ch = fgetc(fp);
                          if (ch == '\n')
                              lc++;
                          printf("%c", ch);
                      }
                  }
                  if (n < 0)
                  {
                      while (!feof(fp))
                      {
                          char ch = fgetc(fp);
                          if (ch == '\n')
                              lc++;
                      }
                      int skip = lc + n;
                      fseek(fp, 0, SEEK_SET);
                      while (fgets(str, sizeof(str), fp) != NULL)
                      {
                          count++;
                          if (count >= skip)
                              printf("%s", str);
                      }
                  }
              }
          }
      }

      void main(int args, char *argv[])
      {
          char tok1[20], tok2[20], tok3[20], fname[20];
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