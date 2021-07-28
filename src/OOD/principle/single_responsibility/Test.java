package OOD.principle.single_responsibility;

public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.operatingSystem("HuaWei");
        IOSPhone iosPhone = new IOSPhone();
        iosPhone.operatingSystem("Apple");
    }
}
