package revision.linkedlist.easy;

import revision.linkedlist.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        System.out.println(isPalindrome(node1));
    }

    private static boolean isPalindrome(ListNode head) {

        if(head == null) return false;

        if (head.next == null) return true;

        ListNode middlePointer = getMid(head);
        ListNode newPointer = reverseList(middlePointer);

        while (head != null && newPointer != null){
            if(head.val != newPointer.val){
                return false;
            }
            head = head.next;
            newPointer = newPointer.next;
        }
        return true;
    }

    private static ListNode getMid(ListNode head){
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }


    private static ListNode reverseList(ListNode head){
        ListNode previousPointer = null;
        ListNode currentPointer = head;
        ListNode nextPointer = head.next;

        while (currentPointer != null) {
            currentPointer.next = previousPointer;
            previousPointer = currentPointer;
            currentPointer = nextPointer;
            if(nextPointer != null){
                nextPointer = nextPointer.next;
            }
        }
        return previousPointer;
    }
}
