package OOD.BuilderPattern.Version2;

public class CEO {
    private Apple apple;

    public CEO(Apple apple) {
        this.apple = apple;
    }

    public IPhone makeIPhone() {
        this.apple.buildScreen();
        this.apple.buildEarphone();
        this.apple.buildPower();
        return this.apple.makeIphone();
    }
}
