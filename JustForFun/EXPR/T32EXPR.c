/* Naydenovich Viktor */
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <setjmp.h>
#include "EXPR.h"

void GetStr( char *Str, int n )
{
  char c;
  int i = 0;

  if (Str == NULL)
    return;
  while ((c = getchar()) != '\n' && i < n - 1)
  {
    Str[i] = c;
    i++;
  }
  Str[i] = 0;
}

int main( void )               
{
  QUEUE Q = {NULL}, QRes = {NULL};
  char *Str, *c;
  Str = malloc(sizeof(char) * MAX);
  c = malloc(sizeof(char) * MAX);
  if (setjmp(ExprJumpBuf))
  {
    free(Str);
    free(c);
    ClearStack(&S);
    ClearQueue(&QRes);
    ClearQueue(&Q);
    ClearStack(&Stack1);
    ClearStack(&Stack2);
    ClearVarTable();
    return 0;
  }
  SetDbgMemHooks();
  printf("POLIS or Infix?\n");
  GetStr(c, MAX);
  printf("Input a str:\n");
  GetStr(Str, MAX); 
  Scanner(&Q, Str);
  if (*c == 'i')
  {
    Parser(&QRes, &Q);
  }
  else
    QRes = Q;
  /*printf("There is a queue:\n");
  DisplayQueue(&QRes);*/
  printf("Result: %f\n", Eval(&QRes));
  DisplayVarTable();
  ClearVarTable();
  ClearStack(&S);
  ClearStack(&Stack1);
  ClearStack(&Stack2);
  ClearQueue(&QRes);
  free(Str);
  free(c);
  getchar();
  return 0;
}