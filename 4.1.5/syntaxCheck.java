class syntaxCheck
{
    public static Boolean isOkay( String str )
    {
        int symbMass[] = new int[6];
        for( int i = 0; i <= 5; ++i )
        {
            symbMass[i] = 0;
        }

        int n = str.length();
        int pos;

        for( int i = 0; i < n; ++i )
        {
           char symb = str.charAt( i );
           if( symb == '(' || symb == ')' || symb == '{' || symb == '}' || symb == '[' || symb == ']' )
           {
               pos = whoAreYou( str.charAt( i ) );
               symbMass[pos] = symbMass[pos] + 1;
           }
        }

        if( symbMass[0] != symbMass[1] )
            return false;
        if( symbMass[2] != symbMass[3] )
            return false;
        if( symbMass[4] != symbMass[5] )
            return false;
        
        return true;
    }

    public static int whoAreYou( char x )
    {
        int pos = 0;
        
        if( x == '(' )
        {
            pos = 0;
            return pos;
        }
        if( x == ')' )
        {
            pos = 1;
            return pos;
        }
        if( x == '{' )
        {
            pos = 2;
            return pos;
        }
        if( x == '}' )
        {
            pos = 3;
            return pos;
        }
        if( x == '[' )
        {
            pos = 4;
            return pos;
        }
        if( x == ']' )
        {
            pos = 5;
            return pos;
        } 

        return pos = 6; 
    }
}