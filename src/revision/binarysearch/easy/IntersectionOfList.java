package revision.binarysearch.easy;

import java.util.*;

public class IntersectionOfList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1}, new int[]{1})));
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> list = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; ++i) {
            if (binarySearch(nums2, nums1[i])) {
                list.add(nums1[i]);
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue).toArray();
    }

    public static boolean binarySearch(int[] arr, int val) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (arr[mid] < val) {
                l = mid + 1;
            } else if (arr[mid] > val) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
