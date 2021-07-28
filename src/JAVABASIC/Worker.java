package JAVABASIC;

public class Worker {
    private String name;
    private int age;

    public Worker() {

    }

    public Worker(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static void main(String[] args) {
        Worker wk1 = new Worker("John", 22);
        System.out.println(wk1);
        wk1.setAge(33);
        System.out.println(wk1);
        System.out.println(wk1.getName());
    }
}
