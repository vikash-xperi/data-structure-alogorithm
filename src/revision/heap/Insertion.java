package revision.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Insertion {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(50);
        int[] arr = new int[]{50, 30, 40, 10, 5, 20, 30, 60, 45};
        for (int i = 1; i < arr.length; i++) {
            insert(list, arr[i]);
        }
        System.out.print("Before delete: " + list);
        delete(list);
        System.out.print("After delete: " + list);
    }

    private static void insert(List<Integer> list, int n) {
        list.add(n);
        int i = list.size() - 1;
        while (i > 1) {
            int parent = i / 2;
            if (list.get(parent) < n) {
                Collections.swap(list, parent, i);
                i = parent;
            } else return;
        }
    }

    private static void delete(List<Integer> list) {
        Collections.swap(list, 1, list.size() - 1);
        list.remove(list.size() - 1);
        int i = 1;
        while (i < list.size()) {
            int larger = list.get(2 * i) > list.get(2 * i + 1) ? 2 * i : 2 * i + 1;
            if (list.get(i) < list.get(larger)) {
                Collections.swap(list, i, larger);
                i = larger;
            } else return;
        }
    }
}
