package thoughtworks;

import java.util.HashMap;
import java.util.Map;

public class Question1 {
    public static void main(String[] args) {

    }
    public static Map<Character, Integer> countCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
            else {
                map.put(ch, 1);
            }
        }
        return map;
    }
}
