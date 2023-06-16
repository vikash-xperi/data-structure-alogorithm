package revisionback.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j + 1 < k && nums[j] == nums[j + 1]) j++;
                    while (k - 1 > j && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}
