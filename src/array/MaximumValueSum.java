package array;

/**
 * Given an array, only rotation operation is allowed on array. We can rotate the array as many times as we want.
 * Return the maximum possible of summation of i*arr[i].
 *
 * Examples :
 * Input: arr[] = {1, 20, 2, 10}
 * Output: 72
 * We can 72 by rotating array twice.
 * {2, 10, 1, 20}
 * 20*3 + 1*2 + 10*1 + 2*0 = 72
 *
 * Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
 * Output: 330
 * We can 330 by rotating array 9 times.
 * {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
 * 0*1 + 1*2 + 2*3 ... 9*10 = 330
 */
public class MaximumValueSum {
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(maximumValueSum(arr, arr.length));
    }
    public static int maximumValueSum(int[] arr, int n) {
        int arrSum = 0, currVal = 0, maxVal = 0;
        for (int i = 0; i < n; ++i) {
            arrSum += arr[i];
            currVal += i * arr[i];
        }
        for (int i = 1; i < n; ++ i) {
            currVal += arrSum - n * arr[n - i];
            if (maxVal < currVal) {
                maxVal = currVal;
            }
        }
        return maxVal;
    }
}
