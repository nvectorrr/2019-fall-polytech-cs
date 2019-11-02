class test_unit
{
    public static void tests ()
    {
        String s[] = new String[10];
        s[1] = "a";
        s[2] = "asddsa";
        s[3] = "skdjf";
        s[4] = "a sdsa";
        s[5] = "asd sa";
        
        boolean results[] = new boolean[10];
        results[1] = true;
        results[2] = true;
        results[3] = false;
        results[4] = true;
        results[5] = true;  
        
        int count_of_tests = 5; 
        
        tester(s, results, count_of_tests);
    }
    
    public static void tester( String[] s, boolean[] results, int count_of_tests )
    {
        for( int i = 1; i <= count_of_tests; i++ )
        {
            if( pal_check.isPalindrome( s[i] ) == results[i] )
            {
                System.out.println( "OK - Test №" + i );
            }
            else
            {
                System.out.println( "FAIL - Test №" + i );
            }
        }
    }
}