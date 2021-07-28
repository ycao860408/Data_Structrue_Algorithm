package OOD.SingletonPattern;

public class SingletonLazyVersion1 {
    private static SingletonLazyVersion1 instance = null;

    private SingletonLazyVersion1() {

    }

    public static SingletonLazyVersion1 getInstance() {
        if (instance == null) {
            instance = new SingletonLazyVersion1();
        }
        return instance;
    }
}
