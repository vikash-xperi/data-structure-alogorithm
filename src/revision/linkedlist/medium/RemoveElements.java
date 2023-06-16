package revision.linkedlist.medium;

import revision.linkedlist.ListNode;

public class RemoveElements {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode.display(removeElements(node1, 2));
    }

    private static ListNode removeElements(ListNode head, int val) {
        ListNode head1 = null;
        ListNode tmp = head1;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                continue;
            }
            if (tmp == null) {
                tmp = new ListNode(head.val);
                head1 = tmp;
            } else {
                tmp.next = new ListNode(head.val);
                tmp = tmp.next;
            }
            head = head.next;
        }
        return head1.next;
    }
}
