package revision.arrays.easy;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,3})));
    }

    private static int[] plusOne(int[] digits) {
        int carry = 0;
        boolean firstIteration = true;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (firstIteration) {
                firstIteration = false;
                if (digits[i] + 1 > 9) {
                    carry = 1;
                    digits[i] = (digits[i] + 1) % 10;
                } else {
                    digits[i] = digits[i] + 1;
                    carry = 0;
                }
                continue;
            }

            if (digits[i] + carry > 9) {
                carry = 1;
                digits[i] = (digits[i] + carry) % 10;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }

        }
        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 1; i < newDigits.length; ++i) {
                newDigits[i] = digits[i - 1];
            }
            return newDigits;
        }
        return digits;
    }
}
