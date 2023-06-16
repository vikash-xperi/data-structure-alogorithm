package revisionback.linkedlist;

public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode headB = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(1);

        headA.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        headB.next = node5;
        node5.next = node6;
        node6.next = node2;
        System.out.println(getIntersectionNode(headA, headB).val);
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count = 0;
        ListNode p = headA, q = headB;
        while (p != q) {
            if (p == null) {
                p = headB;
                count++;
                continue;
            }
            if (q == null) {
                q = headA;
                count++;
                continue;
            }
            p = p.next;
            q = q.next;
            if (count > 2) return null;
        }
        return p;
    }
}
