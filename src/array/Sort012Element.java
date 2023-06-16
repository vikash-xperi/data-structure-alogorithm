package array;

import java.util.Arrays;

public class Sort012Element {
    public static void main(String[] args) {
        int[] arr = {2,2,1,0,1,1,0};
        solve(arr);
    }

    private static void solve(int[] arr) {
        int[] index = new int[3];
        Arrays.stream(arr).forEach(x -> index[x]++);
        int fromIndex = 0, lastIndex = 0;
        for (int i = 0; i < index.length; ++i) {
            lastIndex = fromIndex + index[i] - 1;
            Arrays.fill(arr, fromIndex, lastIndex + 1, i);
            fromIndex = lastIndex + 1;
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
