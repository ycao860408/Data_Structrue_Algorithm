package OOD.principle.LisKovSubstitution;

import java.util.HashMap;

public class SuperClass {
    public void add(int a, int b) {
        System.out.println(a + b);
    }
    public void function(HashMap map) {
        System.out.println("Father is executing!");
    }

}
