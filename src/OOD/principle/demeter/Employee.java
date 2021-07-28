package OOD.principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    public void count(int n) {
        List<Switch> switches = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            switches.add(new Switch());
        }
        System.out.println("The number of switches: " + switches.size());
    }
}
