package revisionback.array;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    private static int search(int[] nums, int target) {
        int pivotIndex = findPivotIndex(nums, 0, nums.length - 1);
        int index = binarySearch(nums, 0, pivotIndex, target);
        if (index != -1) return index;
        return binarySearch(nums, pivotIndex + 1, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int start, int end, int key) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (key == nums[mid]) return mid;
        if (key < nums[mid]) return binarySearch(nums, start, mid - 1, key);
        return binarySearch(nums, mid + 1, end, key);
    }

    private static int findPivotIndex(int[] nums, int start, int end) {
        if (start > end) return -1;
        if (start == end) return start;
        int mid = (start + end) / 2;
        if (mid < end && nums[mid] > nums[mid + 1]) return mid;
        if (mid > start && nums[mid] < nums[mid - 1]) return mid - 1;
        if (nums[start] >= nums[mid]) return findPivotIndex(nums, start, mid - 1);
        return findPivotIndex(nums, mid + 1, end);
    }
}
