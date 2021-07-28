package OOD.SingletonPattern;

public class ProblemOfLazyVersion1 {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                System.out.println(SingletonLazyVersion1.getInstance());

            }
        }.start();

        new Thread() {
            public void run() {
                System.out.println(SingletonLazyVersion1.getInstance());
            }
        }.start();

    }
}
