package OOD.principle.demeter;

import java.util.ArrayList;
import java.util.List;

public class Boss {
    public void command(Employee employee, int n) {
        employee.count(n);
    }
}
