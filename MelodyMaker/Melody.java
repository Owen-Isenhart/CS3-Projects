
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
public class Melody{
    Queue<Note> notes;
    public Melody(Queue<Note> song){
        notes = new LinkedList<>();
        while (!song.isEmpty()){
            notes.offer(song.poll());
        }
    }

    public double getTotalDuration(){
        double total = 0;
        int loop = 0;
        for (int i = 0; i < notes.size(); i ++){
            if (notes.peek().isRepeat() || loop == 1){
                if (notes.peek().isRepeat()){
                    loop++;
                }
                if (loop > 1){
                    loop = 0;
                }
                total += notes.peek().getDuration()*2;
                notes.offer(notes.poll());
            }
            else{
                total += notes.peek().getDuration();
                notes.offer(notes.poll());
            }
        }
        return total;
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < notes.size(); i ++){
            s += notes.peek().toString();
            notes.offer(notes.poll());
        }
        return s;
    }

    public void changeTempo(double tempo){
        for (int i = 0; i < notes.size(); i ++){
            notes.peek().setDuration(notes.peek().getDuration()*tempo);
            notes.offer(notes.poll());
        }
    }

    public void reverse(){
        Stack<Note> reverser = new Stack<>();
        while (!notes.isEmpty()){
            reverser.push(notes.poll());
        }
        while (!reverser.isEmpty()){
            notes.offer(reverser.pop());
        }
    }

    public void append(Melody other){
        while (!other.notes.isEmpty()){
            notes.offer(other.notes.poll());
        }
    }
    public void play(){
        int loop = 0;
        Queue<Note> temp = new LinkedList<>();
        for (int i = 0; i < notes.size(); i ++){
            notes.peek().play();
            if (notes.peek().isRepeat() || loop == 1){
                temp.offer(notes.peek());
                if (notes.peek().isRepeat()){
                    loop++;
                }
            }
            notes.offer(notes.poll());
            if (loop == 2){
                loop = 0;
                while (!temp.isEmpty()){
                    temp.poll().play();
                }
            }

        }
    }

    public Queue<Note> getNotes(){
        return notes;
    }
}