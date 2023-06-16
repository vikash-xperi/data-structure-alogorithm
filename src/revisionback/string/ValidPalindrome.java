package revisionback.string;

import java.util.Locale;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    private static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                sb.append(s.charAt(i));
            } else if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                sb.append((char)(s.charAt(i) + 32));
            } else if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                sb.append(s.charAt(i));
            }
        }
        int start = 0, end = sb.length() - 1;
        while (start <= end) {
            if (sb.charAt(start) != sb.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
