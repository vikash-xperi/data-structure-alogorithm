package array;

public class DivisorXPower2 {
    public static void main(String[] args) {
        System.out.println(solve(3));
    }
    public static int solve(int n) {
        return (int)(Math.log(n)/Math.log(2)) + 1;
    }
}
