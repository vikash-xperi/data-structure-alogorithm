package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintSubsequence {
    public static void main(String[] args) {
        System.out.println(printSsq("abc"));
    }

    private static List<String> printSsq(String s) {
        if (s.length() == 0) return Collections.singletonList("");
        List<String> ros = printSsq(s.substring(1));
        List<String> res = new ArrayList<>();
        for (String str : ros) {
            res.add(str);
            res.add(s.charAt(0) + str);
        }
        return res;
    }
}
