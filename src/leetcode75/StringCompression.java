package leetcode75;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','a','b','b','a','a'}));
    }

    public static int compress(char[] chars) {
        int j = 0, count = 1;

        for(int i = 1; i < chars.length + 1; ++i) {
            if(i == chars.length || chars[i] != chars[i - 1]) {
                chars[j++] = chars[i - 1];

                if(count > 1) {
                    String s = count + "";

                    for(int k = 0; k < s.length(); ++k)
                        chars[j++] = s.charAt(k);
                }

                count = 1;
            } else {
                count++;
            }
        }

        return j;
    }
}
