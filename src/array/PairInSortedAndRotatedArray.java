package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PairInSortedAndRotatedArray {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] stringArray = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = Integer.parseInt(stringArray[i]);
            }
            int key = Integer.parseInt(br.readLine().trim());
            System.out.print(findPair(arr, n, key));
            if (t != 0) {
                System.out.println();
            }
        }
    }

    public static boolean findPair(int[] arr, int n, int x) {
        int pivotIndex = findPivot(arr, 0, n - 1);

        for (int i = pivotIndex + 1, j = pivotIndex; i != j; ) {
            if (arr[i] + arr[j] == x) {
                return true;
            }
            else if (arr[i] + arr[j] > x) {
                j--;
                if (j < 0) {
                    j = n - 1;
                }
            }
            else if (arr[i] + arr[j] < x) {
                i++;
                if (i > n - 1) {
                    i = 0;
                }
            }
        }
        return false;
    }

    public static int findPivot(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        if (low == high) {
            return low;
        }
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > low && arr[mid] < arr[mid - 1]) {
            return mid - 1;
        }
        if (arr[low] >= arr[mid]) {
            return findPivot(arr, low, mid - 1);
        }
        return findPivot(arr, mid + 1, high);
    }
}
