package revisionback.bitmanipulation;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    private static int majorityElement(int[] nums) {
        int n = nums.length;
        int majority_element = 0;

        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;

            // Count how many numbers have this bit set.
            int bit_count = 0;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    bit_count++;
                }
            }

            // If this bit is present in more than n / 2 elements
            // then it must be set in the majority element.
            if (bit_count > n / 2) {
                majority_element |= bit;
            }
        }

        return majority_element;
    }
}
