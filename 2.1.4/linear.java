class linear
{
    public static int search(int arr[], int x) 
    { 
        int n = arr.length;
        long startTime = System.nanoTime();
        
        for(int i = 0; i < n; i++) 
        { 
            if(arr[i] == x)
            {
                long stopTime = System.nanoTime();
                long runtime = stopTime - startTime;
                System.out.println("Linear time: " + runtime);
                return i;
            }  
        } 

        long stopTime = System.nanoTime();
        long runtime = stopTime - startTime;
        System.out.println("Linear time: " + runtime);

        return -1; 
    } 
}