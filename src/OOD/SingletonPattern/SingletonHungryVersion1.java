package OOD.SingletonPattern;

public class SingletonHungryVersion1 {
    static final private SingletonHungryVersion1 instance = new SingletonHungryVersion1();
    private SingletonHungryVersion1() {

    }

    public static SingletonHungryVersion1 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonHungryVersion1 instance1 = SingletonHungryVersion1.getInstance();
        SingletonHungryVersion1 instance2 = SingletonHungryVersion1.getInstance();
        System.out.println(instance1 == instance2);
    }
}
