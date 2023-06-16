package array;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
    public static void main(String[] args) {
        System.out.println(romanToInt("DCXXI"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        populateMap(map);
        int value = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (i < s.length() - 1 &&
                    (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')
                    || s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')
                    || s.charAt(i) == 'C' && (s.charAt(i  + 1) == 'D' || s.charAt(i + 1) == 'M'))) {

                value += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                ++i;
                continue;
            }
            value += map.get(s.charAt(i));
        }
        return value;
    }

    public static void populateMap(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}
