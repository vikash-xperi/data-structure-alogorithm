package revision.arrays.medium;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] str = s.toCharArray();
            Arrays.sort(str);
            List<String> list = new ArrayList<>();
            if (map.containsKey(String.valueOf(str))) {
                list = map.get(String.valueOf(str));
            }
            list.add(s);
            map.put(String.valueOf(str), list);
        }
        return new ArrayList<>(map.values());
    }
}
