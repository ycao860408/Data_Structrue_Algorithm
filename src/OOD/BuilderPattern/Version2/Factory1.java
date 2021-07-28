package OOD.BuilderPattern.Version2;

public class Factory1 extends Apple {

    IPhone iphone = new IPhone();
    @Override
    public void buildScreen() {
        iphone.setScreen("IPhone 5's screen");
    }

    @Override
    public void buildEarphone() {
        iphone.setEarphone("IPhone 5's earphone");
    }

    @Override
    public void buildPower() {
        iphone.setPower("IPhone 5's power");
    }

    @Override
    public IPhone makeIphone() {
        return iphone;
    }
}
