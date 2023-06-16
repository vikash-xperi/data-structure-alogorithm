package linkedlist;

import java.util.*;

public class Insertion {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        Node head = new Node(arr1[0]);
        int i = 1;
        Node prev = head;
        while (i < arr1.length) {
            prev = insert(arr1[i], prev);
            i++;
        }
//        Node last = lastNode(head);
//        last.next = middleElement(head);
//        System.out.println(lengthOfLoop(head));
//        System.out.println("Length: " + lengthOfLinkedList(head));
//        System.out.println("Searched Element: " + searchElement(head, 3));
//        System.out.println("Middle Element: " + middleElement(head).data);
//        System.out.println(findPalindromeUsingReverse(head));
//        System.out.println(removeDuplicatesFromUnsortedLinkedList(head));
//        System.out.println(swapNodes(head, 15, 20));
//        printNode(pairwiseSwapping(head));
//        printNode(moveLastElementToFirst(head));
        printNode(reverseUsingRecursion(head));
    }
    public static Node insert(int data, Node parentNode) {
        Node node = new Node(data);
        parentNode.next = node;
        return node;
    }
    public static void printNode(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
    }
    public static Node lastNode(Node head) {
        if (head.next == null)
            return head;
        return lastNode(head.next);
    }
    public static int lengthOfLinkedList(Node head) {
        if (head == null)
            return 0;
        return 1 + lengthOfLinkedList(head.next);
    }
    public static Node searchElement(Node head, int k) {
        if (head == null)
            return null;
        if (head.data == k)
            return head;
        return searchElement(head.next, k);
    }
    public static Node middleElement(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        int count = 1;
        fast = slow.next;
        if (flag) {
            while (slow != fast) {
                fast = fast.next;
                count++;
            }
            return count;
        }
        return 0;
    }
    public static boolean findPalindromeUsingStack(Node head) {
        Stack<Integer> stack = new Stack<>();
        stack.push(head.data);
        Node p = head.next;
        while (p != null) {
            if (stack.peek() == p.data)
                stack.pop();
            else
                stack.push(p.data);
            p = p.next;
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
    public static boolean findPalindromeUsingReverse(Node head) {
        Node slow_ptr = head, fast_ptr = head, mid_ptr = null, prev_slow_ptr = null;
        boolean odd = true;
        while (fast_ptr != null && fast_ptr.next != null) {
            prev_slow_ptr = slow_ptr;
            slow_ptr = slow_ptr.next;
            if (fast_ptr.next.next == null) {
                odd = false;
            }
            fast_ptr = fast_ptr.next.next;
        }
        mid_ptr = slow_ptr;
        Node rev = null;
        if (odd)
            rev = reverse(mid_ptr.next);
        else
            rev = reverse(mid_ptr);
        prev_slow_ptr.next = rev;
        while (rev != null) {
            if (head.data != rev.data)
                return false;
            head = head.next;
            rev = rev.next;
        }
        return true;
    }
    public static Node reverse(Node head) {
        Node curr = head, prev = null, p = null;
        while (curr != null) {
            p = curr.next;
            curr.next = prev;
            prev = curr;
            curr = p;
        }
        return prev;
    }
    public static Node reverseUsingRecursion(Node head) {
        if (head == null || head.next == null)
            return head;
        Node rest = reverseUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
    public static Node removeDuplicatesFromSortedLinkedList(Node head) {
        Node p = head, q = head.next;
        while (q != null) {
            if (p.data == q.data)
                q = q.next;
            else {
                p.next = q;
                p = q;
                q = q.next;
            }
        }
        return head;
    }
    public static Node removeDuplicatesFromUnsortedLinkedList(Node head) {
       Set<Integer> set = new HashSet<>();
        Node p = null, q = head;
        while (q != null) {
            if (set.contains(q.data)) {
                p.next = q.next;
            }
            else {
                set.add(q.data);
                p = q;
            }
            q = q.next;
        }
        return head;
    }
    public static Node swapNodes(Node head, int a, int b) {
        Node p = null, q = null, temp = null, ptr = head;
        while(ptr.next != null) {
            if (ptr.next.data == a)
                p = ptr;
            if (ptr.next.data == b)
                q = ptr;
            ptr = ptr.next;
        }
        if (p != null && q != null) {
            temp = p.next;
            p.next = q.next;
            q.next = temp;
            temp = p.next.next;
            p.next.next = q.next.next;
            q.next.next = temp;
        }
        return head;
    }
    public static Node pairwiseSwapping(Node head) {
        Node tmp = head;
        while (tmp != null && tmp.next != null) {
            int k = tmp.data;
            tmp.data = tmp.next.data;
            tmp.next.data = k;
            tmp = tmp.next.next;
        }
        return head;
    }
    public static Node moveLastElementToFirst(Node head) {
        Node tmp = head;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        Node p = tmp.next;
        tmp.next = null;
        p.next = head;
        head = p;
        return head;
    }
}
