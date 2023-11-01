public class MyLinkedList{
    ListNode head;
    ListNode tail;
    int size;
    private class ListNode{
        int val;
        ListNode next;
        
        
        public ListNode(int val){
            this.val = val;
        }
        @Override
        public String toString(){
            return "" + this.val;
        }
    }
    public static void main(String[] args){
        MyLinkedList temp = new MyLinkedList();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        temp.add(4);
        System.out.println (temp.toString());
        System.out.println (temp.contains(4));
        System.out.println (temp.get(1));
        System.out.println (temp.indexOf(2));
        temp.set(10, 2);
        System.out.println (temp.toString());
        System.out.println(temp.size());
        System.out.println(temp.sizeRecursive(temp.head));
        System.out.println (temp.isEmpty());
        MyLinkedList temp2 = new MyLinkedList();
        System.out.println (temp2.isEmpty());
        System.out.println (temp2.toString());
        System.out.println(temp.remove(1));
        System.out.println(temp.toString());
        temp.add(20, 0);
        System.out.println (temp.toString());
    }
    public MyLinkedList(){
        size = 0;
        head = null;
        tail = head;
    }
    public MyLinkedList(int val){
        size = 1;
        head = new ListNode(val);
        tail = head;
        head.next = null;
    }
    
    public void add(int newVal){
        // if (head == null){
            // head = new ListNode(newVal);
        // }
        // else{
            // ListNode temp = this.head;
            // while (temp != null){
                // if (temp.next == null){
                    // temp.next = new ListNode(newVal);
                    // break;
                // }
                // temp = temp.next;
            // }
            
        // }
        
        if (head == null){
            head = new ListNode(newVal);
            tail = head;
            size++;
            return;
        }
        tail.next = new ListNode(newVal);
        tail = tail.next;
        size++;
        
    }
    
    public boolean contains(int target){
        if (head == null)
            return false;
            
        ListNode temp = this.head;
        while (temp != null){
            if (temp.val == target)
                return true;
            temp = temp.next;
        }
        return false;
    }
    
    public int get(int index){
        int count = 0;
        ListNode temp = this.head;
        while (count != index){
            if (temp.next == null)
                throw new IndexOutOfBoundsException();
            temp = temp.next;
            count++;
        }
        return temp.val;
    }
    
    public int indexOf(int target){
        int count = 0;
        ListNode temp = this.head;
        while (temp.val != target){
            if (temp.next == null){
                return -1;
            }
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    //riddle: rain or something
    
    public void set(int newVal, int index){
        int count = 0;
        ListNode temp = this.head;
        while (count != index){
            if (temp.next == null)
                throw new IndexOutOfBoundsException();
            temp = temp.next;
            count++;
        }
        temp.val = newVal;
    }
    
    public int size(){
        ListNode temp = this.head;
        int count = 0;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    public int sizeRecursive(ListNode c){
        if (c == null){
            return 0;
        }
        return 1+sizeRecursive(c.next);
    }
    
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }
    
    public int remove(int index){
        int count = 0;
        ListNode temp = this.head;
        ListNode prev = null;
        
        if (count == index){
            head = head.next;
            return temp.val;
        }
            
        while (count != index){
            if (temp.next == null)
                throw new IndexOutOfBoundsException();
            prev = temp;
            temp = temp.next;
            count++;
        }
        prev.next = temp.next;
        size--;
        return temp.val;
    }
    
    public void add(int newVal, int index){
        if (index == size){
            add(newVal);
        }
        int count = 0;
        ListNode temp = this.head;
        ListNode temp2 = null;
        ListNode next = null;
        if (count == index){
            this.head = new ListNode(newVal);
            head.next = temp;
            return;
        }
        while (count != index-1){
            if (temp.next == null)
                throw new IndexOutOfBoundsException();
            
            temp = temp.next;
            next = temp.next;
            count++;
        }
        temp2 = temp;
        next = temp.next;
        temp = temp2.next;        
        ListNode penis = temp2;
        temp2.next = new ListNode(newVal);
        temp2.next.next = next;
        size++;
        
    }
    
    @Override
    public String toString(){
        if (size() == 0){
            return "[]";
        }
        String s = "[";
        ListNode temp = this.head;
        while (temp.next != null){
            s += temp.val + ", ";
            temp = temp.next;
        }
        s += temp.val + "]";
        return s;
    }
}