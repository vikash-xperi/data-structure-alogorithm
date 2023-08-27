package sixtydayschallenge;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        display(mergeTwoSortedLinkedList(head1, head2));
    }

    private static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    private static ListNode mergeTwoSortedLinkedList(ListNode head1, ListNode head2) {
        ListNode ans = head1;
        while (head1 != null && head2 != null) {
            ListNode tmp = null;
            if (head1.val == head2.val) {
                tmp = head1.next;
                head1.next = head2;
                head1 = tmp;
            } else if (head1.val > head2.val) {
                tmp = head2.next;
                head2.next = head1;
                head2 = tmp;
            } else {
                tmp = head1.next;
                head1.next = head2;
                head1 = tmp;
            }
        }

        if (head1 != null) {
            head2 = head1;
        }
        if (head2 != null) {
            head1 = head2;
        }
        return ans;
    }
}
