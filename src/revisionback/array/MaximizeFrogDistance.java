package revisionback.array;

public class MaximizeFrogDistance {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,5,5,2,6}));
    }

    private static int solution(int[] blocks) {
        int i = 0;
        int n = blocks.length;
        int ans = -1;
        while (i < n) {
            int j = i;
            int k = i;
            while (j + 1 < n) {
                if (blocks[j] <= blocks[j + 1]) {
                    j++;
                } else break;
            }
            while (k - 1 >= 0) {
                if (blocks[k] <= blocks[k - 1]) {
                    k--;
                } else break;
            }
            ans = Math.max(j - k, ans);
            i++;
        }
        return ans + 1;
    }
}
