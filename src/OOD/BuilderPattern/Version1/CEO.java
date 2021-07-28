package OOD.BuilderPattern.Version1;

public class CEO {
    private Apple apple;

    public CEO(Apple apple) {
        this.apple = apple;
    }

    public IPhone makeIPhone(String screen, String earphone, String power) {
        this.apple.buildScreen(screen);
        this.apple.buildEarphone(earphone);
        this.apple.buildPower(power);
        return this.apple.makeIphone();
    }
}
