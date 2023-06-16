package revision;

import java.util.HashMap;
import java.util.Map;

class DoublyLinkedList {
    int key;
    int val;
    DoublyLinkedList next;
    DoublyLinkedList prev;
    DoublyLinkedList(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
public class LRUCache {
    private int capacity;
    private int currentCapacity = 0;
    private DoublyLinkedList firstNode = new DoublyLinkedList(-1, -1);
    private DoublyLinkedList lastNode = new DoublyLinkedList(-1, -1);
    private Map<Integer, DoublyLinkedList> map = new HashMap<>();

    LRUCache(int capacity) {
        this.capacity = capacity;
        firstNode.next = lastNode;
        lastNode.prev = firstNode;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            arrange(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLinkedList curr = map.get(key);
            curr.val = value;
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.next = lastNode;
            curr.prev = lastNode.prev;
            lastNode.prev.next = curr;
            lastNode.prev = curr;
        } else {
            currentCapacity++;
            if (currentCapacity > capacity) {
                evict();
            }
            DoublyLinkedList curr = new DoublyLinkedList(key, value);
            map.put(key, curr);
            curr.next = lastNode;
            curr.prev = lastNode.prev;
            DoublyLinkedList tmp = lastNode.prev;
            lastNode.prev = curr;
            tmp.next = curr;
        }
    }

    private void evict() {
        DoublyLinkedList tmp = firstNode.next;
        map.remove(tmp.key);
        firstNode.next = tmp.next;
        tmp.next.prev = firstNode;
        currentCapacity--;
    }

    private void arrange(DoublyLinkedList curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next = lastNode;
        curr.prev = lastNode.prev;
        lastNode.prev.next = curr;
        lastNode.prev = curr;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
        cache.put(1,1);
        cache.put(4,1);
        System.out.println(cache.get(2));
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));
    }
}
