package OOD.FactoryDesignPattern.AbstractFactory;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type in the brand you want:");
        String brand = sc.next().toLowerCase();
        System.out.println("Type in the product you want:");
        String product = sc.next().toLowerCase();

        if ("huawei".equals(brand)) {
            if ("phone".equals(product)) {
                new Huawei().byPhone().buy();
            } else if ("laptop".equals(product)) {
                new Huawei().byLapTop().buy();
            } else {
                System.out.println("No product matched!");
            }
        } else if ("apple".equals(brand)) {
            if ("phone".equals(product)) {
                new Apple().byPhone().buy();
            } else if ("laptop".equals(product)) {
                new Apple().byLapTop().buy();
            } else {
                System.out.println("No product matched!");
            }
        } else {
            System.out.println("No brand matched");
        }
        sc.close();
    }
}
