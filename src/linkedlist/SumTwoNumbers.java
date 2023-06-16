package linkedlist;

public class SumTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
//        l6.next = l7;
//
//        l8.next = l9;
//        l9.next = l10;
//        l10.next = l11;
        SumTwoNumbers sumTwoNumbers = new SumTwoNumbers();
        System.out.println(sumTwoNumbers.addTwoNumbers(l1, l4));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode node = ans;
        int carry = 0, rem = 0;
        boolean flag = false;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 !=  null) {
                sum += l1.val;
                if (l1.next == null && l2 == null) {
                    flag = true;
                }
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                if (l1 == null && l2.next == null) {
                    flag = true;
                }
                l2 = l2.next;
            }
            if (flag) {
                sum += carry;
                carry = sum /10;
                rem = sum % 10;
                node = push(rem, node);
                if (carry == 1)
                    node = push(carry, node);
            } else {
                sum += carry;
                carry = sum / 10;
                node = push(sum % 10, node);
            }
        }
        return ans.next;
    }

    public ListNode push(int data, ListNode parent) {
        ListNode node = new ListNode(data);
        parent.next = node;
        return node;
    }
}
