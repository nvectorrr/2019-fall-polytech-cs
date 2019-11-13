import java.util.Scanner;

public class longestsub 
{
    static Scanner sn = new Scanner( System.in );
    static String word = sn.nextLine();

    public static void main( String[] args ) 
    {
        System.out.println( "The Length is " + check( word ) );
    }

    private static int check( String word ) 
    {
        String store = "";
        for( int i = 0; i < word.length(); ++i ) 
        {
            if( store.indexOf( word.charAt( i ) ) < 0 ) 
            {
                store = store + word.charAt( i );
            }
        }
        System.out.println( "Result word " + store );
        return store.length();
    }

}