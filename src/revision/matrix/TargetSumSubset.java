package revision.matrix;

public class TargetSumSubset {
    public static void main(String[] args) {
        System.out.print(targetSumSubset(new int[]{4,2,1,7,3}, 10));
    }

    private static boolean targetSumSubset(int[] nums, int sum) {
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        dp[0][0] = true;
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j == nums[i - 1]) {
                    dp[i][j] = true;
                } else if (j > nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - nums[i - 1]];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[nums.length][sum];
    }
}
