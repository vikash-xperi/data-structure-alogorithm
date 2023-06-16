package revisionback.linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode head2 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        head2.next = node7;
        node7.next = node8;
        node8.next = node9;
        ListNode listNode = addTwoNumbers(head1, head2);
        listNode.display();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode head = new ListNode();
        ListNode p = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + carry;
            if (tmp > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode((tmp % 10));
            p.next = node;
            p = node;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int tmp = l1.val + carry;
            if (tmp > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(tmp % 10);
            p.next = node;
            p = node;
            l1 = l1.next;
        }
        while (l2 != null) {
            int tmp = l2.val + carry;
            if (tmp > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(tmp % 10);
            p.next = node;
            p = node;
            l2 = l2.next;
        }
        if (carry == 1) p.next = new ListNode(1);
        return head.next;
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node, p = node.next;
        while (curr != null || p != null) {
            curr.next = prev;
            prev = curr;
            curr = p;
            if (curr == null) break;
            p = p.next;
        }
        return prev;
    }
}
