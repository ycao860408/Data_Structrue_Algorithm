package SystemDesign.ConsistentHashing;

import java.util.Random;

public class IPAddressGenerate {
    public String[] getIPAddress(int num) {
        String[] res = new String[num];
        Random rdm = new Random();
        for (int i = 0; i < num; i++) {
            res[i] = rdm.nextInt(256) + "." + rdm.nextInt(256) + "." + rdm.nextInt(256) + "."
                    + rdm.nextInt(256) + ":" + rdm.nextInt(9999);
        }
        return res;
    }
}
