package OOD.principle.open_close;


public class SwitchDiscount extends Switch {
    public SwitchDiscount(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getOriginalPrice() {
        return super.getPrice();
    }
    @Override
    public Double getPrice() {
        return super.getPrice() * 0.7;
    }
}
