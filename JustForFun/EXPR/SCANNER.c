/* Naydenovich Viktor */
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <ctype.h>
#include <setjmp.h>
#include "EXPR.h"

void Scanner( QUEUE *Q, char *s )
{
  TOK T;
  int denum, i;

  while (*s != 0)
  {
    switch (*s)
    {
    case ' ':
    case '\n':
      s++;
      continue;
    case '+':
    case '-':
    case '(':
    case ')':
    case '*':
    case '/':
    case '%':
    case '^':
    case '=':
    case ',':
      T.Id = TOK_OP;
      T.Op = *s++;
      break;
    case '0':
    case '1':
    case '2':
    case '3':
    case '4':
    case '5':
    case '6':
    case '7':
    case '8':
    case '9':
      T.Id = TOK_NUM;
      T.Num = 0;
      while (*s >= '0' && *s <= '9')
        T.Num = T.Num * 10 + *s++ - '0';
      if (*s == '.')
      {
        s++;
        denum = 1;
        while (*s >= '0' && *s <= '9')
          T.Num += (double)(*s++ - '0') / (denum *= 10);
      }
      break;
    default:
      if (isalpha((unsigned char) * s))
      {
        T.Id = TOK_NAME;
        i = 0;
        do
        {
          if (i < MAX - 1)
            T.Name[i++] = *s;
          s++;
        }while (isalpha((unsigned char) * s) || isdigit((unsigned char) * s));
        T.Name[i] = 0;
        break;
      }
      Error("Unrecognized character '%c'\n", *s);
      break;
    }
    Put(Q, T);
  }
}
