package revisionback.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void display() {
        ListNode head = this;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
