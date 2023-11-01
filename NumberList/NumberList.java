
/**
 * Write a description of class NumberList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NumberList
{
    // instance variables - replace the example below with your own
    private Integer[] list;
    private int size;

    /**
     * Constructor for objects of class NumberList
     */
    public NumberList()
    {
        list = new Integer[2];
        size = 0;
    }
    public int getLength(){
        return list.length;
    }
    public int size() {
        return size;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isEmpty()
    {
        if (size() == 0)
            return true;
        return false;
    }
    public String toString(){
        String s = "[";
        for (int i = 0; i < size()-1; i ++){
            s += list[i] + ", ";
        }
        if (size != 0)
            s+= list[size-1];
        return s += "]";
    }
    private void doubleCapacity(){
        Integer list2[] = new Integer[getLength()*2];
        for (int i = 0; i < list.length; i ++){
            list2[i] = list[i];
        }
        list = list2;
    }
    public void add (int x, Integer obj){
        int temp = 0;
        if (x < 0 || x > size()){
            throw new IndexOutOfBoundsException();
        }
        if (size() == list.length){
            doubleCapacity();
        }
        if (list[x] != null)
            temp = list[x];
        if (x == 0 && size != 0){
            size++;
            for (int i = size()-1; i > 0; i --){
                list[i] = list[i-1];
            }
            list[0] = obj;
            return;
        }
        
        size++;
        
        for (int i = size()-1; i >= x+1; i --){
                list[i] = list[i-1];
            }
        list[x] = obj;
    }
    public boolean add(Integer obj){
        add(this.size, obj);
        return true;
    }
    public int get (int index){
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        else
            return list[index];
        
    }
    public int set(int index, Integer obj){
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        list[index] = obj;
        int temp = list[index];
        list[index] = obj;
        return temp;
    }
    public int remove(int index){
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();
        int temp = 0;
        if (list[index] != null)
            temp = list[index];
        int pp = index+1;
        if (index != size()){
            for (int i = index; i < size()-1; i ++){
                
                list[i] = list[pp];
                pp++;
            }
        }
        list[size()-1] = null;
        size--;
        return temp;
    }
}


