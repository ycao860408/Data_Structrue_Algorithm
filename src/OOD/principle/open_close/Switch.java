package OOD.principle.open_close;

public class Switch implements IGoods  {
    private Integer id;
    private String name;
    private Double price;

    public Switch(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    /*@Override
    public Double getDiscount() {
        return this.price * .7;
    }*/

    /*@Override
    public String toString() {
        return "Switch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }*/
}
