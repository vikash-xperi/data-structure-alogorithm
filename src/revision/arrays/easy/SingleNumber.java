package revision.arrays.easy;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
    }

    private static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            ans ^= nums[i];
        }
        return ans;
    }
}
