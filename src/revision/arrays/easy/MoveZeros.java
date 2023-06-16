package revision.arrays.easy;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeroes(int[] nums) {
        int countZero = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                countZero++;
            } else {
                nums[i - countZero] = nums[i];
            }
        }

        if (countZero != 0 && nums.length != countZero) {
            for (int i = nums.length - countZero; i < nums.length; ++i) {
                nums[i] = 0;
            }
        }
    }
}
