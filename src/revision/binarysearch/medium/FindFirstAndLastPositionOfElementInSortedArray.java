package revision.binarysearch.medium;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        System.out.print(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                ans[0] = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        start = 0; end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                ans[1] = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
