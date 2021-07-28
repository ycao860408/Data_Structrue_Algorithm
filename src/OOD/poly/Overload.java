package OOD.poly;

public class Overload {
    public void method() {
        System.out.println("Hello!");
    }

    public int method(String name) {
        System.out.println("This is my " + name + ".");
        return 0;
    }

    public int method(int num) {
        System.out.println("The total number is " + num + ".");
        return 0;
    }
}
