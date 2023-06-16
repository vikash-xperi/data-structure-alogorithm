package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInSortedAndRotatedArray {

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
            System.out.print(findElement(arr, n, key));
            if (t != 0) {
                System.out.println();
            }
        }
    }

    public static int findElement(int[] arr, int n, int key) {
        int pivotIndex = findPivot(arr, 0, n - 1);
        int index = binarySearch(arr, 0, pivotIndex, key);
        if (index != -1) {
            return index;
        }
        return binarySearch(arr, pivotIndex + 1, n - 1, key);
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

    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (key > arr[mid]) {
            return binarySearch(arr, mid + 1, high, key);
        }
        return binarySearch(arr, low, mid - 1, key);
    }
}
