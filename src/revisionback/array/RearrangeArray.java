package revisionback.array;

import java.util.Arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] nums = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
                11, 10, 9, 5, 13, 16, 2, 14, 17, 4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
    }

    private static int[] rearrangeArray(int[] arr) {
        int i = 0;
        while (i < arr.length && i != arr[i] && arr[i] != -1) {
            int j = arr[i];
            while (j != arr[j] && i != j && j != -1) {
                int tmp = arr[j];
                arr[j] = j;
                j = tmp;
            }
            if (j != -1 && j != arr[j]) {
                arr[j] = 0;
            }
            i++;
        }
        i = 0;
        while (i < arr.length) {
            if (arr[i] != i) {
                arr[i] = -1;
            }
        }
        return arr;
    }
}
