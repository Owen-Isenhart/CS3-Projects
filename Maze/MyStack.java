import java.util.*;
public class MyStack{
    private Integer[] stack;
    private int size;
    public MyStack(){
        stack = new Integer[2];
        size = 0;
    }
    public MyStack(int initCap){
        stack = new Integer[initCap];
        size = 0;
    }
    public boolean isEmpty(){
        if (size == 0){
            return true;
            
        }
        return false;
    }
    public Integer peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack[size-1];
    }
    public Integer pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        Integer temp = stack[size-1];
        stack[size-1] = null;
        size--;
        return temp;
    }
    public void push(Integer item){
        if (size == stack.length){
            doubleCapacity();
        }
        stack[size] = item;
        size++;
    }
    private void doubleCapacity(){
        Integer list2[] = new Integer[stack.length*2];
        for (int i = 0; i < stack.length; i ++){
            list2[i] = stack[i];
        }
        stack = list2;
    }
    public String toString(){
        String s = "[";
        for (int i = 0; i < size; i ++){
            if (i == size-1){
                s += stack[i];
            }
            else{
                s += stack[i] + ", ";
            }
            
        }
        return s += "]";
    }
}