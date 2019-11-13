import java.lang.Character;

class pal_check
{
    public static boolean isPalindrome( String s ) 
    {   
        int n = s.length();
        //int flag = 0;
        int x = 0;
        int y = 0;
        int flagFirst = 0;
        int flagLast = 0;

        if( n == 0 )
            return false;

        for( int i = 0; i < (n/2); ++i )
        {
            if( (Character.isDigit( s.charAt( i + y ) )  || Character.isLetter( s.charAt( i + y ) )) && (Character.isDigit( s.charAt( n - i - 1 - x ) ) || Character.isLetter( s.charAt( n - i - 1 - x ))))
            {
                x = 0;
                y = 0;
                flagFirst = 0;
                flagLast = 0;

                if( s.charAt( i + y ) != s.charAt( n - i - 1 - x ))
                {
                    return false;
                }
            }
            
            else
            {
                for( int j = i; j < (n/2); ++j )
                {
                    if( flagFirst > 0 && flagLast > 0 )
                    {
                        if( flagFirst > 0 )
                        {
                            if( !(Character.isDigit( s.charAt( j + y ) ) || Character.isLetter( s.charAt( j + y ) )) )
                                ++y;
                            else
                                ++flagFirst;
                        }
                        if( flagLast > 0 )
                        {
                            if( !(Character.isDigit( s.charAt( n - j - 1 - x ) ) || Character.isLetter( s.charAt( n - j - 1 - x ) )) )
                                ++x;
                            else 
                                ++flagLast;
                        }
                    }
                    else
                    {
                        --x;
                        --y;
                        break;
                    }    
                }
                    

            }
                
        }

        
        return true;
    }
}




/* for( int i = 0; i < (n/2); ++i ) 
        {
            if ( (Character.isLetter( s.charAt(i)  ) || Character.isDigit( s.charAt(i))) && (Character.isLetter( s.charAt( n - i - 1 - x )) || Character.isDigit( s.charAt( n - i - 1 - x))))
            {
                if( s.charAt(i) != s.charAt( n - i - 1 - x) ) 
                {
                    return false;
                }
                //flag = 0;
                x = 0;
            }
            else 
            {
                //flag = 1;
                ++x;
            }
        }*/