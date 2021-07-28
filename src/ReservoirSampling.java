import java.util.Random;

public class ReservoirSampling {

    public int[] reservoirSampling(int[] stream, int k) {
        Random rmd = new Random();
        int[] res = new int[k];
        for (int i = 0; i < k ; i++) {
            res[i] = stream[i];
        }

        for (int i = k; k < stream.length; i++) {
            int random = rmd.nextInt(i + 1);
            if (random < k) {
                res[random] = stream[i];
            }
        }
        return res;
    }
}
