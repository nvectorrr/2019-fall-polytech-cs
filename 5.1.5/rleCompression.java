class rleCompression
{
    // Linked list node 
    static class Node { 
        char data; 
        Node next; 
    }; 
  
    // Utility function to create a new Node 
    static Node newNode(char data) 
    { 
        Node temp = new Node(); 
        temp.data = data; 
        temp.next = null; 
  
        return temp; 
    } 

  
    // Function to append nodes to a list 
    static void append(Node head_ref, char new_data) 
    { 
        Node new_node = new Node(); 
  
        Node last = head_ref; 
  
        new_node.data = new_data; 
  
        new_node.next = null; 
  
        if (head_ref == null) { 
            head_ref = new_node; 
            return; 
        } 
  
        while (last.next != null) 
            last = last.next; 
  
        last.next = new_node; 
        return; 
    } 
  
    // Function to print list 
    static void printList(Node node) 
    { 
        while (node != null) { 
            System.out.print(node.data + " "); 
  
            node = node.next; 
        } 
    } 
  
    // Function to decode the linked list 
    static String decodeList(Node head) 
    { 
        // Pointer used to traverse through all 
        // the nodes in the list 
        Node p = head; 
  
        // String to store the decoded message 
        String res = ""; 
  
        int count; 
  
        // While there are nodes left 
        while (p != null) { 
  
            // To store the count by which the current 
            // character needs to be repeated 
            count = 0; 
  
            // Get the current character 
            char c = p.data; 
            if (p.next != null) { 
                Node temp = p.next; 
  
                // If current node is a digit 
                if (temp != null && temp.data >= '0'
                    && temp.data <= '9') { 
  
                    // Generate the integer from 
                    // the consecutive digits 
                    while (temp != null && temp.data >= '0'
                           && temp.data <= '9') { 
                        count = count * 10 + (temp.data - '0'); 
                        temp = temp.next; 
                    } 
                    p = temp; 
                } 
                else { 
                    count = 1; 
                    p = p.next; 
                } 
            } 
            else { 
                count = 1; 
                p = p.next; 
            } 
  
            // Repeat the character count times 
            for (int i = 0; i < count; i++) { 
                res += c; 
            } 
        } 
  
        return res; 
    } 

    static void RLE(Node head) 
    { 
        // Pointer used to traverse through 
        // all the nodes in the list 
        Node p = head; 
    
        // List to store the encoded message 
        Node temp = newNode(p.data); 
    
        // Store the first character in c 
        char c = p.data; 
        p = p.next; 
    
        // Count to count the number of 
        // continuous elements 
        int count = 1; 
    
        // Taverse through all the 
        // elements in the list 
        while (p != null) 
        { 
    
            // Store the current character in x 
            char x = p.data; 
    
            // If the characters are same 
            if (c == x) 
                // Increment count 
                count++; 
            else 
            { 
    
                // If the count is greater than 1 
                if (count > 1)  
                { 
    
                    // Append the count to list 
                    if (count > 9) 
                        append(temp, (char) ('0' + (count / 10))); 
    
                    append(temp, (char) ('0' + (count % 10))); 
                } 
    
                // Reset the count 
                count = 1; 
    
                // Add the next character 
                // to the list 
                append(temp, x); 
    
                // Take the character to check as 
                // the current character 
                c = x; 
            } 
            p = p.next; 
        } 
    
        // Add the final count 
        if (count != 0) 
            append(temp, (char) ('0' + count)); 
    
        // Print the list 
        printList(temp); 
    } 
   
    public static void main(String args[]) 
    { 
        // Creating the linked list 
        Node head = newNode('a'); 
        head.next = newNode('a'); 
        head.next.next = newNode('a'); 
        head.next.next.next = newNode('b'); 
        head.next.next.next.next = newNode('r'); 
        head.next.next.next.next.next = newNode('r'); 
    
        RLE(head);
  
        System.out.println(decodeList(head)); 
    } 
}