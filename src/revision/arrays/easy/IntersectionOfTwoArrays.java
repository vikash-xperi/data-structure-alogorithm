package revision.arrays.easy;

import java.util.*;

public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1}, new int[]{2,2})));
    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; ++i) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; ++i) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int freq = Math.min(entry.getValue(), map2.get(entry.getKey()));
                while (freq-- != 0) {
                    list.add(entry.getKey());
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
