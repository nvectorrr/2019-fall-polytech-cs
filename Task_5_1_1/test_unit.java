class test_unit
{
    public static void tests ()
    {
        String input_data_txt[] = new String[10];
        input_data_txt[1] = "iodjmfvsdpokd";
        input_data_txt[2] = "dowghbasdfdopggklopfkg";
        input_data_txt[3] = "fgnidlsidghtsdnfsidndght";
        input_data_txt[4] = "sdjfiopjsfiosjp";

        String input_data_pat[] = new String[10];
        input_data_pat[1] = "od";
        input_data_pat[2] = "sdfdopg";
        input_data_pat[3] = "dght";
        input_data_pat[4] = "pop";

        int results[] = new int[10];
        results[1] = 1;
        results[2] = 7;
        results[3] = 28;
        results[4] = 0;

        int count_of_tests = 4;

        tester( input_data_txt, input_data_pat, results, count_of_tests );
    }

    public static void tester ( String[] input_data_txt, String[] input_data_pat, int[] results, int count_of_tests )
    {
        for( int i = 1; i <= count_of_tests; i++ )
        {
            String pat = input_data_pat[i];
            String txt = input_data_txt[i];
            int res = results[i];
            int q = 101;
            if( rabinkarp.rabinkarp_s(pat, txt, q) == res)
            {
                System.out.println("OK - R-K Test №" + i);
            }
            else
            {
                System.out.println("FAIL - R-K Test №" + i);
            }
            
            if( nsearch.native_s(txt, pat) == res)
            {
                System.out.println("OK - Nat Test №" + i);
            }
            else
            {
                System.out.println("FAIL - Nat Test №" + i);
            }
            System.out.println("---------------------------------------------");
        }
    }
}