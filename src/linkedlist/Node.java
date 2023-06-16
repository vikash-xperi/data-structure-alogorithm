package linkedlist;

public class Node {
    int data;
    Node next;

    Node (int data) {
        this.data = data;
        this.next = null;
    }
    Node() {}
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}
