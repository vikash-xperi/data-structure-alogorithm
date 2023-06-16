package linkedlist;

public class ImplementStack {
    public static void main(String[] args) {

    }
    public static Node push(int data, Node parent) {
        if (parent == null) {
            parent = new Node(data);
        }
        else
            parent.next = new Node(data);
        return parent.next;
    }
    public static int top(Node head) {
        return head.data;
    }
    public static void pop(Node head) {
        head = head.next;
    }
}
