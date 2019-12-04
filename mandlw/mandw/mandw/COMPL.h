//
//  COMPL.h
//  mandw
//
//  Created by Viktor on 03.12.2019.
//  Copyright © 2019 Viktor. All rights reserved.

typedef struct
{
  double Re, Im;
} COMPL;
COMPL ComplSet( double A, double B );
COMPL CompAddCompl( COMPL A, COMPL B );
COMPL ComplMulCompl( COMPL A, COMPL B );
double ComplNorm( COMPL Z );
int Mahdelbrot( COMPL Z );
void Put( int X, int Y, int R, int G, int B );
void Display( void );
void Keyboard( unsigned char Key, int X, int Y );
