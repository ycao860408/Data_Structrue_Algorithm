package OOD.inheritance;

public class Realization {
    interface Person {
        void eat();
    }

    class Man implements Person{
        public void eat() {
            System.out.println("Eating meat!");
        }
    }
}
