package revisionback.array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    private static int maxArea(int[] heights) {
        int ans = 0;
        if (heights.length == 2) return Math.min(heights[0], heights[1]);
        for (int i = 0, j = heights.length - 1; i < j;) {
            ans = Math.max(ans, (Math.min(heights[i], heights[j]) * (j - i)));
            if (heights[i] <= heights[j]) i++;
            else j--;
        }
        return ans;
    }
}
