import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.io.*;

public class WriterReader extends Thread {
    private CountDownLatch latch;
    private boolean write;
    private static RingBuffer buff;
    private int numCandy;

    public WriterReader(String name, CountDownLatch latch, boolean w) {
        this.latch = latch;
        this.write = w;
        setName(name);
        this.buff = new RingBuffer(5);
        this.numCandy = 150;
    }

    @Override
    public void run() {
        try {
            System.out.printf("[ %s ] created, blocked by the latch...\n", getName());
            latch.await();
            System.out.printf("[ %s ] starts at: %s\n", getName(), Instant.now());
            if(write)
            {
//                ObjectOutputStream outStream =
//                        new ObjectOutputStream(new FileOutputStream("treater.bin"));
                TrickOrTreater one = new TrickOrTreater("Little Dev", "Kit Kat", 10);
                System.out.println("I'M LITTLE DEV TRICK OR TREAT!!!!!!!!!!!!!!! :O");
                buff.enqueue(one);
                sleep(5000);

                TrickOrTreater two = new TrickOrTreater("Little Sanah", "Hersheys", 15);
                System.out.println("YOOOOO LITTLE SANAH IN THA LINE! TRICK OR TREAT!!! :')");
                buff.enqueue(two);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(two.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater three = new TrickOrTreater("Little Eeshwar", "Reeses", 20);
                System.out.println("LITTLE EESHWAR REPORTING FOR CANDY |:)");
                buff.enqueue(three);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(three.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater a = new TrickOrTreater("Little Grayson", "Hersheys", 15);
                System.out.println("I'M PICKLE GRAYSON! LOOK Y'ALL, I TURNED MYSELF INTO A PICKLE!");
                buff.enqueue(a);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(a.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater b = new TrickOrTreater("Little Jack", "Skittles", 30);
                System.out.println("TRICK OR TREAT CALL ME JACK SKELINGTON BC IT'S HALLOWEEN GET IT");
                buff.enqueue(b);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(b.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater d = new TrickOrTreater("Little Gavin", "LARGE INDUSTRIAL FAN", 10);
                System.out.println("I'M LITTLE GAVIN TRICK OR TREAT. :|");
                buff.enqueue(d);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(d.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater e = new TrickOrTreater("Little Ansh", "Apples", 10);
                System.out.println("I'M LITTLE ANSH TRICK OR TREAT GIVE CANDY PLZ :)");
                buff.enqueue(e);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(e.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater f = new TrickOrTreater("Little Altar", "Salad And Go", 15);
                System.out.println("LITTLE ALTAR IN THE LINE YALL GIMME THAT SALAD AND GO CANDY");
                buff.enqueue(f);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(f.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater g = new TrickOrTreater("Little Rohan", "Licorice", 10);
                System.out.println("I'M LITTLE ROHAN AND IF I DON'T GET CANDY I WILL CRY :'(");
                buff.enqueue(g);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(g.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater h = new TrickOrTreater("Little Rithanya", "3 Musketeers", 5);
                System.out.println("BWAHAHA TRICK OR TREAT IT'S LITTLE RITHANYA!!!!!");
                buff.enqueue(h);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(h.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater j = new TrickOrTreater("Little Vignesh", "Sour Patch Kids", 15);
                System.out.println("I'M LITTLE VIGNESH TRICK OR TREAT!!!!!! :D");
                buff.enqueue(j);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(j.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater k = new TrickOrTreater("Little Owen", "Milky Way", 15);
                System.out.println("I'M LITTLE OWEN TRICK OR TREAT!!!! :^)");
                buff.enqueue(k);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(k.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater m = new TrickOrTreater("Little Jaiden", "Raisinets", 50);
                System.out.println("AYO GUYS CHECK OUT MY MELODY MAKER FILES IN THE FUTURE OK IT'S LITTLE JAIDEN IN LINE!");
                buff.enqueue(m);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(m.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

                TrickOrTreater n = new TrickOrTreater("Little Tarun", "Warheads", 25);
                System.out.println("ASUHHHH YALL IT'S TARUN, TRICK OR TREAT!");
                buff.enqueue(n);
                sleep(5000);
                if(buff.isFull())
                {
                    System.out.println(n.name + " is about to fight " + buff.peek() + "!!! You screwed up big time!");
                }

            }
            else
            {
                sleep(1000);
                while(!buff.isEmpty())
                {
                    TrickOrTreater customer = buff.dequeue();
                    if(numCandy - customer.num < 0)
                    {
                        System.out.println("Not enough candy for you " + customer.name + ", get rekt!!");
                    }
                    else
                    {
                        System.out.println("Hello " + customer.name + "! Here are " + customer.num + " " + customer.request);
                        numCandy -= customer.num;
                    }
                    sleep(8000);
                }
            }
        } catch (InterruptedException e) {
            // handle exception
        }
    }
}