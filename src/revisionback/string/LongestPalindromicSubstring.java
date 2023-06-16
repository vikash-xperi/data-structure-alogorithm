package revisionback.string;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    private static String longestPalindrome(String s) {
        String res = "";

        for (int i = 0; i < s.length(); ++i) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > res.length()) {
                    res = s.substring(l, r + 1);
                }
                l -= 1;
                r += 1;
            }
            l = i; r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > res.length()) {
                    res = s.substring(l, r + 1);
                }
                l -= 1;
                r += 1;
            }
        }
        return res;
    }
}
