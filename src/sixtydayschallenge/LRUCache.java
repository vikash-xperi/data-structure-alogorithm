package sixtydayschallenge;

import java.util.HashMap;
import java.util.Map;

class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode() {

    }
}

public class LRUCache {

    private final static Map<Integer, ListNode> map = new HashMap<>();
    private final static int MAX_CAPACITY = 3;
    private static int capacity = 0;
    private final static ListNode firstNode = new ListNode();
    private final static ListNode lastNode = new ListNode();

    public static void main(String[] args) {
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
        add(1);
        add(2);
        add(3);
        add(1);
        System.out.println(get(2));
        add(4);
        System.out.println(get(3));
    }

    private static void add(int data) {
        ListNode node = null;
        if (map.containsKey(data)) {
            node = map.get(data);
            deleteNode(node);
        } else {
            node = new ListNode(data);
            map.put(data, node);
            capacity++;
        }
        if (capacity > MAX_CAPACITY) {
            ListNode nodeToBeDeleted = lastNode.prev;
            deleteNode(nodeToBeDeleted);
            map.remove(nodeToBeDeleted.val);
        }
        shiftNodeToFirst(node);
    }

    private static Integer get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            deleteNode(node);
            shiftNodeToFirst(node);
            return node.val;
        }
        return null;
    }

    private static void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static void shiftNodeToFirst(ListNode node) {
        ListNode tmp = firstNode.next;
        firstNode.next = node;
        node.prev = firstNode;
        node.next = tmp;
        tmp.prev = node;
    }

}
