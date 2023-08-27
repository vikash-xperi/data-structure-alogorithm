package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MazePath {
    public static void main(String[] args) {
        System.out.println(getMazePath(3, 3, 0, 0));
    }

    private static List<String> getMazePath(int R, int C, int row, int col) {
        if (row == R - 1 && col == C - 1) return Collections.singletonList("");
        if (row >= R || col >= C) return new ArrayList<>();
        List<String> mazePath = getMazePath(R, C, row, col + 1);
        List<String> mazePath1 = getMazePath(R, C, row + 1, col);
        List<String> res = new ArrayList<>();
        for (String s : mazePath) {
            res.add("h" + s);
        }
        for (String s : mazePath1) {
            res.add("v" + s);
        }
        return res;
    }
}
