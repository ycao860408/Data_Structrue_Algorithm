package OOD.FactoryDesignPattern.FactoryMethod;

public class DealerIpad extends DealerFactory{
    @Override
    public Apple getAppleProduct() {
        return new IPad();
    }
}
