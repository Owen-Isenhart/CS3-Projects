
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class QueueProbs
{
    public Queue<Integer> evenFirst(Queue<Integer> nums){
        Queue<Integer> neo = new LinkedList<>();
        Queue<Integer> extra = new LinkedList<>();
        while (nums.size() > 0){
            if (nums.peek() % 2 == 0){
                neo.offer(nums.peek());
                nums.poll();
            }
            else{
                extra.offer(nums.peek());
                nums.poll();
            }
        }
        while (extra.size() > 0){
            neo.offer(extra.peek());
            extra.poll();
        }
        return neo;
    }

    public boolean numPalindrome(Queue<Integer> nums){
        int even = 0;
        int count = 0;

        ArrayList<Integer> list = new ArrayList<>();
        while (nums.size() > 0){
            list.add(nums.peek());
            nums.poll();
        }
        int count2 = list.size()-1;
        while (count < list.size()){
            if (list.get(count) != list.get(count2)){
                return false;
            }
            count++;
            count2--;
        }
        return true;
    }

    //riddle
    //yesterday today tommorow

    public ArrayList<Integer> primes(int x){
        Queue<Integer> nums = new LinkedList<>();
        for (int i = 2; i < x+1; i ++){
            nums.offer(i);
        }
        boolean primeNum = true;
        ArrayList<Integer> prime = new ArrayList<>();
        while (!nums.isEmpty()){
            primeNum = true;
            for (int i = 2; i < nums.peek(); i ++){
                if (nums.peek() % i == 0){
                    primeNum = false;
                    break;
                }
            }
            if (primeNum){
                prime.add(nums.poll());
            }
            else{
                nums.poll();
            }
        }
        return prime;
    }
}
