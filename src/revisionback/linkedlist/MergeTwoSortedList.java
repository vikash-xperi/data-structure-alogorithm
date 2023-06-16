package revisionback.linkedlist;


public class MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node7 = new ListNode(1);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(5);
        ListNode node10 = new ListNode(6);

        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        display(mergeTwoLists(node1, node7));
    }

    private static void display(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode p = list1, q = list2, tmp = ans;

        while (p != null && q != null) {
            if (p.val <= q.val) {
                tmp.next = new ListNode(p.val);
                tmp = tmp.next;
                p = p.next;
            } else {
                tmp.next = new ListNode(q.val);
                tmp = tmp.next;
                q = q.next;
            }
        }

        if (p == null && q != null) {
            tmp.next = q;
        } else if (q == null && p != null) {
            tmp.next = p;
        }

        return ans.next;
    }
}
