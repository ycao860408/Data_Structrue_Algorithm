package OOD.SingletonPattern;

public class SingletonHungryVersion2 {
    private final static SingletonHungryVersion2 instance;
    static{
        instance = new SingletonHungryVersion2();
    }
    private SingletonHungryVersion2() {

    }

    public SingletonHungryVersion2 getInstance() {
        return instance;
    }
}
