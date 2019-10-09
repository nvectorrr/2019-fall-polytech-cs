import java.util.Scanner;

public class Task_2_1_6
{
    public static void main (String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Input value: ");
        int x  = console.nextInt();

        int ans = calc.tree(x); 
        
        System.out.printf("Answer: %d", ans);
        console.close();
    }
}

