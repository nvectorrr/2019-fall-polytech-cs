/* Naydenovich Viktor */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>
#include <setjmp.h>
#include "EXPR.h"

struct tagVARLIST
{
  char Name[MAX];
  double Value;
  VARLIST *Next;
}*VarTable = NULL;

void SetValue( char *Name, double Value )
{
  VARLIST **ptr = &VarTable;

  while (*ptr != NULL)
    if (strcmp((*ptr)->Name, Name) == 0)
    {
      (*ptr)->Value = Value;
      return;
    }
    else
      ptr = &((*ptr)->Next);
  if ((*ptr = malloc(sizeof(VARLIST))) == NULL)
    Error("Not enough room for new variable");
  strncpy((*ptr)->Name, Name, MAX - 1);
  (*ptr)->Value = Value;
  (*ptr)->Next = NULL;
}

double GetValue( char *Name )
{
  VARLIST **ptr = &VarTable;

  while (*ptr != NULL)
    if (strcmp((*ptr)->Name, Name) == 0)
      return (*ptr)->Value;
    else
      ptr = &((*ptr)->Next);
  Error("Unknown name of variable\n");
  return 0;
}

void DisplayVarTable( void )
{
  VARLIST **ptr = &VarTable;

  while (*ptr != NULL)
  {
    printf("Var: %s, value: %lf\n", (*ptr)->Name, (*ptr)->Value);
    ptr = &((*ptr)->Next);
  }
}

void ClearVarTable( void )
{
  /*VARLIST **ptr1 = &VarTable;
  VARLIST **ptr2 = &VarTable;

  while ((*ptr1)->Next != NULL)
  {
    ptr2 = &((*ptr1)->Next);
    free((*ptr1)->Name);
    (*ptr1)->Value = 0;
    ptr1 = &(*ptr2);
  }           */
}

