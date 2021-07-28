package OOD.inheritance;

public class Generalization {

    class Person{
        private String name;
        private String age;
        public void eat() {
            System.out.println("eating...");
        }
    }

    class Man extends Person {
        public void play() {
            System.out.println("LoL");
        }
    }

    public void test(){
        Man man = new Man();
        man.eat();
        man.play();
    }

    public static void main(String[] args) {
        Generalization gen = new Generalization();
        gen.test();
    }
}
