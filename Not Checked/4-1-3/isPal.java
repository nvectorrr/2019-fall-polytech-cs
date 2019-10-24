class isPal
{
    public static void splitter( String s ) 
    { 
      String[] words = s.split("\\s"); 
      
      for(String subStr:words) 
      {
         System.out.println(subStr);  
      }
   }
}