import java.util.*;
public class Runner{
    //1
    public static Stack<Integer> makeStack(int[] nums){
        Stack<Integer> stack = new Stack<>();
        for (int num : nums)
            stack.push(num);
        return stack;
    }

    public static void main(String[] args){
        StackProbs test = new StackProbs();
        Stack<Integer> s = new Stack<>();
        //2
        s = makeStack(new int[] {-1, -3, 5, 0, 1, -5, 3});
        System.out.println (test.doubleUp(s));
        //3
        s = makeStack(new int[] {-1, -3, 5, 0, 1, -5, 3});
        System.out.println (test.posAndNeg(s));
        //4
        s = makeStack(new int[] {-1, -3, 5, 0, 1, -5, 3});
        System.out.println (test.shiftByN(s, 3));
        //4
        System.out.println (test.reverseVowels("hello how are you"));
        //6
        //no shot brother
        //7
        System.out.println (test.bracketBalance("(([()]))"));
        System.out.println ("\nMyStack Lab:");
        
        
        //MyStack Lab
        MyStack m = new MyStack();

        System.out.println(m.isEmpty() + "\n"); //test with empty stack

        try { m.pop(); } catch (Exception e) { System.out.println("Attempting to pop an empty stack works!"); }

        m.push(4); m.push(6); m.push(3); m.push(7); //test push() method

        System.out.println("\nIn the stack:\n\n" + m); //test toString() method

        System.out.print("\n" + m.pop() + " "); //test peek() and pop()
        System.out.print(m.peek() + " "); 
        System.out.print(m.pop() + " ");
        System.out.println(m.peek());

        m.push(20); m.push(12); m.push(6);

        m.pop(); m.pop(); m.pop();

        System.out.println("\n" + m.isEmpty()); //test with non-empty stack
        
        

    }
    public String[] wordsWithout(String[] words, String target) {
  String[] list;
  int count = 0;
  int j = 0;
  for (int i = 0; i < words.length; i ++){
    if (words[i] != target){
      
      count++;
    }
  }
  list = new String[count];
  for (for (int i = 0; i < words.length; i ++){
    if (words[i] != target){
      list[j] = words[i];
      j++;
    }
  }
  return list;
}

}