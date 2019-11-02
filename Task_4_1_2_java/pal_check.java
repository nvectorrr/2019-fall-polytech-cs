class pal_check
{
    public static boolean isPalindrome( String s ) 
    {
        int n = s.length();

        // Checking for not NULL string

        if( n == 0 )
        {
            return false;
        }

        // Converting to StringBuffer and replasing not letter and not digit symbols

        StringBuffer str = new StringBuffer( s );

        for( int i = 0; i < n - 1; ++i )
        {
            if (!(Character.isDigit( str.charAt( i ) ) || Character.isLetter( str.charAt( i ) )))
            {
                str.deleteCharAt( i );
            }
        }

        // Converting back and checking for pol
        
        String new_s = str.toString();
        int new_n = new_s.length();

        for( int i = 0; i < ( new_n/2 ); ++i ) 
        {
            if( new_s.charAt( i ) != new_s.charAt( new_n - i - 1 ) ) 
            {
                return false;
            }
        }

        return true;
    }
}