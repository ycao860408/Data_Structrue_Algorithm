package OOD.FactoryDesignPattern.AbstractFactory;

public class Huawei implements Company {
    @Override
    public Phone byPhone() {
        return new Honor();
    }

    @Override
    public LapTop byLapTop() {
        return new Matebook();
    }
}
