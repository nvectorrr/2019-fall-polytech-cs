class testUnit
{
    public static void tests ()
    {
        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round((Math.random() * 30) - 15);
        }

        
        int arr2[] = new int[1000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) Math.round((Math.random() * 30) - 15);
        }

        int arr3[] = new int[10000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = (int) Math.round((Math.random() * 30) - 15);
        }

        linear.search(arr, 40);
        interpol.interpolationSearch(40, arr);
        System.out.println("-------------------------------------------------------");

        linear.search(arr2, 7);
        interpol.interpolationSearch(7, arr2);
        System.out.println("-------------------------------------------------------");
        
        linear.search(arr3, 7);
        interpol.interpolationSearch(7, arr3);
        System.out.println("-------------------------------------------------------");
    }

    
}