package OOD.inheritance;

public class Composition {
    class Person{
        private Man man;
        public Person() {
            this.man = new Man();
        }
    }

    class Man{

    }
}
