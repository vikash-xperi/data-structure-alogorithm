package recursion;

import java.util.*;

public class KeypadCombination {
    private static final Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        System.out.println(getKeyPadCombination("573"));
    }

    private static List<String> getKeyPadCombination(String s) {
        if (s.length() == 0) return Collections.singletonList("");
        List<String> strings = getKeyPadCombination(s.substring(1));
        List<String> res = new ArrayList<>();
        for (String str : strings) {
            String s1 = map.get(Integer.parseInt(String.valueOf(s.charAt(0))));
            for (char ch : s1.toCharArray()) {
                res.add(ch + str);
            }
        }
        return res;
    }
}
