class pal_check
{
    public static boolean isPalindrome( String s ) 
    {
        s = s.replaceAll("[^\\p{Alnum}]", "");
        
        int n = s.length();

        if( n == 0 )
        {
            return false;
        }

        for( int i = 0; i < (n/2); ++i ) 
        {
            if( s.charAt(i) != s.charAt( n - i - 1 ) ) 
            {
                return false;
            }
        }

        return true;
    }
}