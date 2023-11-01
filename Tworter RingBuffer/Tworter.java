import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.*;
import java.io.*;

public class Tworter extends Thread {
    private CountDownLatch latch;
    private boolean write;
    private static RingBuffer buff;
    private int numCandy;

    public Tworter(String name, CountDownLatch latch, boolean w) {
        this.latch = latch;
        this.write = w;
        setName(name);
        buff = new RingBuffer(35);
        // INITIALIZE RING BUFFER IV HERE
    }

    @Override
    public void run() {
        Scanner reader = null;
        try {
            System.out.printf("[ %s ] created, blocked by the latch...\n", getName());
            latch.await();
            System.out.printf("[ %s ] starts at: %s\n", getName(), Instant.now());
            if(write)
            {
                try{
                    reader = new Scanner(new File("Tworts.txt"));
                }
                catch (Exception e){
                    
                }
                while(reader.hasNext())
                {
                    // Your code here, this should just call your RingBuffer's WRITE method one time.

                    sleep(500);
                    buff.enqueue(reader.next());
                    
                }
            }
            else
            {
                // This is your READER
                // You should call your RingBuffer's READ method 5 times here and print out the "Twort"
                
                String str = "";
                int total = 0;
                int size = 0;
                while (total != 10){
                    sleep(4000);
                    str = "";
                    size = 0;
                    while (size != 5){
                        if (buff.peek() != null){
                            str += buff.dequeue() + " ";
                            size++;
                        }
                    }
                    System.out.println (str);
                    System.out.println ("Twort");
                    total++;
                }
                
                
                
                
                
            }
        } catch (InterruptedException e) {
            // handle exception\
            System.out.println(e);
        }
    }
}