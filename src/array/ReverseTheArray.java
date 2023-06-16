package array;

import java.util.Arrays;

/**
 * Given an array (or string), the task is to reverse the array/string.
 * Examples :
 *
 *
 * Input  : arr[] = {1, 2, 3}
 * Output : arr[] = {3, 2, 1}
 *
 * Input :  arr[] = {4, 5, 1, 2}
 * Output : arr[] = {2, 1, 5, 4}
 */

public class ReverseTheArray {

    public static void main(String[] args) {
        int [] arr = {1, 2, 3};
        arr = reverse(arr);
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i]);
    }

    private static int[] reverse(int[] arr) {
        int end = arr.length - 1;
        int start = 0;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
