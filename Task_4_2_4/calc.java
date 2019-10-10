import java.util.LinkedList;

class calc
{
    public static LinkedList<Integer> summ (LinkedList<Integer> num_1, LinkedList<Integer> num_2)
    {
        LinkedList<Integer> lst = new LinkedList<Integer>();
        Integer x, y, s, s1 = 0, s2 = 0;
        int flag = 0;

        if (num_1.getFirst() + num_2.getFirst() >= 10)
        {
            flag = 1;
        } 

        if (num_1.size() == num_2.size())
        {
            int i = num_1.size();
            s1 = 0;
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
        else
        {
            if (num_1.size() > num_2.size())
            {
                int i = num_2.size();
                while (i > 0)
                {
                    x = num_1.removeLast();
                    y = num_2.removeLast();
                    s = x + y + s1;
                    if (s >= 10)
                    {
                        s = s - 10;
                        s1 = 1;
                    }
                    else
                    {
                        s1 = 0;
                    }
                    lst.push(s);
                    i--;
                }
                
                i = num_1.size();
                while (i > 0)
                {
                    i--;
                    x = num_1.removeLast();
                    if (s2 == 0)
                    {
                        if (x == 9 && s1 == 1)
                        {
                            lst.push(0);
                            s2 = 1;
                        } else
                        {
                            lst.push(x);
                            s1 = 0;
                            s2 = 0;
                        }
                    } else
                    {
                        lst.push(x + 1);
                        s2 = 0;
                    }
                    
                }
            } else 
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
                    }
                    else
                    {
                        s1 = 0;
                    }
                    lst.push(s);
                    i--;
                }
                
                i = num_2.size();
                while (i > 0)
                {
                    i--;
                    x = num_2.removeLast();
                    if (s2 == 0)
                    {
                        if (x == 9 && s1 == 1)
                        {
                            lst.push(0);
                            s2 = 1;
                        } else
                        {
                            lst.push(x);
                            s1 = 0;
                            s2 = 0;
                        }
                    } else
                    {
                        lst.push(x + 1);
                        s2 = 0;
                    }
                    
                }
            }
                        
        }
        

        return lst;
    }
}