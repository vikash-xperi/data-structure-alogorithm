package array;

public class LeaderNumber {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        printLeader(arr);
    }
    public static void printLeader(int[] arr) {
        int maxFromRight = arr[arr.length - 1];
        for (int i = arr.length - 1; i >=0; --i) {
            if (maxFromRight < arr[i]) {
                maxFromRight = arr[i];
                System.out.println(maxFromRight);
            }
        }
    }
}
