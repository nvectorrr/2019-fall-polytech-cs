public class Manacher {
    private int[]  p;  
    private String s;  
    private char[] t;  

    public Manacher(String s) 
    {
        this.s = s;
        preprocess();
        p = new int[t.length];

        int center = 0, right = 0;
        for (int i = 1; i < t.length-1; i++) 
        {
            int mirror = 2*center - i;

            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);

            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;
            if (i + p[i] > right) 
            {
                center = i;
                right = i + p[i];
            }
        }

    }

    private void preprocess() 
    {
        t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) 
        {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
    }
 
    public String longestPalindromicSubstring() 
    {
        int length = 0;   
        int center = 0;   
        for (int i = 1; i < p.length-1; i++) 
        {
            if (p[i] > length) 
            {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    public static void main(String[] args) 
    {
        String s = "sdkf;ksmjvkkvk12345678987654321klfdjgopi";
        Manacher manacher = new Manacher(s);
        System.out.println(manacher.longestPalindromicSubstring());
    }
}