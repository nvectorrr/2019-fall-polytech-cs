/* Naydenovich Viktor */
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <math.h>
#include <setjmp.h>
#include "EXPR.h"

STACK S = {NULL};

double Eval( QUEUE *Q )
{
  TOK T, T1, T2;

  while (Get(Q, &T))
  {
    if (T.Id == TOK_NUM || T.Id == TOK_NAME)
      Push(&S, T);
    else
    {
      if (T.Op != '@')
      {
        Pop(&S, &T2);
        if (T2.Id == TOK_NAME && T.Op != '=')
          T2.Num = GetValue(T2.Name);
      }
      Pop(&S, &T1);
      if (T1.Id == TOK_NAME && T.Op != '=')
        T1.Num = GetValue(T1.Name);
      switch (T.Op)
      {
      case '@':
        T1.Num = -T1.Num;
        break;
      case '+':
        T1.Num += T2.Num;
        break;
      case '-':
        T1.Num -= T2.Num;
        break;
      case '*':
        T1.Num *= T2.Num;
        break;
      case '/':
        T1.Num /= T2.Num;
        break;
      case '^':
        T1.Num = pow(T1.Num, T2.Num);
        break;
      case '%':
        T1.Num = fmod(T1.Num, T2.Num);
        break;
      case '=':
        SetValue(T1.Name, T2.Num);
        T1.Id = TOK_NUM;
        T1.Num = T2.Num;
        break;
      case ',':
        T1.Id = TOK_NUM;
        T1.Num = T2.Num;
        break;
      }
      Push(&S, T1); 
    }
  }
  Pop(&S, &T);
  return T.Num;
}