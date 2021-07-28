import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random rmd = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.print(rmd.nextInt(10) + " ");
        }
        System.out.println();
    }

}
