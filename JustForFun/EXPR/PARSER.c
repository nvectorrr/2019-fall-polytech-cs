/* Naydenovich Viktor */
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <setjmp.h>
#include "EXPR.h"

STACK Stack1, Stack2;

int GetPrior( char Op )
{
  switch (Op)
  {
  case '(':
    return 0;
  case ')':
    return 1;
  case ',':
    return 2;
  case '=':
    return 3;
  case '+':
  case '-':
    return 4;
  case '*':
  case '/':
  case '%':
    return 5;
  case '@':
    return 6;
  case '^':
    return 7;
  }
  Error("Uknowm operator: '%c'", Op);
  return -1;
}

void DropOpers( char Op )
{
  while (Stack2.Top != NULL && GetPrior(Stack2.Top->T.Op) >= GetPrior(Op))
  {
    TOK T;

    Pop(&Stack2, &T);
    Push(&Stack1, T);
  }
}

void Parser( QUEUE *QRes, QUEUE *Q )
{
  TOK T;
  enum
  {
    STATE_PREFIX, STATE_SUFFIX, STATE_DONE, STATE_END
  }state = STATE_PREFIX;
  while (state != STATE_END)
  {
    if (state <= STATE_SUFFIX)
      if (!Get(Q, &T))
        if (state == STATE_SUFFIX)
          state = STATE_DONE;
        else
          Error("Enexpected end-of-expression\n");
    switch (state)
    {
    case STATE_PREFIX:
      if (T.Id == TOK_NUM || T.Id == TOK_NAME)
      {
        Push(&Stack1, T);
        state = STATE_SUFFIX;
      }
      else if (T.Id == TOK_OP && T.Op == '(')
        Push(&Stack2, T);
      else if (T.Id == TOK_OP && T.Op == '-')
      {
        T.Op = '@';
        Push(&Stack2, T);
      }
      else
        Error("Wait for number or '('\n");
      break;
    case STATE_SUFFIX:
      if (T.Id == TOK_OP && !(T.Op == '('))
      {
        DropOpers(T.Op);
        if (T.Op != ')')
          Push(&Stack2, T);
        else
        {
          Pop(&Stack2, &T);
          if (T.Op != '(')
            Error("Missing '('\n");
          break;
        }
        state = STATE_PREFIX;
      }
      else
        Error("Wait for operation\n");
      break;
    case STATE_DONE:
      DropOpers(')');
      if (Stack2.Top != NULL)
        Error("Missing ')'\n");
      while (Pop(&Stack1, &T))
        Push(&Stack2, T);
      while (Pop(&Stack2, &T))
        Put(QRes, T);
      state = STATE_END;
      break;
    }
  }
}