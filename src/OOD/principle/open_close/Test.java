package OOD.principle.open_close;

public class Test {
    public static void main(String[] args) {
        IGoods aSwitch = new Switch(5200, "Xiao Ba Wang", 399.0);
        //System.out.println("ID : " + aSwitch.getId() + ", Name : " + aSwitch.getName() + ", Price : " + aSwitch.getDiscount());
        //System.out.println("ID : " + aSwitch.getId() + ", Name : " + aSwitch.getName() + ", Price : " + aSwitch.getPrice());
        IGoods aSwitch2 = new SwitchDiscount(5200, "Xiao Ba Wang", 399.0);
        SwitchDiscount newSwitch = (SwitchDiscount) aSwitch2;
        System.out.println("ID : " + newSwitch.getId() + ", Name : " + newSwitch.getName() + ", Original Price : " + newSwitch.getOriginalPrice() + ", Price : " + newSwitch.getPrice());

    }
}
