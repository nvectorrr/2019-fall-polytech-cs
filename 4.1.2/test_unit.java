class test_unit
{
    public static void tests ()
    {
        String s[] = new String[12];
        s[1] = "a";
        s[2] = "asddsa";
        s[3] = "aaaasaa";
        s[4] = "asd dsa";
        s[5] = "asd sa";
        s[6] = "a s dd sa";
        s[7] = "a1.d gg/g<d1a";
        s[8] = "so i o s";
        s[9] = "asdf gh gf dsa";
        s[10] = "asd dd s a";
        
        boolean results[] = new boolean[12];
        results[1] = true;
        results[2] = true;
        results[3] = false;
        results[4] = true;
        results[5] = true;
        results[6] = true;
        results[7] = true;  
        results[8] = true;
        results[9] = true;
        results[10] = true;

        int count_of_tests = 10; 
        
        tester(s, results, count_of_tests);
    }
    
    public static void tester( String[] s, boolean[] results, int count_of_tests )
    {
        for( int i = 1; i <= count_of_tests; i++ )
        {
            if( pal_check.isPalindrome(s[i]) == results[i] )
            {
                System.out.println("OK - Test №" + i);
            }
            else
            {
                System.out.println("FAIL - Test №" + i);
            }
        }
    }
}