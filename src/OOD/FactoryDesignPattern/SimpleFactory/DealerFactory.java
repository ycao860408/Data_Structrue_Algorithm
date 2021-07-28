package OOD.FactoryDesignPattern.SimpleFactory;

public class DealerFactory {
    public static Apple getAppleProduct(String type) {
        Apple product = null;
        switch(type) {
            case "iphone":
                product = new Iphone();
                break;
            case "ipad":
                product = new IPad();
                break;
            case "mac":
                product = new Mac();
                break;
            default:
                System.out.println("Without this product");
        }
        return product;
    }
}
