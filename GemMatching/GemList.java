import java.util.ArrayList;

public class GemList 
{
    int size;
    Node head;
    private class Node
    {
        private Gem gem;
        private Node next;
        public Node(Gem g){
            gem = g;
        }
    }
    public GemList(){
        head = null;
        size = 0;
    }
    
    public int size(){
        Node temp = this.head;
        int count = 0;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public void draw(double y){
        double x = 0;
        int count = 0;
        Node temp = this.head;
        if (temp == null){
            return;
        }
        while (temp != null){
            x = GemGame.indexToX(count);
            temp.gem.draw(x, y);
            count++;
            temp = temp.next;
        }
    }
    public String toString(){
        String s = "";
        Node temp;
        if (this.head != null){
            temp = this.head;
        }
        else{
            return s;
        }
            
        while (temp.next != null){
            s += temp.gem.toString() + "\n";
            temp = temp.next;
            
        }
        return s;
    }
    public void add(Gem gem){
        if (head == null){
            head = new Node(gem);
        }
        else{
            Node temp = this.head;
            while (temp != null){
                if (temp.next == null){
                    temp.next = new Node(gem);
                    break;
                }
                temp = temp.next;
            }
            
        }
    }
    public void insertBefore(Gem gem, int index){
        if (index > size()){
            index = size();
            add(gem);
            return;
        }
        if (index == 0){
            this.head = new Node(gem);
            return;
        }
        int count = 0;
        Node temp = this.head;
        Node temp2 = null;
        Node next = null;
        if (count == index){
            this.head = new Node(gem);
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
        Node penis = temp2;
        temp2.next = new Node(gem);
        temp2.next.next = next;
        size++;

    }
    public int score(){
        int rowCount = 0;
        int rowNum = 0;
        int total = 0;
        Node temp = this.head;
        while (temp != null){
            if (temp.next == null){
                total += temp.gem.getPoints();
                break;
            }else{
                GemType type = temp.gem.getType();
            do{
                rowCount++;
                rowNum += temp.gem.getPoints();
                temp = temp.next;
            } while (type == temp.gem.getType() && temp.next != null);
            total += rowCount*rowNum;
            }
            rowCount = 0;
            rowNum = 0;
        }

        return total;
    }
    public static void main(String [] args)
    {
       GemList list = new GemList();
       System.out.println(list);
       System.out.println("size = " + list.size() + ", score = " + list.score());
       list.draw(0.9);        
       
       list.insertBefore(new Gem(GemType.BLUE, 10), 0);
       System.out.println("\n" + list);
       System.out.println("size = " + list.size() + ", score = " + list.score());
       list.draw(0.8);
       
       list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
       System.out.println("\n" + list);
       System.out.println("size = " + list.size() + ", score = " + list.score());
       list.draw(0.7);
       
       list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
       System.out.println("\n" + list);
       System.out.println("size = " + list.size() + ", score = " + list.score());
       list.draw(0.6);
       
       list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
       System.out.println("\n" + list);
       System.out.println("size = " + list.size() + ", score = " + list.score());
       list.draw(0.5);
       
       list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
       System.out.println("\n" + list);
       System.out.println("size = " + list.size() + ", score = " + list.score());
       list.draw(0.4);
       
       list.insertBefore(new Gem(GemType.GREEN, 50), 2);
       System.out.println("\n" + list);
       System.out.println("size = " + list.size() + ", score = " + list.score());
       list.draw(0.3);        
    }    
}
