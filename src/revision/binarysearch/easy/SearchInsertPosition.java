package revision.binarysearch.easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,7,9,10,15,16,18,20}, 19));
    }

    private static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
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
        return l;
    }
}
