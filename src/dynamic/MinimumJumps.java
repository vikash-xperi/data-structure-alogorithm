package dynamic;

import java.util.ArrayList;
import java.util.List;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] dp = new int[arr.length];
        dp[0] = 0;
        list.add(0);

        for (int i = 1; i < arr.length; ++i) {
            int moves = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; --j) {
                if (arr[j] >= i - j) {
                    moves = Math.min(moves, dp[j] + 1);
                }
            }
            dp[i] = moves;
        }
        return dp[arr.length - 1];
    }
}
