package sixtydayschallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Pair {
    int val;
    int idx;

    Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,4,6,1,3,5}, 7)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            pairs.add(new Pair(nums[i], i));
        }
        Collections.sort(pairs, Comparator.comparing(p -> p.val));
        for (int i = 0, j = pairs.size() - 1; i < j; ) {
            int sum = pairs.get(i).val + pairs.get(j).val;
            if (sum < target) i++;
            else if (sum > target) j--;
            else {
                ans[0] = i;
                ans[1] = j;
                break;
            }
        }
        return ans;
    }
}
