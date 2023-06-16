package revisionback.dp;

public class MaximumSumSubMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,-1,-4,-20},
                {-8,-3,4,-2,1},
                {3,8,9,1,3},
                {-4,-1,1,7,6},
                {-2,3,8,1,1}
        };
        System.out.println(maxSumSubMatrix(matrix));
    }

    private static int maxSumSubMatrix(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int[] sum = new int[matrix.length];

        return maxSum;
    }
}
