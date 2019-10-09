import java.util.Scanner;

public class Task_2_1_5
{
    public static void main (String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Input value: ");
        int x  = console.nextInt();

        int ans = calculator(x); 
        
        System.out.printf("Answer: %d", ans);
        console.close();
    }

    public static int calculator (int x)
    {
        if(x == 0 || x == 1)
        {
            return x;
        }
        int start = 1, end = x / 2;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid == x / mid)
            {
               return mid;
            }
            if(mid < x / mid)
            {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start - 1;
    }
}