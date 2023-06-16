package array;

import java.util.Arrays;

public class MoveNegativeToOneSide {
    public static void main(String[] args) {
        int[] arr = {0,1,5,-4,6,-2,-1,2,-5};
        solve(arr);
    }

    private static void solve(int[] arr) {

        for (int i = 0, j = 0; i < arr.length; ++i) {
            if (arr[i] < 0) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
