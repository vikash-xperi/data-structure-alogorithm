package revision.binarysearch.medium;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.print(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }

    private static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
