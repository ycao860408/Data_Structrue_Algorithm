import java.util.Random;

public class ArrayShuffle {
    private int[] nums;
    private Random rmd;

    public ArrayShuffle(int nums[]) {
        this.nums = nums;
        this.rmd = new Random();
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        if (this.nums == null) return nums;
        int[] clone = this.nums.clone();
        for (int i = 0; i < this.nums.length; i++) {
            int random = rmd.nextInt(i + 1);
            swap(clone, i, random);
        }
        return clone;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
