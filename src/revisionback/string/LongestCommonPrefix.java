package revisionback.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"cir", "car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        if (strs.length == 0) return ans;
        if (strs.length == 1) return strs[0];

        for (int i = 0; i < strs[0].length() && i < strs[1].length(); ++i) {
            if (strs[0].charAt(i) == strs[1].charAt(i)) {
                ans += strs[0].charAt(i);
            } else {
                break;
            }
        }

        if (ans.equals("")) return ans;

        for (int i = 2; i < strs.length; ++i) {
            int j = 0;
            while (j < strs[i].length() && j < ans.length() && strs[i].charAt(j) == ans.charAt(j)){
                j++;
            }
            ans = ans.substring(0, j);
        }
        return ans;
    }
}
