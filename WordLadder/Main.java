import java.util.*;
import java.io.*;

/**
 * Takes a word and finds the fastest word ladder
 * to the desired final word
 *
 * @author Owen Isenhart
 */
public class Main
{
    public static void main(String[] args) throws FileNotFoundException{
        //creating dictionary
        Scanner console = new Scanner(new File("dictionary.txt"));
        Set<String> dictionary = new HashSet<>();
        while (console.hasNext()){
            dictionary.add(console.nextLine().toLowerCase());
        }
        
        //input
        ArrayList<String> words = new ArrayList<>();
        console = new Scanner(new File("input.txt"));
        while (console.hasNext()){
            words.add(console.nextLine());
        }
        Queue<Stack> ladder = new LinkedList<>();
        ArrayList<String> output = new ArrayList<>();
        Queue<String> finalWords = new LinkedList<>();
        String[] temp;
        for (int i = 0; i < words.size(); i ++){
            temp = words.get(i).split(" ");
            if (!dictionary.contains(temp[0]) || !dictionary.contains(temp[1])){
                output.add("No ladder between " + temp[0] + " and " + temp[1]);
            }
            else{
                Stack<String> stack = new Stack<>();
                stack.push(temp[0]);
                finalWords.offer(temp[1]);
                ladder.offer(stack);
                ladder.offer(ladder.poll());
            }
        }
        
        for (int i = 0; i < ladder.size(); i ++){
            System.out.println (ladder.peek());
            ladder.offer(ladder.poll());
        }
        for (int i = 0; i < finalWords.size(); i ++){
            System.out.println (finalWords.peek());
            finalWords.offer(finalWords.poll());
        }
        //algorithm
        Stack<String> view = new Stack<>();
        String str = "";
        int count = 0;
        boolean solved = false;
        while (!solved){
            for (int i = 0; i < ladder.size(); i ++){ //loop every stack
                view = ladder.peek();
                for (int j = 0; j < view.peek().length(); j ++){ //loop every letter in the top of stack
                    str = view.peek();
                    for (char ch = 'a'; ch <= 'z'; ch++){
                        if (dictionary.contains(str.substring(0, j) + ch + str.substring(j+1))){
                            Stack<String> stack = new Stack<>();
                            stack = view;
                            dictionary.remove(str.substring(0, j) + ch + str.substring(j+1));
                            stack.push(str.substring(0, j) + ch + str.substring(j+1));
                            ladder.poll();
                            ladder.offer(stack);
                            output.add(stack.peek());
                            System.out.println (str.substring(0, j) + ch + str.substring(j+1));
                        }
                        if (ladder.peek().peek().equals(finalWords.peek())){
                            Stack<String> stack = new Stack<>();
                            stack = ladder.peek();
                            Object[] ary = stack.toArray();
                            String s = "Found a Ladder! >>> [";
                            for (int e = 0; e < stack.size(); e ++){
                                
                                if (e == stack.size()-2){
                                    s += stack.pop();
                                }
                                else{
                                    s += stack.pop() + ", ";
                                }
                            }
                            s += "]";
                            output.add(s);
                            solved = true;
                        }
                        
                        
                    }
                }
                
                ladder.offer(ladder.poll());
            }
            
        }
        
        //printing out results
        for (int i = 0; i < output.size(); i ++){
            System.out.println (output.get(i));
        }
    }
}
