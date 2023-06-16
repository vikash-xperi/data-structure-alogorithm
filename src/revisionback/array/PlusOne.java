package revisionback.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9})));
    }

    private static int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (i == digits.length - 1) {
                int tmp = digits[i] + 1;
                if (tmp > 9) {
                    carry = 1;
                    list.add(tmp % 10);
                } else {
                    list.add(tmp);
                    carry = 0;
                }
            } else {
                int tmp = digits[i] + carry;
                if (tmp > 9) {
                    carry = 1;
                    list.add(tmp % 10);
                } else {
                    list.add(tmp);
                    carry = 0;
                }
            }
        }
        if (carry == 1) list.add(1);

        int[] ans = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; --i) {
            ans[i] = list.get(list.size() - 1 - i);
        }
        return ans;
    }
}
