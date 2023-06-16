package string;

import java.util.Arrays;
import java.util.List;

public class RegularExpression {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a*"));
    }

    private static boolean isMatch(String s, String p) {
        boolean ans = true;
        List<String> strings = normalisePattern(p);
        int j = 0, k = 0;
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).equals("")) {
                while (k < s.length() && strings.get(i - 1).charAt(strings.get(i - 1).length() - 1) == s.charAt(k)) {
                    k++;
                }
                continue;
            }
            j = 0;
            while (j < strings.get(i).length()) {
                if (k < s.length() && (strings.get(i).charAt(j) == '.' || strings.get(i).charAt(j) == s.charAt(k))) {
                    j++;
                    k++;
                } else {
                    return false;
                }
            }
            if (i == strings.size() - 1 && k < s.length()) {
                return false;
            }
            while (k < s.length() && strings.get(i).charAt(strings.get(i).length() - 1) == s.charAt(k)) {
                k++;
            }
        }
        return ans;
    }

    private static List<String> normalisePattern(String p) {
        List<String> split = Arrays.asList(p.split("\\*"));
        for (int i = 1; i < split.size(); i++) {
            if (!split.get(i - 1).equals("") && split.get(i - 1).charAt(split.get(i - 1).length() - 1) == split.get(i).charAt(0)) {
                int j = 0, k = 1;
                while (k < split.get(i).length() && split.get(i).charAt(j) == split.get(i).charAt(k)) {
                    k++;
                }
                if (k == split.get(i).length()) {
                    split.set(i, "");
                } else {
                    split.set(i, split.get(i).substring(k));
                }
            }
        }
        if (p.charAt(p.length() - 1) == '*') {
            split.add("");
        }
        return split;
    }
}
