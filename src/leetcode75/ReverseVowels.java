package leetcode75;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("Sore was I ere I saw Eros."));
    }

    public static String reverseVowels(String s) {
        Set<Character> set = hydrateSet();
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j;) {
            if (!set.contains(arr[i]) && !set.contains(arr[j])) {
                i++;
                j--;
            } else if (set.contains(arr[i]) && set.contains(arr[j])) {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            } else if (set.contains(arr[i])) {
                j--;
            } else if (set.contains(arr[j])) {
                i++;
            }
        }
        return String.valueOf(arr);
    }

    public static Set<Character> hydrateSet() {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        return set;
    }
}
