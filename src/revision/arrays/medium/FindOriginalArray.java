package revision.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOriginalArrays(new int[]{1,3,4,2,6,8})));
    }

    private static int[] findOriginalArrays(int[] changed) {
        if (changed.length % 2 != 0) {
            return new int[0];
        }
        int[] ans = new int[changed.length / 2];

        Arrays.sort(changed);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < changed.length; ++i) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }

        int k = 0;
        for (int i = 0; i < changed.length; ++i) {
            if (map.get(changed[i]) != null && map.get(changed[i]) != 0) {
                if (map.get(changed[i] * 2) != null && map.get(changed[i] * 2) != 0) {
                    if (k < changed.length / 2) {
                        ans[k++] = changed[i];
                        map.put(changed[i], map.get(changed[i]) - 1);
                        map.put(changed[i] * 2, map.get(changed[i] * 2) - 1);
                    } else {
                        return new int[0];
                    }
                } else {
                    return new int[0];
                }
            }
        }

        if (k == changed.length / 2) return ans;
        return new int[0];
    }
}
