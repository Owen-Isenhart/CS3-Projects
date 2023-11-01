
/**
 * Write a description of class MyHashTable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyHashTable <k, v>
{
    public class Entry <p, n>
    {
        public p person;
        public n phoneNum;
        Entry next;
        public Entry(p p, n num){
            person = p;
            phoneNum = num;
            next = null;
        }
        public String toString(){
            return "name: " + person + ", number: " + phoneNum;
        }
    }
    public Entry[] ary;
    public int size;
    public MyHashTable(){
        ary = new Entry[10];
        size = 0;
    }
    public v put(k person, v phone){
        int index = person.hashCode()%10;
        Entry temp = ary[index];
        v prev = null;
        if (get(person) != null)
            prev = get(person);
        if (temp == null){
            ary[index] = new Entry(person, phone);
            size++;
            return null;
        }
        else if (temp.person.equals(person)){
            ary[index] = new Entry(person, phone);
        }
        else{
            while (temp != null){
                if (temp.next != null && (temp.next.person).equals(person)){
                    temp.next = new Entry(person, phone);
                    break;
                }
                else if (temp.next == null){
                    temp.next = new Entry(person, phone);
                    break;
                }
                else
                    temp = temp.next;
            
            }
        }
        size++;
        return prev;
    }

    /**
     * perform a table lookup
     * @param person
     * @return phone number mapped to this person
     */
    public v get(k person){
        int index = person.hashCode()%10;
        Entry temp = ary[index];
        if (ary[index] == null)
            return null;
        else{
            while (temp != null){
                if ((temp.person).equals(person)){
                    return (v) temp.phoneNum;
                }
                else{
                    temp = temp.next;
                }
            }
        }
        
        
        return (v)temp;
    }

    /** return the current number of key/value pairs in the map */
    public int size(){
        int num = 0;
        for (int i = 0; i < ary.length; i ++){
            if (ary[i] != null){
                num++;
                Entry temp = ary[i];
                while (temp != null){
                    if (temp.next != null){
                        num++;
                        temp = temp.next;
                        
                    }
                    else
                        break;
                }
            }
        }
        return num;
    }

    /**
     * Remove supplied key (person)
     * @return value mapped to supplied person, or null
     */
    public v remove(k person){
        int index = person.hashCode()%10;
        v n = null;
        Entry temp = ary[index];
        if (temp == null){
            return null;
        }
        else if (ary[index].person.equals(person)){
            size--;
            n = (v) ary[index].phoneNum;
            if (temp.next != null){
                ary[index] = temp.next;
                return n;
            }
            else
                ary[index] = null;
                
            return n;
        }
        else{
            size--;
            while (temp != null){
                if (temp.next != null && (temp.next.person).equals(person)){
                    n = (v) (temp.next).phoneNum;
                    temp.next = (temp.next).next;
                    return n;
                    
                }
                else
                    temp = temp.next;
            }
        }
        return null;
    }
}
