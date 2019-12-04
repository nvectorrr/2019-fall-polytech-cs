//
//  COMPL.c
//  mandw
//
//  Created by Viktor on 03.12.2019.
//  Copyright © 2019 Viktor. All rights reserved.
//

#include <math.h>
#include "COMPL.h"


COMPL ComplSet( double A, double B )
{
  COMPL C;

  C.Re = A;
  C.Im = B;

  return C;
}

COMPL CompAddCompl( COMPL A, COMPL B )
{
  COMPL C;

  C.Re = A.Re + B.Re;
  C.Im = A.Im + B.Im;

  return C;
}

COMPL ComplMulCompl( COMPL A, COMPL B )
{
  COMPL C;

  C.Re = (A.Re * B.Re) - (A.Im * B.Im);
  C.Im = (A.Re * B.Im) + (A.Re * B.Im);

  return C;
}

double ComplNorm( COMPL Z )
{
  return sqrt((Z.Re * Z.Re) + (Z.Im * Z.Im));
}

int Mahdelbrot( COMPL Z )
{
  int n = 0;
  COMPL Z0 = Z;

  while((n < 255) && ComplNorm(Z) < 2)
  {
    Z = CompAddCompl(ComplMulCompl( Z, Z ), Z0);
    n++;
  }
  return n;
}
