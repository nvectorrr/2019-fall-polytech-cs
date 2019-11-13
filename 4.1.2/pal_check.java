import java.lang.Character;

class pal_check
{
    public static boolean isPalindrome( String s ) 
    {   
        int n = s.length();
        //int flag = 0;
        int x = 0;
        int y = 0;

        if( n == 0 )
            return false;

        for( int i = 0; i < (n/2); ++i )
        {
            if( Character.isDigit( i + y ) || Character.isLetter( i + y ))
            {
                if( Character.isDigit( n - i - 1 - x ) || Character.isLetter( n - i - 1 - x ))
                {
                    x = 0;
                    y = 0;
                    
                    if( s.charAt( i + y ) != s.charAt( n - i - 1 - x ))
                        return false;
                }
                else
                    ++x;
            }
            else
                ++y;
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