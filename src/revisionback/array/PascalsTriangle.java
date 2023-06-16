package revisionback.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans  = new ArrayList<>();
        ans.add(Arrays.asList(1));
        if (numRows == 1) return ans;
        ans.add(Arrays.asList(1, 1));
        if (numRows == 2) return ans;

        for (int i = 3; i <= numRows; ++i) {
            List<Integer> tmp = new ArrayList();
            tmp.add(1);
            for (int j = 1; j < i - 1; ++j) {
                tmp.add(ans.get(i - 2).get(j) + ans.get(i - 2).get(j - 1));
            }
            tmp.add(1);
            ans.add(tmp);
        }
        return ans;
    }
}
