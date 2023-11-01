import java.io.*;
import java.util.*;
public class Maze{
    private static Square[][] maze;
    private int row;
    private int col;
    private Square start;
    private Square end;
    public Maze() throws FileNotFoundException{
        loadMaze("maze-2");
    }
    public boolean loadMaze(String fileName) throws FileNotFoundException{
        Scanner console = new Scanner(new File(fileName));
        row = console.nextInt();
        col = console.nextInt();
        maze = new Square[row][col];
        
        for (int r = 0; r < row; r ++){
            for (int c = 0; c < col; c ++){
                maze[r][c] = new Square(r, c, console.nextInt());
                if (maze[r][c].getType() == 2)
                    start = maze[r][c];
                if (maze[r][c].getType() == 3)
                    end = maze[r][c];
            }
        }
        return true;
    }
    public ArrayList<Square> getNeighbors (Square s){
        ArrayList<Square> list = new ArrayList<>();
        //corners
        //topL
        if (s.getRow() == 0 && s.getCol() == 0){
            list.add(maze[s.getRow()+1][s.getCol()]);
            list.add(maze[s.getRow()][s.getCol()+1]);
        }
        //botL
        else if (s.getRow() == maze.length-1 && s.getCol() == 0){
            list.add(maze[s.getRow()-1][s.getCol()]);
            list.add(maze[s.getRow()][s.getCol()+1]);
        }
        //topR
        else if (s.getCol() == maze[0].length-1 && s.getRow() == 0){
            list.add(maze[s.getRow()][s.getCol()-1]);
            list.add(maze[s.getRow()+1][s.getCol()]);
        }
        //botR
        else if (s.getCol() == maze[0].length-1 && s.getRow() == maze.length-1){
            list.add(maze[s.getRow()-1][s.getCol()]);
            list.add(maze[s.getRow()][s.getCol()-1]);
        }
        
        //sides
        else if (s.getRow() == 0){
            list.add(maze[s.getRow()][s.getCol()+1]);
            list.add(maze[s.getRow()+1][s.getCol()]);
            list.add(maze[s.getRow()][s.getCol()-1]);
        }
        else if (s.getRow() == maze.length-1){
            list.add(maze[s.getRow()-1][s.getCol()]);
            list.add(maze[s.getRow()][s.getCol()-1]);
            list.add(maze[s.getRow()][s.getCol()+1]);
        }
        else if (s.getCol() == 0){
            list.add(maze[s.getRow()-1][s.getCol()]);
            list.add(maze[s.getRow()+1][s.getCol()]);
            list.add(maze[s.getRow()][s.getCol()+1]);
        }
        else if (s.getCol() == maze[0].length-1){
            list.add(maze[s.getRow()][s.getCol()-1]);
            list.add(maze[s.getRow()-1][s.getCol()]);
            list.add(maze[s.getRow()+1][s.getCol()]);
        }
        //otherwise
        else{
            list.add(maze[s.getRow()-1][s.getCol()]);
            list.add(maze[s.getRow()+1][s.getCol()]);
            list.add(maze[s.getRow()][s.getCol()+1]);
            list.add(maze[s.getRow()][s.getCol()-1]);
        }
        return list;
    }
    
    public Square getStart(){
        return start;
    }
    public Square getExit(){
        return end;
    }
    public void reset(){
        for (int r = 0; r < maze.length; r ++){
            for (int c = 0; c < maze[r].length; c ++){
                maze[r][c].resetSquare();
            }
        }
    }
    public String toString(){
        String s = "";
        for (int r = 0; r < maze.length; r ++){
            for (int c = 0; c < maze[r].length; c ++){
                s += maze[r][c].toString() + " ";
            }
            s += "\n";
        }
        return s;
    }
}