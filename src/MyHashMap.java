public class MyHashMap <K, V>{

    public Entry<K, V>[] hashtable;

    private static final int INITIAL_SIZE = 1 << 4;
    private static final int MAX_CAPACITY = 1 << 30;

    MyHashMap() {
        this.hashtable = new Entry[INITIAL_SIZE];
    }

    MyHashMap(int cap) {
        int n = tableSize(cap);
        this.hashtable = new Entry[n];
    }

    private int tableSize(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n == 0 ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n + 1;
    }

     class Entry<K, V> {
        public K key;
        public V value;
        public Entry next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    boolean put(K key, V value) {
        int hashcode = key.hashCode() % hashtable.length;
        Entry<K, V> node = hashtable[hashcode];
        if (node == null) {
            node = new Entry<>(key, value);
            hashtable[hashcode] = node;
            return true;
        } else {
            if (node.key == key) {
                node.value = value;
                return true;
            } else {
                Entry<K, V> previousNode = node;
                while (node != null) {
                    if (node.key == key) {
                        node.value = value;
                        return true;
                    }
                    previousNode = node;
                    node = node.next;
                }
                previousNode.next = new Entry<>(key, value);
                hashtable[hashcode] = previousNode.next;
                return true;
            }
        }
    }

    V get(K key) {
        int hashcode = key.hashCode() % hashtable.length;
        Entry<K, V> node = hashtable[hashcode];
        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "vikash");
        map.put(2, "kumar");
        map.put(3, "singh");
        map.put(4, "abcd");
        map.put(1, "xyz");
        System.out.println(map.get(1));
    }

}
