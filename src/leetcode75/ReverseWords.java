package leetcode75;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    private static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> words = Arrays.stream(s.trim().split(" ")).filter((x) -> !x.equals("")).collect(Collectors.toList());
        for (int i = words.size() - 1; i >= 0; --i) {
//            if (words.get(i).equals("")) continue;
            sb.append(words.get(i));
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}
