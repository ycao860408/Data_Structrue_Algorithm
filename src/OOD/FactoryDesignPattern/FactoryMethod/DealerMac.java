package OOD.FactoryDesignPattern.FactoryMethod;

public class DealerMac extends DealerFactory{
    @Override
    public Apple getAppleProduct() {
        return new Mac();
    }
}
