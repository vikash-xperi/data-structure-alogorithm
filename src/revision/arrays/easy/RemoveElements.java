package revision.arrays.easy;

import java.util.Arrays;

public class RemoveElements {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        System.out.println(removeElements(arr, 2));
        System.out.println(Arrays.toString(arr));
    }

    private static int removeElements(int[] nums, int val) {
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            }
            return 1;
        }
        int i = 0, j = 0;
        for (; i < nums.length && j < nums.length; ++j) {
            if (nums[i] == val) {
                while (nums[j] == val) {
                    j++;
                }
                if (j < nums.length) {
                    nums[i] = nums[j];
                    i++;
                }
                continue;
            }
            if (nums[j] == val) {
                continue;
            }
            if (j > i) {
                nums[i] = nums[j];
                i++;
                continue;
            }
            i++;
        }
        return i;
    }
}
