package array;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int i = 0, j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else if (j > i) {
                nums[i + 1] = nums[j];
                j++;
                i++;
            }
        }
        return i + 1;
    }
}
