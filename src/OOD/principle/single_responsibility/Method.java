package OOD.principle.single_responsibility;

public class Method {
    /*public void buyPhoneAndCharger(String iphone,  String charger) {
        System.out.println("Buy iphone and charger");
    } */// this is coupled version, which is not a good choice!

    public void buyPhone(String iphone) {
        System.out.println("Buy Iphone");
    }

    public void buyCharger(String charger) {
        System.out.println("Buy charger");
    }
}
