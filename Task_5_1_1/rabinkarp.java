class rabinkarp
{
    public final static int d = 256;
    
    public static int rabinkarp_s( String pat, String txt, int q ) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
        int i, j; 
        int p = 0; // hash value for pattern 
        int t = 0; // hash value for txt 
        int h = 1;
        int res = 0;

        long startTime = System.nanoTime();
      
        // The value of h  
        for( i = 0; i < M-1; i++ ) 
            h = (h*d)%q; 
      
        // Calculate the hash value of pattern  
        for( i = 0; i < M; i++ ) 
        { 
            p = (d*p + pat.charAt(i))%q; 
            t = (d*t + txt.charAt(i))%q; 
        } 
      
        // Slide the pattern over text one by one 
        for( i = 0; i <= N - M; i++ ) 
        { 
            if( p == t ) 
            { 
                /* Check for characters one by one */
                for( j = 0; j < M; j++ ) 
                { 
                    if( txt.charAt(i+j) != pat.charAt(j) ) 
                        break; 
                } 
      
                if( j == M )
                { 
                    res = res + i;
                    //System.out.println("Pattern found at index " + i);
                    //System.out.println(res);
                } 
            } 
      
            if( i < N-M ) 
            { 
                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+M))%q; 
      
                // We might get negative value of t, converting it 
                // to positive 
                if( t < 0 ) 
                t = (t + q); 
            } 
        }  
        
        long stopTime = System.nanoTime();
        long runtime = stopTime - startTime;
        System.out.println("Rabinkarp time: " + runtime);
        
        return res;
    }
}