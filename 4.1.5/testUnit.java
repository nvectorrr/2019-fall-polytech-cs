class testUnit
{
    public static void tests()
    {
        String s[] = new String[10];

        s[1] = "(";
        s[2] = "(jfhsld)[dk](dkmckd{kdlmc}d,lc)";
        s[3] = "";
        s[4] = "((((()))){]}[)";
        s[5] = "()()(";

        Boolean res[] = new Boolean[10];

        res[1] = false;
        res[2] = true;
        res[3] = true;
        res[4] = true;
        res[5] = false;

        int countOfTests = 5;

        tester( s, res, countOfTests );
    }

    public static void tester( String[] s, Boolean[] res, int countOfTests )
    {
        for( int i = 1; i <= countOfTests; i++ )
        {
            if( syntaxCheck.isOkay( s[i] ) == res[i] )
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