package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbingStairs(5));
    }

    private static List<String> climbingStairs(int n) {
        if (n == 0) return Collections.singletonList("");
        if (n < 0) return new ArrayList<>();
        List<String> stringList = climbingStairs(n - 1);
        List<String> stringList1 = climbingStairs(n - 2);
        List<String> stringList2 = climbingStairs(n - 3);
        List<String> res = new ArrayList<>();
        for (String str : stringList) {
                res.add(1 + str);
        }
        for (String str : stringList1) {
            res.add(2 + str);
        }
        for (String str : stringList2) {
            res.add(3 + str);
        }
        return res;
    }
}
