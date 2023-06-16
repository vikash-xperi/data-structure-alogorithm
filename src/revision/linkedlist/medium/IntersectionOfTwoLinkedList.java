package revision.linkedlist.medium;

import revision.linkedlist.ListNode;

public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);

        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node6.next = node7;
        node7.next = node8;
        node8.next = node3;

        ListNode.display(getIntersectionNode(node1, node6));
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int count = 0;
        while (p != q) {
            if (count > 2) {
                return null;
            }
            if (p.next == null) {
                p = headB;
                count++;
            } else {
                p = p.next;
            }
            if (q.next == null) {
                q = headA;
                count++;
            } else {
                q = q.next;
            }
        }
        return p;
    }
}
