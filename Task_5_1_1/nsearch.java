class nsearch
{
    public static int native_s( String txt, String pat ) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
        int res = 0;

        long startTime = System.nanoTime();
  
        for( int i = 0; i <= N - M; i++ ) 
        { 
  
            int j; 

            for( j = 0; j < M; j++ ) 
                if( txt.charAt(i + j) != pat.charAt(j) ) 
                    break; 
  
            if( j == M ) 
            {    
                //System.out.println("Pattern found at index " + i);
                res = res + i; 
            } 
        } 

        long stopTime = System.nanoTime();
        long runtime = stopTime - startTime;
        System.out.println("Native time: " + runtime);

        return res;
    } 
}