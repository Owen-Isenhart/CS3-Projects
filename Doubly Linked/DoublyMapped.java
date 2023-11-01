public class DoublyMapped {
    private Stop start;
    private Stop end;
    private int size;
    
    public class Stop
    {
        String value;
        Stop next;
        Stop prev;
        
        //Constructor
        public Stop(String v)
        {
            value = v;
            next = null;
            prev = null;
        }
        public Stop(String v, Stop next)
        {
            value = v;
            this.next = next;
            prev = null;
        }
    }
    
    public DoublyMapped(String start)
    {
        this.start = new Stop(start);
        this.end = this.start;
        size = 1;
    }
    
    // Inserts at index, previous Stop at index gets moved after new stop
    public void insertAt(String value, int index)
    {
        Stop newStop = new Stop(value);
        if(index == 0)
        {
            start.prev = newStop;
            newStop.next = start;
            this.start = newStop;
            size++;
        }
        else if(index == size)
        {
            end.next = newStop;
            newStop.prev = end;
            this.end = newStop;
            size++;
        }
        else
        {
            Stop temp = this.start;
            int count = 0;
            while(count != index - 1)
            {
                temp = temp.next;
                count++;
            }
            newStop.next = temp.next;
            newStop.prev = temp;
            temp.next = newStop;
            newStop.next.prev = newStop;
            size++;
        }
    }
    
    public void printList()
    {
        System.out.print("Your destinations are: ");
        Stop current = this.start;
        while(current != null)
        {
            System.out.print(current.value + " ");
            if(current != this.start && current != this.end)
            {
                System.out.print("to ");
            }
            current = current.next;
        }
    }
    
    /**
     * TO-DO
     * Print list from the destination (end) to start
     */
    public void printBackwards()
    {
        System.out.print("Doubly Linked, Backwards: ");
        System.out.print("Your destinations are: ");
        Stop current = this.end;
        while(current != null)
        {
            System.out.print(current.value + " ");
            if(current != this.start)
            {
                System.out.print("to ");
            }
            current = current.prev;
        }
    }
    
    public static void main(String[] args)
    {
        DoublyMapped myMap = new DoublyMapped("Frisco High School");
        myMap.insertAt("Froyo", 1);
        myMap.insertAt("Jamba Juice", 2);
        myMap.insertAt("Whataburger", 3);
        myMap.insertAt("24 hour fitness", 2);
        myMap.insertAt("my house", 0);
        myMap.printList();
        System.out.println();
        myMap.printBackwards();
    }
    
    
}