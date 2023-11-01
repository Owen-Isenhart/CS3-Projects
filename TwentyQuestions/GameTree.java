import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree
{
    Node root;
    Node current;
    int count = 11;
    private class Node{
        String val;
        Node left, right;
        public Node(String val){
            this.val = val;
            left = right = null;
        }
        @Override
        public String toString(){
            return this.val;
        }
    }
    
    public static void main(String[] args){
        GameTree test = new GameTree("actors.txt");
        System.out.print(test.toString());
    }
    
    /**
     * Constructor needed to create the game.
     *
     * @param fileName
     *          this is the name of the file we need to import the game questions
     *          and answers from.
     */
    
    public GameTree(String fileName)
    {
        //TODO
        root = new Node("");
        current = root;
        try{
            Scanner console = new Scanner(new File(fileName));
            build(root, console);
        }
        catch (Exception e){
            System.out.print (e);
        }
        
    }
    public void build(Node current, Scanner console){
        String s;
        if (console.hasNextLine())
            s = console.nextLine();
        else
            return;
            
        if (s != null){
            current.val = s;
        }
        if (s.contains("?")){
            Node left = new Node("");
            Node right = new Node("");
            current.left = left;
            current.right = right;
            build(left, console);
            build(right, console);
        }
    }

    /*
     * Add a new question and answer to the currentNode. If the current node has
     * the answer chicken, theGame.add("Does it swim?", "goose"); should change
     * that node like this:
     */
    // -----------Feathers?-----------------Feathers?------
    // -------------/----\------------------/-------\------
    // ------- chicken  horse-----Does it swim?-----horse--
    // -----------------------------/------\---------------
    // --------------------------goose--chicken-----------
    /**
     * @param newQ
     *          The question to add where the old answer was.
     * @param newA
     *          The new Yes answer for the new question.
     */
    public void add(String newQ, String newA)
    {
        //TODO
        String temp = current.val;
        current.val = newQ;
        Node left = new Node(newA);
        Node right = new Node(temp);
        current.left = left;
        current.right = right;
    }

    /**
     * True if getCurrent() returns an answer rather than a question.
     *
     * @return False if the current node is an internal node rather than an answer
     *         at a leaf.
     */
    public boolean foundAnswer()
    {
        //TODO
        if (current.val.contains("?"))
            return false; //replace
        else{
            return true;
        }
    }

    /**
     * Return the data for the current node, which could be a question or an
     * answer.  Current will change based on the users progress through the game.
     *
     * @return The current question or answer.
     */
    public String getCurrent()
    {
        //TODO

        return current.val; //replace
    }

    /**
     * Ask the game to update the current node by going left for Choice.yes or
     * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
     *
     * @param yesOrNo
     */
    public void playerSelected(Choice yesOrNo)
    {
        //TODO
        if (yesOrNo == Choice.Yes){
            current = current.left;
        }
        else{
            current = current.right;
        }
    }

    /**
     * Begin a game at the root of the tree. getCurrent should return the question
     * at the root of this GameTree.
     */
    public void reStart()
    {
        //TODO
        current = root;
    }

    @Override
    public String toString()
    {
        //TODO
        return buildString(root, "", 0);
    }
    public String buildString(Node node, String s, int space){
        if (node != null){
            String temp = "";
            for (int i = 0; i < space; i ++){
                temp += "- ";
            }
            space++;
            s =  buildString(node.right, s, space) + temp + node.val + "\n"+ buildString(node.left, s, space);
            
        }
        
        return s;
    }

    /**
     * Overwrite the old file for this gameTree with the current state that may
     * have new questions added since the game started.
     *
     */
    public void saveGame()
    {
        //TODO
        String outputFileName = "output.txt";
        PrintWriter diskFile = null;
        try{
            diskFile = new PrintWriter(new File(outputFileName));
            saveHelp(diskFile, root);
        }
        catch(Exception e){
            System.out.print (e);
        }
        diskFile.close();
        
    }
    public void saveHelp(PrintWriter disk, Node node){

        if (node == null){
            return;
        }
            
        saveHelp(disk, node.right);
        disk.println(node.val);
        saveHelp(disk, node.left);
    }
    
}
