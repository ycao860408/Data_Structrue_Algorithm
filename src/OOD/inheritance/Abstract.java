package OOD.inheritance;

public class Abstract {
    abstract class Person{
        private String name;
        private char gender;
        private int age;
        private Person() {

        }
        public Person(String name, char gender, int age) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public abstract void eat();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public char getGender() {
            return gender;
        }

        public void setGender(char gender) {
            this.gender = gender;
        }
    }

    class Woman extends Person {
        private int periods;
        public Woman() {
            super();
        }
        public Woman(String name, char gender, int age, int periods) {
            super(name, gender, age);
            this.periods = periods;
        }

        public void eat() {
            System.out.println("Eating more veges!");
        }

        public int getPeriods() {
            return periods;
        }

        public void setPeriods(int periods) {
            this.periods = periods;
        }
    }
}
