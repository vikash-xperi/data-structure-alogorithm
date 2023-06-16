package revisionback.array;

import java.util.*;

class MyComparator implements Comparator<Map.Entry<Integer, Integer>> {

    @Override
    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        int a = o2.getValue() - o1.getValue();
        if (a == 0) {
            return o1.getKey() - o2.getKey();
        }
        return a;
    }
}
public class TopKMostFrequentElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,4,4,3,3}, 2)));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new MyComparator());
        pq.addAll(map.entrySet());
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
