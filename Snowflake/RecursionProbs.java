import java.util.*;

/**
 * Write a description of class RecursionProbs here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RecursionProbs
{
    public double sumReciprocals(int n){
        if (n == 1){
            return 1;
        }
        return (1.0/n) + sumReciprocals(n-1);
    }
    public int productOfEvens(int n){
        int count = n*2;
        if (n==0){
            return 1;
        }
        return (n*2) * productOfEvens(n-1);
    }
    
    //riddle: bro what
    
    public String conversion(int num, int base){
        if (num/base == 0){
            return num%base + "";
        }
        return conversion(num/base, base) + num%base + "";
    }
    public int matchingDigits(int a, int b){
        int count = 0;
        
        if (a % 10 == b % 10){
            count++;
        }
        if (a <= 0 || b <= 0){
            return count;
        }
        return count+matchingDigits(a/10, b/10);
    }
    public void doubleUp(Stack<Integer> nums, Stack<Integer> neo){
        if (nums.isEmpty()){
            while (!neo.isEmpty()){
                nums.push(neo.peek());
                nums.push(neo.pop());
            }
        }
        else{
            neo.push(nums.pop());
            doubleUp(nums, neo);
        }
    }
    public void printThis(int n, String s){
        if (s.equals("") && n % 2 == 0){
            s = "**";
        }
        else if (s.equals("") && n % 2 == 1){
            s = "*";
        }
        if (n <= 2){
            
            System.out.println (s);
            return;
            
        }
        
        s = "<" + s + ">";
        printThis(n-2, s);
    }
    public void printNums2(int n){
        if (n == 1){
            System.out.print ("1");
            return;
        }
        else if (n == 2){
            System.out.print ("11");
            return;
        }
        System.out.print("" + (int) Math.ceil((double)n/2));
        printNums2(n-2);
        System.out.print("" + (int) Math.ceil((double)n/2));
    }
    public static void main(String[] args){
        RecursionProbs test = new RecursionProbs();
        System.out.println (test.sumReciprocals(10));
        System.out.println (test.productOfEvens(4));
        System.out.println (test.conversion(1453, 8));
        System.out.println (test.matchingDigits(1000, 0));
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(12);
        stack.push(9);
        Stack<Integer> neo = new Stack<>();
        test.doubleUp(stack, neo);
        System.out.println (stack);
        test.printThis(1, "");
        test.printThis(2, "");
        test.printThis(3, "");
        test.printThis(4, "");
        test.printThis(5, "");
        test.printThis(6, "");
        test.printThis(7, "");
        test.printThis(8, "");
        test.printThis(9, "");
        test.printNums2(1);
        System.out.println();
        test.printNums2(2);
        System.out.println();
        test.printNums2(3);
        System.out.println();
        test.printNums2(4);
        System.out.println();
        test.printNums2(5);
        System.out.println();
        test.printNums2(6);
        System.out.println();
        test.printNums2(7);
        System.out.println();
        test.printNums2(8);
        System.out.println();
        test.printNums2(9);
        System.out.println();
        test.printNums2(10);
        System.out.println();
    }
}
