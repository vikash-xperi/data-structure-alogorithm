package string;

import java.util.ArrayList;
import java.util.List;

public class MaximumLengthConcatenatedString {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("un");
        strings.add("iq");
        strings.add("ue");
        System.out.println(maxLength(strings));
    }

    private static int maxLength(List<String> arr) {
        int[] charIndex = new int[26];

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).length(); j++) {
                if (charIndex[arr.get(i).charAt(j) - 'a'] != 0) {
                    if (arr.get(charIndex[arr.get(i).charAt(j) - 'a']).length() < arr.get(i).length()) {
                        for (int k = 0; k < arr.get(charIndex[arr.get(i).charAt(j) - 'a']).length(); k++) {
                            charIndex[arr.get(charIndex[arr.get(i).charAt(j) - 'a']).charAt(k) - 'a'] = 0;
                        }

                    }
                }
            }
        }
        return 0;
    }
}
