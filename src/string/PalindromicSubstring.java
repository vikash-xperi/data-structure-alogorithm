package string;

public class PalindromicSubstring {
    public static void main(String[] args) {
        solution("aaaa");
    }

    public static void solution(String str) {

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                if (isPalindrome(str, i, j)) {
                    System.out.println(str.substring(i, j + 1));
                }
            }
        }
    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
