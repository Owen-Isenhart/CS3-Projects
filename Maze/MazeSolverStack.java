import java.util.*;
import java.io.*;
/**
 * Write a description of class MazeSolverStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MazeSolverStack extends MazeSolver
{
    private Stack<Square> stack;
    public MazeSolverStack(Maze maze){
        super(maze);
    }
    @Override
    public void makeEmpty(){
        stack = new Stack<>();
    }
    @Override
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    @Override
    public Square next(){
        return stack.peek();
    }
    public void popThis(){
        stack.pop();
    }
    @Override
    public void add(Square s)
    {
        stack.push(s);
    }
}
