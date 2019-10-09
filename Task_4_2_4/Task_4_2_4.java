import java.util.LinkedList;

class Task_4_2_4
{
    public static void main (String[] args)
    {
        LinkedList<Integer> num_1 = new LinkedList<Integer>();
        LinkedList<Integer> num_2 = new LinkedList<Integer>();
        LinkedList<Integer> sum = new LinkedList<Integer>();

        String num1 = "84567";
        String num2 = "47548";

        num_1 = getIntList(num1);
        System.out.println(num_1.toString());

        num_2 = getIntList(num2);
        System.out.println(num_2.toString());

        sum = calc.summ(num_1, num_2);
        System.out.println(sum.toString());

    }

    public static LinkedList<Integer> getIntList (String src)
    {
        int len = src.length();
        LinkedList<Integer> lst = new LinkedList<Integer>();
        for (int i = 0; i < len; i++)
        {
            char ch = src.charAt(i);
            Integer in = new Integer(String.valueOf(ch));
            lst.add(in);
        }
        return lst;
    }
}