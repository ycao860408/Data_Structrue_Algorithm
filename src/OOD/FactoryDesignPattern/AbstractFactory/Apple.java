package OOD.FactoryDesignPattern.AbstractFactory;

public class Apple implements Company{
    @Override
    public Phone byPhone() {
        return new Iphone();
    }

    @Override
    public LapTop byLapTop() {
        return new Mac();
    }
}
