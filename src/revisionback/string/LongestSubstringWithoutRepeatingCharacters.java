package revisionback.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int ans = 1;
        if (s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length() && j < s.length(); ) {
            int count = 1;
            map.put(s.charAt(i), i);
            j = i + 1;
            for (; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = map.get(s.charAt(j));
                    ans = Math.max(ans, count);
                    map.clear();
                    if (j == s.length() - 1) return ans;
                    break;
                } else {
                    map.put(s.charAt(j), j);
                    count++;
                }
            }
            ans = Math.max(ans, count);
            i++;
        }
        return ans;
    }
}
