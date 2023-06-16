package revision.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2}, 0));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1, r = n - 1;
                int sum = target - nums[i] - nums[j];
                while (l < r) {
                    int tmp = nums[l] + nums[r];
                    if (tmp < sum) l++;
                    else if (tmp > sum) r--;
                    else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l + 1 < r && nums[l] == nums[l + 1]) l++;
                        while (r - 1 < l && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
