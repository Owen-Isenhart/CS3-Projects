import java.util.*;

/**
 * Write a description of class EmployeeDatabase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EmployeeDatabase
{
    
    public Entry[] ary;
    public EmployeeDatabase(){
        ary = new Entry[100];
    }
    private class Entry{
        int ID;
        Employee employee;
        public Entry(int i, Employee e){
            ID = i;
            employee = e;
        }
        @Override
        public String toString(){
            return "ID: " + ID + ", Employee: " + employee.name;
        }
    }
    
    public int hash(int key){
        int keyIndex = key%10;
        //int keyIndex = key%1; //bad
        return keyIndex;
    }
    public void put(int key, Employee value){
        //linear
        int keyIndex = hash(key)*10;
        if (ary[keyIndex] != null){
            while (ary[keyIndex] != null){
                keyIndex++;
            }
            ary[keyIndex] = new Entry(key, value);
        }
        else{
            ary[keyIndex] = new Entry(key, value);
        }

        
        //quadratic
        // int keyIndex = hash(key)*10;
        // if (ary[keyIndex] != null){
            // int i = 1;
            // while (ary[keyIndex] != null){
                // keyIndex+= Math.pow(i, 2);
                // i++;
            // }
            // ary[keyIndex] = new Entry(key, value);
        // }
        // else{
            // ary[keyIndex] = new Entry(key, value);
        // }
    }
    public Employee get(int key){
        int keyID = hash(key)*10;
        if (ary[keyID*10].ID != key){
            int i = 0;
            while (ary[keyID*10 + i].ID != key){
                i++;
            }
            return ary[keyID*10 + i].employee;
        }
        else
            return ary[keyID*10].employee;
    }
    @Override
    public String toString(){
        String s = "";
        for (int i = 0; i < ary.length; i ++){
            if (ary[i] != null)
                s += ary[i].toString() + "\n";
        }
        return s;
    }
}
