import java.util.*;
import java.io.*;

public class BoggleSolver
{
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
    HashSet<String> dict;
    HashSet<String> words;
    public BoggleSolver(String dictionaryName)
    {
        //TODO
        words = new HashSet<>();
        dict = new HashSet<String>();
        try{
            Scanner console = new Scanner(new File(dictionaryName));
            while (console.hasNext()){
                dict.add(console.nextLine().toLowerCase());
            }
        }
        catch (Exception e){
            System.out.print (e);
        }
    }

    // Returns the set of all valid words in the given Boggle board, as an Iterable object
    public Iterable<String> getAllValidWords(BoggleBoard board)
    {
        //TODO
        boolean[][] temp = new boolean[board.rows()][board.cols()];
        for (int r = 0; r < board.rows(); r ++){
            for (int c = 0; c < board.cols(); c ++){
                getWords(board, r, c, temp, "");
            }
            
        }
        
        return words;
    }
        
    public void getWords(BoggleBoard board, int row, int col, boolean[][] visited, String str){
        if (visited[row][col] == true){
            return;
        }
        else{
            visited[row][col] = true;
        }
        
        
        str += board.getLetter(row, col);
        if (board.getLetter(row, col) == 'Q'){
            str+= "U";
        }
        
        if (dict.contains(str.toLowerCase())){
            if (str.length() >= 3){
                words.add(str);
            }
        }
        
        if (row - 1 >= 0 && col - 1 >= 0){
            getWords(board, row-1,col-1, visited, str);
        }
        if (col -1 >=0){
            getWords(board, row, col-1, visited, str);
        }
        if (row -1 >=0){
            getWords(board, row-1, col, visited, str);
        }
        if (row -1 >= 0 && col + 1 <= board.cols()-1){
            getWords(board, row-1, col+1, visited, str);
        }
        if (col + 1 <= board.cols()-1){
            getWords(board, row,col+1, visited, str);
        }
        if (row + 1 <= board.rows()-1 && col + 1 <= board.cols()-1){
            getWords(board, row+1,col+1, visited, str);
        }
        if (row + 1 <= board.rows()-1){
            getWords(board, row+1,col, visited, str);
        }
        if (row + 1 <= board.rows()-1 && col - 1 >= 0){
            getWords(board, row+1,col-1, visited, str);
        }
        visited[row][col] = false;
        
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A - Z.)
    public int scoreOf(String word)
    {
        //TODO
        int length = word.length();
        if (length < 2){
            return 0;
        }
        if (length > 2 && length < 5){
            return 1;
        }
        if (length == 5){
            return 2;
        }
        if (length == 6){
            return 3;
        }
        if (length == 7){
            return 5;
        }
        if (length > 7){
            return 11;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println("WORKING");

        final String PATH   = "./data/";
        BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");
        BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

        int totalPoints = 0;

        for (String s : solver.getAllValidWords(board)) {
            System.out.println(s + ", points = " + solver.scoreOf(s));
            totalPoints += solver.scoreOf(s);
        }

        System.out.println("Score = " + totalPoints); //should print 84

        //new BoggleGame(4, 4);
    }

}
