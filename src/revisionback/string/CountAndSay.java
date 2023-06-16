package revisionback.string;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        StringBuilder sb = new StringBuilder();
        String s = "11";
        for (int i = 3; i <= n; ++i) {
            for (int j = 0; j < s.length();) {
                int count = 1;
                while (j < s.length() - 1 && s.charAt(j) == s.charAt(++j)) {
                    count++;
                }
                sb.append(count).append(s.charAt(j - 1));
                j++;
            }
            s = sb.toString();
            sb.delete(0, sb.length());
        }
        return s;
    }
}
