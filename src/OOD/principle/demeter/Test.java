package OOD.principle.demeter;

public class Test {
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.command(new Employee(), 30);
    }
}
