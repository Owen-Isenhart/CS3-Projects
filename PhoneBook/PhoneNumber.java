
/**
 * Write a description of class PhoneNumber here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhoneNumber
{
    public String number;
    public PhoneNumber(String n){
        number = n;
    }
    @Override
    public int hashCode(){
        return 1;
    }
    @Override
    public boolean equals(Object obj){
        PhoneNumber num = (PhoneNumber)obj;
        if (num.number.equals((this.number))){
            return true;
        }
        return false;
    }
    // public String number;
    // public PhoneNumber(String n){
        // number = n;
    // }
    // @Override
    // public int hashCode(){
        // return Character.getNumericValue(number.charAt(0))%10;
    // }
    // @Override
    // public boolean equals(Object obj){
        // PhoneNumber num = (PhoneNumber)obj;
        // if (num.number.equals(this.number)){
            // return true;
        // }
        // return false;
    // }
}
