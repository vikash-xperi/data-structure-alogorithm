package string;

import java.util.Locale;

public class ToggleCase {
    public static void main(String[] args) {
        System.out.println(solution("pepCODing"));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
                sb.append((str.charAt(i) + "").toLowerCase(Locale.ROOT));
            } else {
                sb.append((str.charAt(i) + "").toUpperCase(Locale.ROOT));
            }
        }

        return sb.toString();
    }
}
