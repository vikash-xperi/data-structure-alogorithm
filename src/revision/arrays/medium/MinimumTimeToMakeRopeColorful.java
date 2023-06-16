package revision.arrays.medium;

import java.util.PriorityQueue;

public class MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful obj = new MinimumTimeToMakeRopeColorful();
        System.out.println(minCost("bbbaaa", new int[]{4,9,3,8,8,9}));
    }

    private static int minCost(String colors, int[] neededTime) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        for (int i = 0; i < colors.length();) {
            char ch = colors.charAt(i);
            if (i + 1 < colors.length() && ch == colors.charAt(i + 1)) {
                pq.add(neededTime[i]);
                while (i + 1 < colors.length() && ch == colors.charAt(++i)) {
                    pq.add(neededTime[i]);
                }
            } else i++;

            int s = pq.size();
            while (s-- > 1) {
                res += pq.poll();
            }
            pq.clear();
        }
        return res;
    }
}
