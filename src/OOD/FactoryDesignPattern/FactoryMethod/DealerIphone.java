package OOD.FactoryDesignPattern.FactoryMethod;

public class DealerIphone extends DealerFactory{
    @Override
    public Apple getAppleProduct() {
        return new Iphone();
    }
}
