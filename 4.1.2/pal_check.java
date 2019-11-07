import java.lang.Character;

class pal_check
{
    public static boolean isPalindrome( String s ) 
    {   
        int n = s.length();

        if( n == 0 )
        {
            return false;
        }

        for( int i = 0; i < (n/2); ++i ) 
        {
            if ( (Character.isLetter( s.charAt( i)  ) || Character.isDigit( s.charAt( i ))) && (Character.isLetter( s.charAt( n - i -1 )) || Character.isDigit( s.charAt( n - i - 1))))
            {
                if( s.charAt(i) != s.charAt( n - i - 1 ) ) 
                {
                    return false;
                }
            }
        }

        return true;
    }
}