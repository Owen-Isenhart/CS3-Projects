import java.util.*;

/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);
        
        String ribbonS = console.nextLine();
        String widthS = console.nextLine();
        String heightS = console.nextLine();
        
        int ribbon = Integer.parseInt(ribbonS);
        int width = Integer.parseInt(widthS);
        int height = Integer.parseInt(heightS);
        
        int result = 0;
        int count = 0;
        int[][] frame = new int[width][height];
        for (int r = width; r > -1; r --){
            for (int c = height; c > -1; c --){
                if (count < ribbon){
                    count++;
                    if (
                }
            }
        }
        System.out.println (result);
    }
}
