package OOD.poly;

public class Override {
    class Person{
        public void eat() {
            System.out.println("eating");
        }
    }

    class Man extends Person{
        public void eat() {
            super.eat();
            System.out.println("especially likes eating meat!");
        }
    }
}
