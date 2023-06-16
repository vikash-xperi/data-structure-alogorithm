package array;

public class RemoveElements {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int val = 2;
        System.out.println(removeElement(arr, val));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == val) {
                return 0;
            }
            return 1;
        }

        int i = 0, j = 0;
        for (; i < nums.length && j < nums.length; j++) {
            if (nums[i] == val) {

                //increment j until nums[j] != val
                while (j < nums.length && nums[j] == val) {
                    j++;
                }
                if (j < nums.length) {
                    nums[i] = nums[j];
                    i++;
                }
                continue;
            }
            // to avoid left shift of val
            if (nums[j] == val) {
                continue;
            }

            // once j got increment need to left shift all the remaining element
            if (j > i) {
                nums[i] = nums[j];
                i++;
                continue;
            }
            i++;
        }
        return i;

    }
}
