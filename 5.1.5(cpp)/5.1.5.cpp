#include "5.1.5.h"

int main( int argc, char* argv[] )
{
	if( argc == 1 )
	{
		char FN1[500], FN2[500];

		while( 1 )
		{
			std::cout << "1 - compress\t 2 - decompress \t 0 - exit" << std::endl;
			switch ( _getch() )
			{
				case '0':
					return 0;
				case '1':
					GetStr( NULL, 0 );
					std::cout << "-Compress mode-\n Source: " << std::endl;
					GetStr( FN1, 500 );
					std::cout << "Destination: " << std::endl;
					GetStr( FN2, 500 );

					if( Compress( FN1, FN2 ) == 1 )
					{
						std::cout << "Compress - OK\n" << std::endl;
					}
					else
					{
						std::cout << "F A I L\n" << std::endl;
					}
					break;
			}
		}
	}
}

