public class Main {
    public static void main(String[] args) {
        List ml = new List();
        ml.addBack(1);
        ml.addBack(2);
        ml.addBack(3);
        ml.addFront(6);
 
        ml.printList();
        System.out.println();
 
        ml.delEl(6);
        ml.delEl(5);
        ml.delEl(12);
        ml.delEl(2);
 
        ml.printList();
        System.out.println();
    }
}