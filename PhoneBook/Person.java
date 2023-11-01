
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    public String name;
    public Person(String s){
        name = s;
    }
    @Override
    public int hashCode(){
        return Math.abs(name.hashCode());
    }
    @Override
    public boolean equals(Object obj){
        Person p = (Person)obj;
        if (p.name.equals(this.name)){
            return true;
        }
        return false;
    }
}
