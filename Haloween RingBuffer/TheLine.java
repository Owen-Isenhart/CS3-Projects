import java.io.*;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class TheLine
{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        CountDownLatch latch = new CountDownLatch(1);

        WriterReader one  = new WriterReader("Writer", latch, true);
        WriterReader two  = new WriterReader("Reader", latch, false);

        one.start();
        two.start();

        System.out.println("release the latch");
        latch.countDown();
    }
}
