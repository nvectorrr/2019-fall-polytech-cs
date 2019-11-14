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

        System.out.println("linear - interp - binary");
        
        long startTime = System.nanoTime();

        linear.search(arr, 40);
        stopTimer(startTime);

        long startTime2 = System.nanoTime();
        interpol.interpolationSearch(arr, 40);
        stopTimer(startTime2);

        long startTime3 = System.nanoTime();
        binary.search(arr, 40);
        stopTimer(startTime3);
        
        System.out.println("-------------------------------------------------------");

        long startTime4 = System.nanoTime();

        linear.search(arr2, 7);
        stopTimer(startTime4);

        long startTime5 = System.nanoTime();
        interpol.interpolationSearch(arr2, 7);
        stopTimer(startTime5);

        long startTime6 = System.nanoTime();
        binary.search(arr2, 7);
        stopTimer(startTime6);
        
        System.out.println("-------------------------------------------------------");

        long startTime7 = System.nanoTime();

        linear.search(arr3, 7);
        stopTimer(startTime7);

        long startTime8 = System.nanoTime();
        interpol.interpolationSearch(arr3, 7);
        stopTimer(startTime8);

        long startTime9 = System.nanoTime();
        binary.search(arr3, 7);
        stopTimer(startTime9);
        
        System.out.println("-------------------------------------------------------");
    }

    public static void stopTimer( long startTime )
    {
        long stopTime = System.nanoTime();
        long runtime = stopTime - startTime;
        System.out.println("Time: " + runtime);
    }
}