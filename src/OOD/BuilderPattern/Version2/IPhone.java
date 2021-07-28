package OOD.BuilderPattern.Version2;

public class IPhone {
    private String screen;
    private String earphone;
    private String power;

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getEarphone() {
        return earphone;
    }

    public void setEarphone(String earphone) {
        this.earphone = earphone;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "IPhone{" +
                "screen='" + screen + '\'' +
                ", earphone='" + earphone + '\'' +
                ", power='" + power + '\'' +
                '}';
    }
}
