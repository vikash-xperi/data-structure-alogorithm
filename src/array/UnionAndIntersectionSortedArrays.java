package array;

import java.util.ArrayList;
import java.util.List;

public class UnionAndIntersectionSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,4,7,10,12,15,16,18,20,22};
        int[] arr2 = {1,3,5,8,9,10,12,15};
        solve(arr1, arr2);
    }

    private static void solve(int[] arr1, int[] arr2) {
        List<Integer> union = new ArrayList<>();
        List<Integer> intersection = new ArrayList<>();
        for (int i = 0, j = 0; i < arr1.length && j < arr2.length;) {
            if (arr1[i] < arr2[j]) {
                union.add(arr1[i]);
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                union.add(arr2[j]);
                j++;
            }
            else {
                union.add(arr1[i]);
                intersection.add(arr1[i]);
                i++;
                j++;
            }
            if (i == arr1.length - 1 && j < arr2.length) {
                while (j < arr2.length) {
                    union.add(arr2[j]);
                    j++;
                }
            }
            if (j == arr2.length - 1 && i < arr1.length) {
                while (i < arr1.length) {
                    union.add(arr1[i]);
                    i++;
                }
            }
        }
        System.out.println("Union:");
        union.forEach(x -> System.out.print(x + " "));
        System.out.println("\nIntersection:");
        intersection.forEach(x -> System.out.print(x + " "));
    }
}
