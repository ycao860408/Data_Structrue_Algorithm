package OOD.FactoryDesignPattern.FactoryMethod;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        /*Apple product = new IPad();
        product.buy();*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the product you want:");
        String type = sc.next().toLowerCase();
        if ("iphone".equals(type)) {
            new DealerIphone().getAppleProduct().buy();
        } else if ("ipad".equals(type)) {
            new DealerIpad().getAppleProduct().buy();
        } else if ("mac".equals(type)) {
            new DealerMac().getAppleProduct().buy();
        } else {
            System.out.println("No product matched!");
        }
        sc.close();
    }
}
