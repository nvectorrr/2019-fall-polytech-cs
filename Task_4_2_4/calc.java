import java.util.LinkedList;

class calc
{
    public static LinkedList<Integer> summ (LinkedList<Integer> num_1, LinkedList<Integer> num_2)
    {
        LinkedList<Integer> lst = new LinkedList<Integer>();
        Integer x, y, s, s1 = 0;
        int flag = 0;

        if (num_1.getFirst() + num_2.getFirst() >= 10)
        {
            flag = 1;
        } 

        if (num_1.size() == num_2.size())
        {
            int i = num_1.size();
            while (i > 0)
            {
                x = num_1.removeLast();
                y = num_2.removeLast();
                s = x + y + s1;
                if (s >= 10)
                {
                    s = s - 10;
                    s1 = 1;
                } else
                {
                    s1 = 0;
                }
                lst.push(s);
                i--;
            }
            if (flag == 1)
            {
                lst.push(1);
            }     
        }
        
        

        return lst;
    }
}