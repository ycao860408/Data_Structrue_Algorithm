import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickIndex {
    int[] nums;
    Random rmd;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rmd = new Random();
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        return list.get(rmd.nextInt(list.size()));
    }

    public int pick2(int target) {
        int count = 0;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (rmd.nextInt(count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
