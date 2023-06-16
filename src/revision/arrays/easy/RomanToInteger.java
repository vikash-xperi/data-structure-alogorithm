package revision.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(romanToInteger("MCMXCIV"));
    }

    private static int romanToInteger(String roman) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        for (int i = 0; i < roman.length(); ++i) {
            if (i != roman.length() - 1 && ((roman.charAt(i) == 'I' && (roman.charAt(i + 1) == 'V' || roman.charAt(i + 1) == 'X')) ||
                    (roman.charAt(i) == 'X' && (roman.charAt(i + 1) == 'L' || roman.charAt(i + 1) == 'C')) ||
                    (roman.charAt(i) == 'C' && (roman.charAt(i + 1) == 'M' || roman.charAt(i + 1) == 'D')))) {
                ans += map.get(roman.charAt(i + 1)) - map.get(roman.charAt(i));
                i++;
                continue;
            }
            ans += map.get(roman.charAt(i));
        }
        return ans;
    }



}
