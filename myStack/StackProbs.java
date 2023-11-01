import java.util.*;
/**
 * Write a description of class StackProbs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StackProbs
{
    public Stack<Integer> doubleUp(Stack<Integer> nums){
        ArrayList<Integer> list = new ArrayList<>();
        int temp = 0;
        int length = nums.size();
        while (!nums.empty()){
            temp = nums.peek();
            list.add(temp);
            nums.pop();
        }
        for (int i = length-1; i > -1; i --){
            nums.push(list.get(i));
            nums.push(list.get(i));
        }
        return nums;
    }
    public Stack<Integer> posAndNeg(Stack<Integer> nums){
        ArrayList<Integer> list = new ArrayList<>();
        int length = nums.size();
        while (!nums.empty()){
            if (nums.peek() < 0){
                list.add(0, nums.peek());
                nums.pop();
            }
            else{
                list.add(nums.peek());
                nums.pop();
            }
        }
        for (int i = 0; i < length; i ++){
            nums.push(list.get(i));
        }
        return nums;
    }
    public Stack<Integer> shiftByN(Stack<Integer> nums, int n){
        ArrayList<Integer> list = new ArrayList<>();
        int length = nums.size();
        for (int i = 0; i < length; i ++){
            list.add(nums.peek());
            nums.pop();
        }
        System.out.println (list);
        for (int i = list.size()-(n+1); i > -1; i--){
            nums.push(list.get(i));
        }
        System.out.println (nums);
        for (int i = list.size()-1; i > n; i --){
            nums.push(list.get(i));
        }
        return nums;
    }
    public String reverseVowels(String str){
        String s = "";
        int length = str.length();
        String vowels = "AEIOUaeiou";
        Stack<String> stack = new Stack<>();
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < str.length(); i ++){
            if (vowels.indexOf(str.charAt(i)) > -1){
                index.add(i);
            }
        }
        for (int i = 0; i < str.length(); i ++){
            if (vowels.indexOf(str.charAt(i)) > -1){
                stack.push(str.charAt(i) + "");
                str = str.substring(0, i) + str.substring(i+1);
                i--;
            }           
        }
        System.out.println (index);
        int count = 0;
        for (int i = 0; i < length; i ++){
            if (i == index.get(count)){
                str = str.substring(0, i) + stack.peek() + str.substring(i);
                stack.pop();
                count++;
            }
        }
        return str;
    }
    public boolean bracketBalance(String s){
        Stack<String> stack = new Stack<>();
        boolean balanced = false;
        int count = 0;
        if (s.length() % 2 == 1){
            return false;
        }
        for (int i = 0; i < s.length(); i ++){
            stack.push(s.substring(i, i+1));
        }
        for (int i = 0; i < stack.size(); i ++){
            if (stack.peek() == "[" || stack.peek() == "("){
                count++;
            }
            else if (stack.peek() == "]" || stack.peek() == ")"){
                count--;
            }
        }
        if (count == 0){
            balanced = true;
        }
        return balanced;
    }
}
