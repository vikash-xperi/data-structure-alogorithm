package string;

public class LeetCode5 {
    public static void main(String[] args) {
        String str = "";
        LeetCode5 lc = new LeetCode5();
        System.out.println(lc.longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String ans = "";
        int lastIndex = 0;
        boolean flag = false;

        for (int i = 0; i < s.length() - 1; ++i) {
            for (int j = i + 1; j < s.length(); ++j) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    lastIndex = j;
                    flag = true;
                }
            }
            if (flag && ans.length() < lastIndex - i + 1) {
                sb.append(s, i, lastIndex + 1);
                ans = sb.toString();
                sb.delete(0, sb.length());
            }
        }
        if (ans.length() == 0) {
            ans = s.charAt(0) + "";
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
