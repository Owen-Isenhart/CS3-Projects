import java.util.LinkedList;
import java.util.Queue;

public class Runner{
    public static void main(String[] args){
        QueueProbs test = new QueueProbs();
        Queue<Integer> tester = new LinkedList<>();
        tester.offer(3);
        tester.offer(5);
        tester.offer(4);
        tester.offer(17);
        tester.offer(6);
        tester.offer(83);
        tester.offer(1);
        tester.offer(84);
        tester.offer(16);
        tester.offer(37);
        System.out.println(test.evenFirst(tester));
        tester.offer(3);
        tester.offer(8);
        tester.offer(17);
        tester.offer(9);
        tester.offer(17);
        tester.offer(8);
        tester.offer(3);
        System.out.println(test.numPalindrome(tester));
        System.out.println(test.primes(50));
    }
}