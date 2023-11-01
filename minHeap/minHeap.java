
/**
 * Write a description of class minHeap here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class minHeap
{
    Integer[] heap;
    int size;
    static final int DEFAULT_CAPACITY = 8;
    public minHeap(){
        heap = new Integer[DEFAULT_CAPACITY];
        heap[0] = 0;
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }
    public int peekMinimum(){
        return heap[1];
    }
    public int getLeftChildIndex(int index){
        return index*2;
    }
    public int getRightChildIndex(int index){
        return 2*index+1;
    }
    public int getParentIndex(int index){
        return index/2;
    }
    private void doubleCapacity(){
        Integer[] temp = new Integer[heap.length*2];
        for (int i = 0; i <= size; i ++){
            temp[i] = heap[i];
        }
        heap = temp;
    }
    public void insert(int value){
        if (size + 2 > heap.length){
            doubleCapacity();
        }
        heap[size+1] = value;
        size++;
        bubbleUp(size);
    }
    private void bubbleUp(int index){
        if (index == 1 || heap[index] >= heap[getParentIndex(index)]){
            return;
        }
        
        else{
            int temp = heap[getParentIndex(index)];
            heap[getParentIndex(index)] = heap[index];
            heap[index] = temp;
            bubbleUp(getParentIndex(index));
        }
    }
    public int popMinimum(){
        int temp = heap[1];
        heap[1] = heap[size];
        heap[size] = null;
        shiftDown(1);
        return temp;
    }
    private void shiftDown(int index){
        if (heap[getLeftChildIndex(index)] == null || (heap[index] < heap[getLeftChildIndex(index)] && heap[getRightChildIndex(index)] == null) || (heap[index] < heap[getRightChildIndex(index)] && heap[getLeftChildIndex(index)] == null) || (heap[index] < heap[getRightChildIndex(index)] && heap[index] < heap[getLeftChildIndex(index)])){
            return;
        }
        else{
            if (heap[getLeftChildIndex(index)] < heap[getRightChildIndex(index)]){ 
                //swap current with left
                int temp = heap[index];
                heap[index] = heap[getLeftChildIndex(index)];
                heap[getLeftChildIndex(index)] = temp;
                shiftDown(getLeftChildIndex(index));
            }
            else{ 
                int temp = heap[index];
                heap[index] = heap[getRightChildIndex(index)];
                heap[getRightChildIndex(index)] = temp;
                shiftDown(getRightChildIndex(index));
            }
            
        }
    }
    @Override
    public String toString(){
        String output = "";
        for (int i = 1; i <= getSize(); i ++){
            output += heap[i] + ", ";
        }
        return output.substring(0, output.lastIndexOf(","));
    }
    public void display(){
        int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
        String dots = "...............................";
        System.out.println(dots + dots);
        while (j <= this.getSize()){
            if (column == 0)
                for (int k = 0; k < nBlanks; k++){
                    System.out.print(' ');
                }
            System.out.print((heap[j] == null)? "" : heap[j]);
            if (++column == itemsPerRow){
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            }
            else{
                for (int k = 0; k < nBlanks * 2 - 2; k ++){
                    System.out.print(' ');
                }
                
                }
                j++;
            }
            System.out.println ("\n" + dots + dots);
    }
    public void buildHeap(Integer[] nums){
        for (int i = 0; i < nums.length; i ++){
            int temp = nums[i];
            insert(temp);
        }
        
        for (int i = size/2; i > 0; i --){
            shiftDown(0);
        }
    }
        
}

