#include <stdio.h>
#include <string.h>

#include  "huff.h"

#define MAX_BITS 46

typedef struct tagTREE TREE;
struct tagTREE
{
  int Ch;
  long Freq;
  TREE *Left, *Right;
};

typedef struct
{
  char Bits[MAX_BITS];
  int Len;
} CODE;

long Freq[256];
TREE *Nodes[256];
int NumOfNodes;
CODE NewCodes[256], CurCode;

void GetStr( char *Str, int MaxLen )
{
  int i = 0;
  char ch;

  while ((ch = getchar()) != '\n')
    if (Str != NULL && i < MaxLen - 1)
      Str[i++] = ch;

  if (Str != NULL && i < MaxLen)
    Str[i] = 0;
}

static void ClearTree( TREE **T )
{
  if (*T != NULL)
  {
    ClearTree(&(*T)->Left);
    ClearTree(&(*T)->Right);
    free(*T);
    *T = NULL;
  }
}

static void CountFreq( FILE *F )
{
  int i;

  memset(Freq, 0, sizeof(long) * 256);
  while ((i = fgetc(F)) != EOF)
    Freq[i]++;
}

static void PlaceNode( int Ch, long Freq, TREE *Left, TREE *Right )
{
  int i;
  TREE *T = (TREE *)malloc(sizeof(TREE));

  if (T == NULL)
    return;
  T->Ch = Ch;
  T->Freq = Freq;
  T->Left = Left;
  T->Right = Right;

  i = NumOfNodes - 1;
  while (i >= 0 && T->Freq > Nodes[i]->Freq)
    Nodes[i + 1] = Nodes[i], i--;
  Nodes[i + 1] = T;
  NumOfNodes++;
}

static void BuildTree( void )
{
  int i;

  for (i = 0; i < 256; i++)
    if (Freq[i] != 0)
      PlaceNode(i, Freq[i], NULL, NULL);

  while (NumOfNodes > 1)
  {
    TREE
      *Last = Nodes[--NumOfNodes],
      *PreLast = Nodes[--NumOfNodes];
    PlaceNode(' ', Last->Freq + PreLast->Freq, PreLast, Last);
  }
}

static void BuildCodes( TREE *T )
{
  if (T == NULL)
    return;
  if (T->Left == NULL)
  {
    memcpy(&NewCodes[T->Ch], &CurCode, sizeof(CODE));
    return;
  }
  CurCode.Bits[CurCode.Len++] = 0;
  BuildCodes(T->Left);
  CurCode.Bits[CurCode.Len - 1] = 1;
  BuildCodes(T->Right);
  CurCode.Len--;
}

static void StatInfo( char FN[500] )
{
  int i, decompr_len = 0;
  FILE *F;

  if ((F = fopen(FN, "rb")) == NULL)
    return;
  CountFreq(F);
  fclose(F);
  BuildTree();
  memset(NewCodes, 0, sizeof(NewCodes));
  CurCode.Len = 0;
  BuildCodes(Nodes[0]);
  for (i = 0; i < 256; i++)
    if (Freq[i] > 0)
    {
      int j;

      printf("%c(%3d) -> %10li(code len %3d)  ", i < 32 ? '.' : i, i, Freq[i], NewCodes[i].Len);
      for (j = 0; j < NewCodes[i].Len; j++)
        printf("%d", NewCodes[i].Bits[j]);
      printf("\n");
    }
  for (i = 0; i < 256; i++)
    decompr_len += NewCodes[i].Len * Freq[i];
  decompr_len = decompr_len / 8 + 1;
  printf("Normal length - %d bytes, compress length - %d bytes, coef - %f\n",
    Nodes[0]->Freq, decompr_len, (double)Nodes[0]->Freq / decompr_len);
}

int Compress( char FN1[500], char FN2[500] )
{
  int i;
  FILE *F1, *F2;
  unsigned char Accum = 0, NumOfBits;

  if ((F1 = fopen(FN1, "rb")) == NULL) {
      printf("Poshel naxuy1\n");
      return 0;
  }
  if ((F2 = fopen(FN2, "wb")) == NULL)
  {
      printf("Poshel naxuy2\n");
    fclose(F1);
    return 0;
  }
  NumOfNodes = 0;
  NumOfBits = 0;
  StatInfo(FN1);

  fwrite(Freq, 4, 256, F2);
  while ((i = fgetc(F1)) != EOF)
  {
    int j;

    for (j = 0; j < NewCodes[i].Len; j++)
    {
      Accum |= NewCodes[i].Bits[j] << (7 - NumOfBits);
      NumOfBits++;
      if (NumOfBits == 8)
      {
        fputc(Accum, F2); 
        NumOfBits = 0;
        Accum = 0;
      }
    }
  }
  fputc(Accum, F2);

  fclose(F1);
  fclose(F2);
  ClearTree(&Nodes[0]);
  return 1;
}

int Decompress( char FN1[500], char FN2[500] )
{
  int i, len = 0, noos = 0;
  FILE *F1, *F2;
  TREE *T;

  if ((F1 = fopen(FN1, "rb")) == NULL)
    return 0;
  if ((F2 = fopen(FN2, "wb")) == NULL)
  {
    fclose(F1);
    return 0;
  }

  NumOfNodes = 0;
  fread(Freq, 4, 256, F1);
  BuildTree();
  T = Nodes[0];

  while (noos < Nodes[0]->Freq)
  {
    int j;

    i = fgetc(F1);
    for (j = 7; j >= 0; j--)
    {
      unsigned char bit = (i >> j) & 1;

      if (bit)
        T = T->Right;
      else
        T = T->Left;

      if (T->Left == NULL)
      {
        if (len < Nodes[0]->Freq)
          fputc(T->Ch, F2), noos++;
        T = Nodes[0];
        len++;
      }
    }
  }

  fclose(F1);
  fclose(F2);
  ClearTree(&Nodes[0]);
  return 1;
}