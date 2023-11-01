import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
    public SnowFlakePanel()
    {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)
    {
        int width  = getWidth();
        int height = getHeight();

        super.paintComponent(g);

        /*
         * DRAWING CODE BELOW
         */
        g.setColor(Color.BLUE);
        //g.drawLine(0, 0, width - 1, height - 1);
        //drawStar(g, width/2, height/2, width/4);
        //blizzard(g, 60);
    }

    public void drawStar(Graphics g, int x, int y, int size){
        int width  = getWidth();
        int height = getHeight();
        if (size > getWidth() / (int)Math.pow(size, 4)){
            for (int i = 0; i < 6; i ++){

                g.drawLine((int)(x + size * Math.cos((i*2*Math.PI)/6)), (int)(y + size * Math.sin((i*2*Math.PI)/6)), x, y);
                drawStar(g, (int)(x + size * Math.cos((i*2*Math.PI)/6)), (int)(y + size * Math.sin((i*2*Math.PI)/6)), size/4);
            }
        }

        
    }

    public void blizzard(Graphics g, int size){
        int width  = getWidth();
        int height = getHeight();
        Random rnd = new Random();
        for (int i = 0; i < 30; i ++){

            int r = rnd.nextInt(256);
            int gx = rnd.nextInt(256);
            int b = rnd.nextInt(256);
            g.setColor(new Color(r, gx, b));
            drawStar(g, (int)(Math.random()*width), (int)(Math.random()*height), (int)(Math.random()*size));
        }
    }
}

public class Snowflake
{
    public static void main ( String[] args )
    {
        /*
         * A frame is a container for a panel
         * The panel is where the drawing will take place
         */
        JFrame frame = new JFrame("Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SnowFlakePanel());
        frame.pack();
        frame.setVisible(true);
    }
}