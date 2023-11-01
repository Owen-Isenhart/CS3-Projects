import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class TworterRunner
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        CountDownLatch latch = new CountDownLatch(1);

        Tworter writer  = new Tworter("Writer", latch, true);
        Tworter reader  = new Tworter("Reader", latch, false);

        writer.start();
        reader.start();

        System.out.println("release the latch");
        latch.countDown();
    }
}
