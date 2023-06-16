package string;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compression2("wwwwaaadexxxxxx"));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder("");
        if (str.length() == 1) {
            return str;
        }

        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            int j = i;
            while (j + 1 < str.length() && str.charAt(j) == str.charAt(j + 1)) {
                count++;
                j++;
            }
            i = j;
            sb.append(str.charAt(i));
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }

    private static String compression2(String str) {
        StringBuilder sb = new StringBuilder("");
        if (str.length() == 1) {
            return str;
        }

        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            int j = i;
            while (j + 1 < str.length() && str.charAt(j) == str.charAt(j + 1)) {
                count++;
                j++;
            }
            i = j;
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
