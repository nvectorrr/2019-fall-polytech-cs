/* Naydenovich Viktor */
#ifdef _DEBUG
#  define _CRTDBG_MAP_ALLOC
#  include <crtdbg.h>
#  define SetDbgMemHooks() \
     _CrtSetDbgFlag(_CRTDBG_LEAK_CHECK_DF | _CRTDBG_CHECK_ALWAYS_DF | \
       _CRTDBG_ALLOC_MEM_DF | _CrtSetDbgFlag(_CRTDBG_REPORT_FLAG))
#else /* _DEBUG */
#  define SetDbgMemHooks() ((VOID)0)
#endif /* _DEBUG */

#define MAX 300

typedef enum
{
  TOK_OP,
  TOK_NUM,
  TOK_NAME
}TOKID;

typedef struct 
{
  TOKID Id;
  char Op;
  double Num;
  char Name[MAX];
}TOK;

typedef struct tagList LIST;
struct tagList{
  TOK T;
  LIST *Next;
};

typedef struct{
  LIST *Top;
}STACK;

typedef struct{
  LIST *Head, *Tail;
}QUEUE;

typedef struct tagVARLIST VARLIST;

extern jmp_buf ExprJumpBuf;
extern STACK Stack1, Stack2, S;

void DisplayList( LIST *L );
void Put( QUEUE *Q, TOK t );
int Get( QUEUE *Q, TOK *t );
void Push( STACK *S, TOK t );
int Pop( STACK *S, TOK *t );
void DisplayQueue( QUEUE *Q );
void DisplayStack( STACK *S );
void ClearQueue( QUEUE *Q );
void ClearStack( STACK *S );
void Scanner( QUEUE *Q, char *s );
void PrintTok( TOK T );
double Eval( QUEUE *Q );
void Error( char *Str, ... );
void Parser( QUEUE *QRes, QUEUE *Q );
void SetValue( char *Name, double Value );
double GetValue( char *Name );
void DisplayVarTable( void );
void ClearVarTable( void );
