package revision.arrays.medium;

import java.util.*;

public class ReduceArraySizeToHalf {
    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }

    private static int minSetSize(int[] nums) {
        int ans = 0, halfSize = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        pq.addAll(map.entrySet());

        while (!pq.isEmpty()){
            if (halfSize <= 0) {
                break;
            }
            halfSize -= pq.poll().getValue();
            ans++;
        }
        return ans;
    }
}
