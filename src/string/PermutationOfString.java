package string;

public class PermutationOfString {
    public static void main(String[] args) {
        printPermutation("abcd");
    }

    public static void printPermutation(String str) {
        int totalPermutation = factorial(str.length());

        for (int i = 0; i < totalPermutation; ++i) {
            StringBuilder stringBuilder = new StringBuilder(str);
            StringBuilder sb = new StringBuilder("");
            for (int j = str.length(), q = i; j > 0; --j) {
                int r = q % j;
                q = q / j;
                sb.append(stringBuilder.charAt(r));
                stringBuilder.deleteCharAt(r);
            }
            System.out.println(sb);
        }
    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }

}
