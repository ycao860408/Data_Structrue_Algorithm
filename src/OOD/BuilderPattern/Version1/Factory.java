package OOD.BuilderPattern.Version1;

public class Factory extends Apple {

    IPhone iphone = new IPhone();
    @Override
    public void buildScreen(String screen) {
        iphone.setScreen(screen);
    }

    @Override
    public void buildEarphone(String earphone) {
        iphone.setEarphone(earphone);
    }

    @Override
    public void buildPower(String power) {
        iphone.setPower(power);
    }

    @Override
    public IPhone makeIphone() {
        return iphone;
    }
}
