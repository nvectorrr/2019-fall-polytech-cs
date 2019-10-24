import java.util.LinkedList;

class calc_opti
{
    public static LinkedList<Integer> calculator (LinkedList<Integer> num_1, LinkedList<Integer> num_2)
    {
        LinkedList<Integer> lst = new LinkedList<Integer>();
        LinkedList<Integer> lst_h = new LinkedList<Integer>();
        int flag = 0, x;

        if (num_1.getFirst() + num_2.getFirst() >= 10)
        {
            flag = 1;
        }

        if (num_1.size() == num_2.size())
        {
            lst = summator(num_1, num_2);
            if (flag == 1)
            lst.push(1);
        }

        if (num_1.size() > num_2.size())
        {
            lst = summator(num_1, num_2);
            lst_h = extra_summator(num_1, num_2, flag);
            for (int i = lst_h.size(); i > 0; i--)
            {
                x = lst_h.getLast();
                lst.push(x);
            }
        }

        else
        {
            lst = summator(num_2, num_1);
            lst_h = extra_summator(num_2, num_1, flag);
            for (int i = lst_h.size(); i > 0; i--)
            {
                x = lst_h.getLast();
                lst.push(x);
            }
        }

        return lst;
    }

    public static LinkedList<Integer> summator (LinkedList<Integer> num_1, LinkedList<Integer> num_2)
    {
        LinkedList<Integer> lst1 = new LinkedList<Integer>();
        
        int i = num_2.size();
        while (i > 0)
        {
            globals.x = num_1.removeLast();
            globals.y = num_2.removeLast();
            globals.s = globals.x + globals.y + globals.s1;
            
            if (globals.s >= 10)
            {
                globals.s = globals.s - 10;
                globals.s1 = 1;
            } 
            else
            {
                globals.s1 = 0;
            }
            
            lst1.push(globals.s);
            i--;
        }
            
        return lst1;
    }

    public static LinkedList<Integer> extra_summator (LinkedList<Integer> num_1, LinkedList<Integer> num_2, int flag)
    {
        LinkedList<Integer> lst2 = new LinkedList<Integer>();
        int i = num_1.size();

        if (flag == 1)
        {
            globals.s2 = 1;
        }
        
        while (i > 0)
        {
            i--;
            globals.x = num_1.removeLast();
            if (globals.s2 == 0)
            {
                if (globals.x == 9 && globals.s1 == 1)
                {
                    lst2.push(0);
                    globals.s2 = 1;
                } else
                {
                    lst2.push(globals.x);
                    globals.s1 = 0;
                    globals.s2 = 0;
                }
            } else
            {
                lst2.push(globals.x + 1);
                globals.s2 = 0;
            }
                    
        }

        return lst2;
    }
}
