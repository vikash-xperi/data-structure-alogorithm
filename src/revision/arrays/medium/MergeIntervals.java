package revision.arrays.medium;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{2,6},{1,3},{8,10},{15,18}})));
    }

    private static int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(x -> x.get(0)));
        queue.addAll(Arrays.stream(intervals).map(x -> Arrays.asList(x[0], x[1])).collect(Collectors.toList()));

        while (!queue.isEmpty()) {
            int first = queue.peek().get(0);
            int second = queue.peek().get(1);
            queue.poll();
            while (!queue.isEmpty() && second >= queue.peek().get(0)) {
                if (second <= queue.peek().get(1))
                    second = queue.poll().get(1);
                else
                    queue.poll();
            }
            ans.add(Arrays.asList(first, second));
        }

        return ans.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}
