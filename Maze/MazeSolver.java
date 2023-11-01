import java.util.*;
/**
 * Abstract class MazeSolver - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class MazeSolver
{
    Maze maze;
    boolean mazeSolved;
    public MazeSolver(Maze maze){
        mazeSolved = false;
        this.maze = maze;
        makeEmpty();
        add(this.maze.getStart());
    }
    abstract void makeEmpty();
    abstract boolean isEmpty();
    abstract void add(Square s);
    abstract void popThis();
    abstract Square next();
    public boolean isSolved(){
        if (mazeSolved){
            return true;
        }
        if (isEmpty()){
            return true;
        }
        else{
            Square s = next();
            if (s.getType() == 3)
                return true;
        }
        return false;
    }
    public void step(){
        if (isEmpty() || mazeSolved){
            return;
        }
        
        Square s = next();
        if (s.getType() == 3 || mazeSolved){
            mazeSolved = true;
            return;
        }
        else{
            List<Square> list = maze.getNeighbors(next()); 
            popThis();

            for (int i = 0; i < list.size(); i ++){
                if (list.get(i).getType() == 0 || list.get(i).getType() == 2){
                    if (list.get(i).getStatus() == Square.UNKNOWN){
                        list.get(i).setStatus(Square.WORKING);
                        add(list.get(i));
                    }
                }
                if (list.get(i).getType() == 3){
                    mazeSolved = true;
                }
            }
            s.setStatus(Square.EXPLORED);
        }
    }
    public String getPath(){
        if (isEmpty()){
            return "unsolvable";
        }
        else if (mazeSolved){
            return "solved";
        }
        else{
            return "not yet solved";
        }
    }
    public void solve(){
        if (!isSolved() && !isEmpty()){
            step();
        }
    }
}
