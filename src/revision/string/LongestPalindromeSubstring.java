package revision.string;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        System.out.print(longestPalidrome("babad"));
    }

    private static String longestPalidrome(String s) {
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
