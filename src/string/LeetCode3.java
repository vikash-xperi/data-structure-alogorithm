package string;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3 {
    public static void main(String[] args) {
        String s = "bbbbb";
        LeetCode3 lc = new LeetCode3();
        System.out.println(lc.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 1, count = 1, leftIndex = 0;
        map.put(s.charAt(0), 0);

        for (int i = 1; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= leftIndex) {
                count = i - map.get(s.charAt(i));
                leftIndex = map.get(s.charAt(i)) + 1;
            } else {
                count++;
            }
            map.put(s.charAt(i), i);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
