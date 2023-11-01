public class RingBuffer
{
    private String[] data;          // items in the buffer
    private int      first;         // index for the next dequeue or peek
    private int      last;          // index for the next enqueue
    private int      size;          // number of items in the buffer

    /** create an empty buffer, with given max capacity */
    public RingBuffer(int capacity)
    {
        
        data = new String[capacity];
    }

    /** return number of items currently in the buffer */
    public int size() {
        // COMPLETE THIS METHOD
        int arySize = 0;
        for (int i = 0; i < data.length; i ++){
            if (data[i] != null){
                arySize++;
            }
        }
        return arySize;
    }

    /** is the buffer empty (size equals zero)? */
    public boolean isEmpty() {
        // COMPLETE THIS METHOD
        if (size() == 0){
            return true;
        }
        return false; //REPLACE
    }

    /** is the buffer full (size equals array capacity)? */
    public boolean isFull() {
        // COMPLETE THIS METHOD
        if (size() == data.length-1){
            return true;
        }
        return false; //REPLACE
    }

    /** add item x to the end */
    public void enqueue(String x) {
        // COMPLETE THIS METHOD
        
        data[last] = x;
        size++;
        if (last == data.length-1){
            last = 0;
        }
        else{
            last++;
        }
    }

    /** delete and return item from the front */
    public String dequeue() {
        String result = data[first];
        data[first] = null;
        
        size--;
        if (first == data.length-1){
            first = 0;
        }
        else{
            first++;
        }
        return result;
    }

    /** return (but do not delete) item from the front */
    public String peek() {
        // COMPLETE THIS METHOD
        return data[first];
    }
}