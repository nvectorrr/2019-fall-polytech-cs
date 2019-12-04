//
//  main.c
//  mandw
//
//  Created by Viktor on 03.12.2019.
//  Copyright © 2019 Viktor. All rights reserved.
//

#include <GLUT/glut.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include "COMPL.h"

#define Width 500
#define Height 500
unsigned char image[Height][Width][3];

double Scale = 1;

int WinWidth = 400, WinHeight = 400;

int main( int argc, char* argv[])
{
  glutInit( &argc, argv );
  glutInitDisplayMode( GLUT_RGB|GLUT_DOUBLE );
  
  glutInitWindowPosition( 0, 0 );
  glutInitWindowSize( 800, 600 );
  glutCreateWindow( "Phys-Math Lyceum #30 forever !!!" );
  
  glutDisplayFunc( Display );
  glutKeyboardFunc( Keyboard );
  
  glutMainLoop();

  return 0;
}


void Display( void )
{
  
  COMPL Z;
  double x0 = -2, x1 = 2, y0 = -2, y1 = 2;
  int xs, ys;
  unsigned char n = 0;
  
  glClearColor( 0.3, 0.5, 0.7, 1);
  glClear( GL_COLOR_BUFFER_BIT );

  glPixelZoom( 1, -1 );
  for(ys = 0; ys < Height; ys++)
    for(xs = 0; xs < Width; xs++)
    {
      Z = ComplSet((xs * ((x1 - x0) / Width) + x0), (ys *((y1 - y0) / Height) + y0));
      n = Mahdelbrot(Z);
      Put(xs, ys, n * 20, n * 6, n / 80);
    }
  
  glDrawPixels( Width, Height, GL_BGR_EXT, GL_UNSIGNED_BYTE, image );
  glRasterPos2d( -1, 1 );

  glFinish();
  glutSwapBuffers();
  glutPostRedisplay();
}


void Keyboard( unsigned char Key, int X, int Y )
{
  printf( "Key = %d\n", Key );
  if ( Key == 27 )
    exit(0);
}


void Put( int X, int Y, int R, int G, int B )
{
  if (X < 0 || Y < 0 || X >= Width || Y >= Height)
    return;
  image[Y][X][0] = B;
  image[Y][X][1] = G;
  image[Y][X][2] = R;
}
