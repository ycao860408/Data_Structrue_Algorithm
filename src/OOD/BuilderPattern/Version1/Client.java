package OOD.BuilderPattern.Version1;

public class Client {
    public static void main(String[] args) {
        Apple apple = new Factory();
        CEO jobs = new CEO(apple);
        IPhone iPhone = jobs.makeIPhone("Big Screen", "Blue Tooth Earphone", "Rechargeable Power Station");
        System.out.println(iPhone);
    }
}
