import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Triangle extends JPanel
{
    public Triangle()
    {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Sierpinski");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Triangle());
        frame.pack();
        frame.setVisible(true);
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
        drawTriangle(g, 0, 0, width, height);
    }

    public void drawTriangle(Graphics g, int x, int y, int width, int height){
        g.drawLine(x+width, y, x, y);
        g.drawLine(x, y, x, y+height);
        g.drawLine(x, y + height, x + width, y);

        g.drawLine(x, y + height/2, x + width/2, y + height/2);
        g.drawLine(x+width/2, y + height/2, x + width/2, y);
        g.drawLine(x+width/2, y, x, y+height/2);

        if (width<= 2){
            return;
        }
        drawTriangle(g, x, y, width/2, height/2);
        drawTriangle(g, x, y+height/2, width/2, height/2);
        drawTriangle(g, x+width/2, y, width/2, height/2);
    }
}
