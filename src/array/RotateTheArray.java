package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotateTheArray {
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nd = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nd[0]);
            int d = Integer.parseInt(nd[1]);
            String[] stringArray = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = Integer.parseInt(stringArray[i]);
            }
            reverseArray(arr, 0, d - 1);
            reverseArray(arr, d, n - 1);
            reverseArray(arr, 0, n - 1);

            for (int i = 0; i < n; ++i) {
                System.out.print(arr[i]);
                if (i != n -1) {
                    System.out.print(" ");
                }
            }
            if (t != 0) {
                System.out.println();
            }
        }
    }

    public static void reverseArray(int[] arr, int low, int high) {
        while (low < high) {
            int tmp = arr[low];
            arr[low] = arr[high];
            arr[high] = tmp;
            low++;
            high--;
        }
    }
}
