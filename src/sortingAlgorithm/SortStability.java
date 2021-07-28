package sortingAlgorithm;


import java.util.Arrays;

public class SortStability {
    public static void bubbleStableSort(Product[] products) {
        boolean change;
        while (true) {
            change = false;
            /*for (int i = 1; i < products.length; i++) {
                if (products[i - 1].getPrice() > products[i].getPrice()) {
                    Product temp = products[i - 1];
                    products[i - 1] = products[i];
                    products[i] = temp;
                    change = true;
                }
            }
            for (int i = 1; i < products.length; i++) {
                if (products[i - 1].getSale()> products[i].getSale()) {
                    Product temp = products[i - 1];
                    products[i - 1] = products[i];
                    products[i] = temp;
                    change = true;
                }
            }*/
            for (int i = 1; i < products.length; i++) {
                if (products[i].compareTo(products[i - 1]) < 0 ) {
                    Product temp = products[i - 1];
                    products[i - 1] = products[i];
                    products[i] = temp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
    }

    public static void bubbleNonstableSort(Product[] products) {
        boolean change;
        while (true) {
            change = false;
            for (int i = 1; i < products.length; i++) {
                if (products[i - 1].getPrice() >= products[i].getPrice()) {
                    Product temp = products[i - 1];
                    products[i - 1] = products[i];
                    products[i] = temp;
                    change = true;
                }
            }
            for (int i = 1; i < products.length; i++) {
                if (products[i - 1].getSale()>= products[i].getSale()) {
                    Product temp = products[i - 1];
                    products[i - 1] = products[i];
                    products[i] = temp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Product product1 = new Product(3, 10);
        Product product2 = new Product(1, 9);
        Product product3 = new Product(2, 9);
        Product product4 = new Product(0, 9);

        Product[] products = new Product[] {product1, product2, product3, product4};
        Product[] temp;
        bubbleStableSort(temp = Arrays.copyOf(products, products.length));

        for (Product item : temp) {
            System.out.println(item.toString());
        }

        System.out.println();

        /*bubbleNonstableSort(temp = Arrays.copyOf(products, products.length));
        for (Product item : temp) {
            System.out.println(item.toString());
        }
        System.out.println();*/

    }
}
