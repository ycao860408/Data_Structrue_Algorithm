package OOD.principle.LisKovSubstitution;

import java.util.Map;

public class SubClass extends SuperClass {
    @Override
    public void add(int a, int b) {
        System.out.println(a  + 2 * b);
    }

    public void subtract(int a, int b) {
        System.out.println(a - b);
    }

    public void function(Map map) {
        System.out.println("Son is Executing");
    }
}
