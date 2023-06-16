package revision.dynamicprogramming;

public class MaximumSumSubMatrix {
    public static void main(String[] args) {
        System.out.print(maximumSumSubMatrix(new int[][]{{1,2,-1,-4,-20},{-8,-3,4,-2,1},{3,8,9,1,3},{-4,-1,1,7,-6},{-2,-3,8,1,-1}}));
    }

    private static int maximumSumSubMatrix(int[][] matrix) {
        int[] arr = new int[matrix.length];
        int m = matrix.length, n = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (i == j) {
                        arr[k] = matrix[k][j];
                    } else {
                        arr[k] += matrix[k][j];
                    }
                }
                maxSum = Math.max(maxSum, kadanes(arr));
            }
        }

        return maxSum;
    }

    private static int kadanes(int[] arr) {
        int max = arr[0], currSum = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }
}
