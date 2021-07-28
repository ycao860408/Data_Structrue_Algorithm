package OOD.principle.LisKovSubstitution;

import java.util.Map;

public class Son extends Base {
    private Father father = new Father();
    public void add(int a, int b) {
        this.father.add(a, b);
    }


}
