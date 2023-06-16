package revision.linkedlist.easy;

import revision.linkedlist.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(8);

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;

        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode.display(mergeTwoLists(node1, node4));
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode p = head, q = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                ListNode node = new ListNode(list1.val);
                p.next = node;
                list1 = list1.next;
            } else {
                ListNode node = new ListNode(list2.val);
                p.next = node;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            while (list1 != null) {
                ListNode node = new ListNode(list1.val);
                p.next = node;
                list1 = list1.next;
                p = p.next;
            }
        } else if (list2 != null) {
            while (list2 != null) {
                ListNode node = new ListNode(list2.val);
                p.next = node;
                list2 = list2.next;
                p = p.next;
            }
        }
        return head.next;
    }
}
