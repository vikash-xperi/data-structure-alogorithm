package revision.binarysearch.medium;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3}, 1));
    }

    private static int search(int[] nums, int target) {
        int pivotIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivotIndex = i + 1;
            }
        }
        if (pivotIndex == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if (target < nums[0]) {
            return binarySearch(nums, pivotIndex, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, pivotIndex - 1, target);
        }
    }

    private static int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
