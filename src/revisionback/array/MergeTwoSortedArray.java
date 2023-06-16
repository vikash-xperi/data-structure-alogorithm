package revisionback.array;

import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1, k = n - 1;
        for (int i = 0; i < m + n; ++i) {
            if (j >= 0 && k >= 0)
                nums1[m + n - 1 - i] = nums1[j] >= nums2[k] ? nums1[j--] : nums2[k--];
            else if (j < 0 && k >= 0) {
                nums1[m + n - 1 - i] = nums2[k--];
            } else if (k < 0 && j >= 0) {
                nums1[m + n - 1 - i] = nums1[j--];
            }
        }
    }
}
