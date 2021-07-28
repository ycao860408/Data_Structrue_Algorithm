package OOD.FactoryDesignPattern.SimpleFactory;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        /*Apple product = new IPad();
        product.buy();*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the product you want:");
        String type = sc.next();
        DealerFactory.getAppleProduct(type).buy();
        sc.close();
    }
}
