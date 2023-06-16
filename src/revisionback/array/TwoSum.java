package revisionback.array;

import java.util.*;

class Pair {
    int val;
    int index;

    Pair(int val, int idx) {
        this.val = val;
        this.index = idx;
    }
}

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            pairs.add(new Pair(nums[i], i));
        }

        pairs.sort(Comparator.comparingInt(o -> o.val));

        for (int i = 0, j = nums.length - 1; i < j;) {
            if (pairs.get(i).val + pairs.get(j).val > target) {
                j--;
            } else if (pairs.get(i).val + pairs.get(j).val < target) {
                i++;
            } else {
                ans[0] = pairs.get(i).index;
                ans[1] = pairs.get(j).index;
                break;
            }
        }
        return ans;
    }
}
