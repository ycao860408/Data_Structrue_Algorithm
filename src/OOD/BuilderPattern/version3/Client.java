package OOD.BuilderPattern.version3;

public class Client {
    public static void main(String[] args) {
        IPhone iphone = new IPhone.IPhoneBuilder().builderScreen("IPhone X's screen").builderEarphone("IPhone X's earphone").builderPower("IPhone X's Rechargeable Power").build();
        System.out.println(iphone);
    }
}
