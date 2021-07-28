package JAVABASIC;

public class OOPDemo {
    public static void main(String[] args) {
        Student st1 = new Student("Yue Cao", 'M', 33, 1224404002);
        Student st2 = new Student("Jing Cai", 'F', 32, 1224404001);
        System.out.println(st1);
        System.out.println(st2);
        st1.reading();
        st2.reading();
    }
}


class Student {
    private String name;
    private char gender;
    private int age;
    private int id;

    public Student(String name, char gender, int age, int id) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void reading( ) {
        System.out.println(this.name + " is reading.");
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}

