package revisionback.array;

public class RemoveDuplicatesInSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 1, 1}));
    }

    private static int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        boolean flag = false;
        if (nums.length == 1) return 1;
        while (i < nums.length && j < nums.length) {
            while (j < nums.length && nums[i] == nums[j]) {
                flag = true;
                j++;
            }
            if (flag && i + 1 < nums.length && j < nums.length)   nums[++i] = nums[j++];
        }
        return i + 1;
    }
}
