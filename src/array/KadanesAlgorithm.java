package array;

import java.util.Arrays;

public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        int max = arr[0], currSum = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }
}
