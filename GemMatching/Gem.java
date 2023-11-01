import java.awt.Font;
import java.util.*;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{    
    GemType type;
    int points;
    public Gem(){
        int temp = (int)(Math.random()*3)+1;
        if (temp == 1)
            type = GemType.GREEN;
        if (temp == 2)
            type = GemType.BLUE;
        if (temp == 3)
            type = GemType.ORANGE;
            
        temp = (int)(Math.random()*11);
        if (temp == 0)
            points = 0;
        if (temp == 1)
            points =5;
        if (temp == 2)
            points =10;
        if (temp == 3)
            points =15;
        if (temp == 4)
            points =20;
        if (temp == 5)
            points =25;
        if (temp == 6)
            points =30;
        if (temp == 7)
            points =35;
        if (temp == 8)
            points =40;
        if (temp == 9)
            points =45;
        if (temp == 10)
            points =50;
    }
    public Gem(GemType t, int p){
        type = t;
        points = p;
    }
    public String toString(){
        return type + " " + points;
    }
    public GemType getType(){
        return type;
    }
    public int getPoints(){
        return points;
    }
    public void draw(double x, double y){
        if (type == GemType.GREEN){
            StdDraw.picture(x, y, "gem_green.png");
        }
        if (type == GemType.BLUE){
            StdDraw.picture(x, y, "gem_blue.png");
        }
        if (type == GemType.ORANGE){
            StdDraw.picture(x, y, "gem_orange.png");
        }
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(x, y, points + "");
    }
    /** Tester main method */
    public static void main(String [] args)
    {
       final int maxGems = 16;
       
       // Create a gem of each type
       Gem green  = new Gem(GemType.GREEN, 10);
       Gem blue   = new Gem(GemType.BLUE, 20);
       Gem orange = new Gem(GemType.ORANGE, 30);
       System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());        
       System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
       System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
       green.draw(0.3, 0.7);
       blue.draw(0.5, 0.7);
       orange.draw(0.7, 0.7);
       
       // A row of random gems
       for (int i = 0; i < maxGems; i++)
       {
           Gem g = new Gem();
           g.draw(1.0 / maxGems * (i + 0.5), 0.5);
       }
    }
}
