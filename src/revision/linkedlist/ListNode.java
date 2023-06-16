package revision.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void display(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
    }
}
