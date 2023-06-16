package revisionback.binaryorder;

public class ConvertArrayToBST {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        sortedArrayToBST(nums).preOrder();

    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 1) return new TreeNode(nums[0]);
        return appendNode(nums, 0, n - 1);
    }

    private static TreeNode appendNode(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = appendNode(nums, start, mid - 1);
        root.right = appendNode(nums, mid + 1, end);
        return root;
    }
}
