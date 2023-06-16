package backtracking;

public class PrintIncreasing {
    public static void main(String[] args) {
        printIncreasing(5);
    }

    private static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n - 1);
        System.out.println(n);
    }
}
