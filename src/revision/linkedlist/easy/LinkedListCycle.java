package revision.linkedlist.easy;

import revision.linkedlist.ListNode;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        System.out.println(hasCycle(node1));
    }

    private static boolean hasCycle(ListNode head) {
        ListNode p = head, q = head;

        while (q != null && q.next !=  null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }
}
