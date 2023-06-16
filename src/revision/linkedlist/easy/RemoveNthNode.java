package revision.linkedlist.easy;

import revision.linkedlist.ListNode;

public class RemoveNthNode {
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
        ListNode.display(removeNthFromEnd(node1, 2));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        if (length == 1 && n == 1) {
            head = null;
            return head;
        }
        if (length == 2) {
            if (n == 1) {
                head.next = null;
            } else if (n == 2) {
                head = head.next;
            }
            return head;
        }
        if (length - n == 0) {
            head = head.next;
            return head;
        }
        p = head;
        while (--length > n) {
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }
}
