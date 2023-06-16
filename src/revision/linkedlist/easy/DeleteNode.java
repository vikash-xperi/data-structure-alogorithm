package revision.linkedlist.easy;

import revision.linkedlist.ListNode;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNode(node2);
        ListNode.display(node1);
    }

    private static void deleteNode(ListNode node) {
        ListNode head = node, p = null;
        while (head.next != null) {
            if (head.next.next == null) {
                p = head;
            }
            head.val = head.next.val;
            head = head.next;
        }
        p.next = null;
    }
}
