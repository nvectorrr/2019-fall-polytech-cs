#include <stdio.h>
#include <conio.h>

#include "huff.h"

int main( int argc, char *argv[] )
{
  //SetDbgMemHooks();
  
  if (argc == 1)
  {
    char FN1[500], FN2[500];

    while (1)
    {
      printf("\n======================================================================="
        "\n1 - compress, 2 - decompress, 0 - exit\n");
      switch (_getch())
      {
      case '0':
        return 0;
      case '1':
          GetStr(NULL, 0);
        printf("Compress:\nSource: ");
        GetStr(FN1, 500);
        printf("Destination: ");
        GetStr(FN2, 500);
        if (Compress(FN1, FN2) == 1)
          printf("Success compress %s -> %s\n", FN1, FN2);
        else
          printf("--FAIL--\n");
        break;
      case'2':
        printf("\nDecompress:\n\tSource: ");
        GetStr(FN1, 500);
        printf("\tDestination: ");
        GetStr(FN2, 500);
        if (Decompress(FN1, FN2) == 1)
          printf("Success decompress %s -> %s\n", FN1, FN2);
        else
          printf("--FAIL--\n");
        break;
      default:
        printf("Unrecognised switch\n");
      }
    }
  }
  else
    if (argv[1][0] == 'c')
      return !Compress(argv[2], argv[3]);
    else if (argv[1][0] == 'd')
      return !Decompress(argv[2], argv[3]);
    else
    {
      printf("Unrecognised switch\n");
      return -1;
    }
}
                              