public class calc
{
    public static int div_on_2 (int x)
    {
        int n = 0;
        if (x <= 2) {
            return 1;
        }
        
        while (x >= 2) {
            x = x - 2;
            n++;
        }
        return n;
    }

    public static int div (int x, int y)
    {
        int n = 0;
        if (x == y) {
            return 1;
        }
        if ((x == 0) || (y == 0)) {
            return 0;
        }

        while (x >= y)
        {
            x = x - y;
            n++;
        }
        return n;
    }

    public static int tree (int x)
    {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 1, end = div_on_2(x);
        while (start <= end)
        {
            int end_m_start = end - start, mid_m = div_on_2(end_m_start); 
            int mid = start + mid_m;
            int val = div(x, mid);
            if (mid == val) {
                return mid;
            }
            if (mid < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } 
        
        return start - 1;
    }
}