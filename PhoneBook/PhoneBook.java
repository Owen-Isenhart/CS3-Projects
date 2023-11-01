
/**
 * Write a description of class PhoneBook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhoneBook implements IMap
{
    public class Entry
    {
        public Person person;
        public PhoneNumber phoneNum;
        Entry next;
        public Entry(Person p, PhoneNumber num){
            person = p;
            phoneNum = num;
            next = null;
        }
        public String toString(){
            return "name: " + person.name + ", number: " + phoneNum.number;
        }
    }
    public Entry[] ary;
    public int size;
    public PhoneBook(){
        ary = new Entry[10];
        size = 0;
    }
    @Override
    public PhoneNumber put(Person person, PhoneNumber phone){
        int index = person.hashCode();
        Entry temp = ary[index];
        Entry prev = null;
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        temp = new Entry(person, phone);
        size++;
        return prev.phoneNum;
    }

    /**
     * perform a table lookup
     * @param person
     * @return phone number mapped to this person
     */
    @Override
    public PhoneNumber get(Person person){
        int index = person.hashCode();
        Entry temp = ary[index];
        while (!temp.person.equals(person)){
            temp = temp.next;
        }
        return temp.phoneNum;
    }

    /** return the current number of key/value pairs in the map */
    @Override
    public int size(){
        return size;
    }

    /**
     * Remove supplied key (person)
     * @return value mapped to supplied person, or null
     */
    @Override
    public PhoneNumber remove(Person person){
        int index = person.hashCode();
        Entry temp = ary[index];
        Entry prev = null;
        while (temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        size--;
        return temp.phoneNum;
        
        
    }
}

