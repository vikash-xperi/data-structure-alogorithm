import java.util.HashMap;
import java.util.Map;

class ListNode {
    int data;
    ListNode next;
    ListNode prev;

    public ListNode(int data) {
        this.data = data;
    }
}
public class LRUCache {
    private static Map<Integer, ListNode> map = new HashMap<>();
    private static ListNode firstNode = new ListNode(-1);
    private static ListNode lastNode = new ListNode(-2);
    private static int capacity = 5;
    private static int currNodeCount = 0;

    public static void main(String[] args) {
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
        add(1);
        System.out.println("Get Method: " + get(1).data);
        add(2);
        add(3);
        System.out.println("Get Method: " + get(2).data);
        printMap();
    }

    public static void printMap() {
        System.out.println("*********");
        ListNode head = firstNode;
        while (head != lastNode) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void add(int data) {
        ListNode node = null;
        if (map.containsKey(data)) {
            node = map.get(data);
        }
        else {
            node = new ListNode(data);
            map.put(data, node);
            currNodeCount++;
        }
        if (currNodeCount > capacity) {
            map.remove(firstNode.next.data);
            ListNode tmp = firstNode.next.next;
            firstNode.next = firstNode.next.next;
            tmp.prev = firstNode;
        }
        ListNode tmp = lastNode.prev;
        lastNode.prev = node;
        node.next = lastNode;
        node.prev = tmp;
        tmp.next = node;
    }

    public static ListNode get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            ListNode tmp = lastNode.prev;
            lastNode.prev = node;
            node.next = lastNode;
            node.prev = tmp;
            tmp.next = node;
            return node;
        }
        return null;
    }
}
