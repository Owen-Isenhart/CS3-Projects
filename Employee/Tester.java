public class Tester{
    public static void main(String[] args){
        EmployeeDatabase test = new EmployeeDatabase();
        test.put(11111, new Employee("john"));
        test.put(11111, new Employee("handcock"));
        test.put(55555, new Employee("aaa"));
        test.put(12357, new Employee("ddd"));
        test.put(99999, new Employee("ccc"));
        test.put(66666, new Employee("qqq"));
        System.out.println(test.get(55555).name);
        System.out.println(test.toString());
    }
}