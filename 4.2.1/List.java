class List {
    private ListElement head;       // указатель на первый элемент
    private ListElement tail;       // указатель последний элемент
 
    void addFront(int data)           //добавить спереди
    {
        ListElement a = new ListElement();  
        a.data = data;              
                                    
        if(head == null)          
        {                         
            head = a;             
            tail = a;
        }
        else {
            a.next = head;          
            head = a;               
        }
    }
 
    void addBack(int data) {          //добавление в конец списка
        ListElement a = new ListElement();  
        a.data = data;
        if (tail == null)           
        {                           
            head = a;               
            tail = a;
        } else {
            tail.next = a;         
            tail = a;              
        }
    }
 
    void printList()                //печать списка
    {
        ListElement t = head;          
        while (t != null)           
        {
            System.out.print(t.data + " "); 
            t = t.next;                    
        }
    }
 
    void delEl(int data)          //удаление элемента
    {
        if(head == null)        
            return;            
 
        if (head == tail) {    
            head = null;        
            tail = null;
            return;           
        }
 
        if (head.data == data) {  
            head = head.next;      
            return;                 
        }
 
        ListElement t = head;       
        while (t.next != null) {   
            if (t.next.data == data) { 
                if(tail == t.next)      
                {
                    tail = t;          
                }
                t.next = t.next.next;   
                return;                
            }
            t = t.next;                
        }
    }
}