#include "5.1.5.h"

void GetStr(char* Str, int MaxLen)
{
	int i = 0;
	char ch;

	while ((ch = getchar()) != '\n')
		if (Str != NULL && i < MaxLen - 1)
			Str[i++] = ch;

	if (Str != NULL && i < MaxLen)
		Str[i] = 0;
}

void FileScanner( FILE* F )
{
	int i = fgetc( F );

	while( (i = fgetc( F )) != '\n' )
	{
		
	}
}



int Compress( char FN1[500], char FN2[500] )
{
	FILE *F1, *F2;

	if( ( F1 = fopen( FN1, "rb" ) ) == NULL ) 
	{
		std::cout << "E R R O R: cant open F1" << std::endl;
		return 0;
	}
	if( ( F2 = fopen( FN2, "wb" ) ) == NULL )
	{
		std::cout << "E R R O R: cant open F2" << std::endl;
		fclose( F1 );
		return 0;
	}

	/*
	int x = 9;
	fwrite(&x, sizeof(int), 1, F2);
	return 1;
	FileScanner();
	*/
	int prevEl, i = fgetc( F1 ), j = 0;
	prevEl = i;

	while( 1 )
	{
		if( i != ' ')
		{
			if( i == EOF )
			{
				fprintf( F2, "%d", j);
				fwrite( &prevEl, sizeof(char), 1, F2 );
				break;
			}
		
			if( i == prevEl )
				j++;
			else
			{
				fprintf( F2, "%d", j);
				fwrite( &prevEl, sizeof(char), 1, F2 );
				j = 1;
				prevEl = i;
			}
		}
		
		
		i = fgetc( F1 );
	}

	fclose( F1 );
	fclose( F2 );
	return 1;
}