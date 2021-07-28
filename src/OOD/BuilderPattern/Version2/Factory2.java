package OOD.BuilderPattern.Version2;

public class Factory2 extends Apple {

    IPhone iphone = new IPhone();
    @Override
    public void buildScreen() {
        iphone.setScreen("IPhone X's screen");
    }

    @Override
    public void buildEarphone() {
        iphone.setEarphone("IPhone X's earphone");
    }

    @Override
    public void buildPower() {
        iphone.setPower("IPhone X's power");
    }

    @Override
    public IPhone makeIphone() {
        return iphone;
    }
}
