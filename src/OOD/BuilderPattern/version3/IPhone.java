package OOD.BuilderPattern.version3;

public class IPhone {
    private String screen;
    private String earphone;
    private String power;

    public IPhone(IPhoneBuilder iPb) {
        this.screen = iPb.screen;
        this.earphone = iPb.earphone;
        this.power = iPb.power;
    }

    @Override
    public String toString() {
        return "IPhone{" +
                "screen='" + screen + '\'' +
                ", earphone='" + earphone + '\'' +
                ", power='" + power + '\'' +
                '}';
    }

    public static class IPhoneBuilder {
        private String screen;
        private String earphone;
        private String power;

        public IPhoneBuilder builderScreen(String screen) {
            this.screen = screen;
            return this;
        }

        public IPhoneBuilder builderEarphone(String earphone) {
            this.earphone = earphone;
            return this;
        }

        public IPhoneBuilder builderPower(String power) {
            this.power = power;
            return this;
        }

        public IPhone build() {
            return new IPhone(this);
        }
    }

}
