package OOD.principle.LisKovSubstitution;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        SuperClass father = new SuperClass();
        SubClass son = new SubClass();
        HashMap map = new HashMap();
        System.out.println("The execution of Superclass");
        father.add(3, 4);
        father.function(map);// does not violate!
        System.out.println("The substitution of subclass to superclass");
        son.add(3, 4); // violate the liskov
        son.function(map); // does not violate
        //son.subtract(3, 4); special method of the subclass!
        System.out.println("================================================");
        Father father1 = new Father();
        Son son1 = new Son();

        System.out.println("Execution of Father");
        father1.add(3, 4);

        System.out.println("The substitution of sone to father");
        son1.add(3, 4);
    }
}
