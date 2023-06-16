package revision.arrays.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicatesFromSortedArray(nums));
        System.out.println(Arrays.toString(nums));
    }

    private static int removeDuplicatesFromSortedArray(int[] nums) {
        int i = 0, j = 1;
        if (nums.length == 1) {
            return 1;
        }
        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else if (j > i) {
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
        }

        return i + 1;
    }
}
