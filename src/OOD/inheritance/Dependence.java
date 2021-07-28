package OOD.inheritance;

public class Dependence {
    class Person {
        public void programming() {
            Computer pc = new Computer();
        }

        public Computer programming(Computer cmp) {
            return new Computer();
        }
    }

    class Computer {

    }
}
