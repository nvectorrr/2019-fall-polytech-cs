/* Naydenovich Viktor */
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <setjmp.h>
#include <stdarg.h>
#include "EXPR.h"

jmp_buf ExprJumpBuf;

void Error( char *Str, ... )
{
  va_list ap;

  printf("ERROR: ");
  va_start(ap, Str);
  vprintf(Str, ap);
  va_end(ap);
  printf("\n");
  longjmp(ExprJumpBuf, 1);
}

void PrintTok( TOK T )
{
  if (T.Id == TOK_OP)
    printf("c: %c\n", T.Op);
  else if (T.Id == TOK_NUM)
    printf("x: %f\n", T.Num);
  else
    Error("Uknown token\n");
}

void ClearList( LIST *L )
{
  LIST *tmp1, *tmp2;
  tmp1 = L;
  while (tmp1 != NULL)
  { 
    tmp2 = tmp1;
    tmp1 = tmp1->Next;
    free(tmp2);
  }
}

void DisplayList( LIST *L )
{
  if (L == NULL)
    Error("Empty list\n");
  while (L != NULL)
  {
    PrintTok(L->T);
    L = L->Next;
  }
  printf("\n");
}

void DisplayQueue( QUEUE *Q )
{
  DisplayList(Q->Head);
}

void DisplayStack( STACK *S )
{
  DisplayList(S->Top);
}

void Put( QUEUE *Q, TOK t )
{
  LIST *NewEl;

  NewEl = malloc(sizeof(LIST));
  if (NewEl == NULL)
    Error("No memory");
  NewEl->T = t;
  NewEl->Next = NULL;

  if (Q->Head == NULL)
    Q->Head = Q->Tail = NewEl;
  else
  {
    Q->Tail->Next = NewEl; 
    Q->Tail = NewEl;
  } 
}

int Get( QUEUE *Q, TOK *t )
{
  LIST *tmp;

  if (Q->Head == NULL)
    return 0;
  tmp = Q->Head;
  *t = Q->Head->T;
  Q->Head = tmp->Next;
  free(tmp);
  return 1; 
}

void Push( STACK *S, TOK t )
{
  LIST *NewEl;
  
  NewEl = malloc(sizeof(LIST));
  if (NewEl == NULL)
    Error("No memory");
  NewEl->T = t;
  NewEl->Next = NULL;

  if (S->Top == NULL)
    S->Top = NewEl;
  else
    NewEl->Next = S->Top, S->Top = NewEl;
}

int Pop( STACK *S, TOK *t )
{
  LIST *tmp;

  if (S->Top == NULL)
    return 0;
  tmp = S->Top;
  *t = S->Top->T;
  S->Top = tmp->Next;
  free(tmp);
  return 1;
}

void ClearQueue( QUEUE *Q )
{
  ClearList(Q->Head);
  Q = NULL;
}

void ClearStack( STACK *S )
{
  ClearList(S->Top);
  S = NULL;
}