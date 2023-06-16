package linkedlist;

import static linkedlist.Insertion.lengthOfLinkedList;
import static linkedlist.Insertion.printNode;

public class IntersectionPoint {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(3);
        n1.next.next.next = new Node(4);
        n1.next.next.next.next = new Node(5);
        n1.next.next.next.next.next = new Node(6);
        n1.next.next.next.next.next.next = new Node(7);
        // list 2
        Node n2 = new Node(10);
        n2.next = new Node(9);
        n2.next.next = new Node(8);
        n2.next.next.next = n1.next.next.next;
//        printNode(intersectionPointOfTwoLinkedList(n1, n2));
    }
    public static Node intersectionPointOfTwoLinkedList(Node head1, Node head2) {
        Node p = head1, q = head2;
        int count_p = lengthOfLinkedList(p), count_q = lengthOfLinkedList(q);
        if (count_p > count_q) {
            int diff = count_p - count_q;
            while (diff-- > 0) {
                p = p.next;
            }
        }
        else if (count_p < count_q) {
            int diff = count_q - count_p;
            while (diff-- > 0) {
                q = q.next;
            }
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
    public static Node intersectionPointOfTwoLinkedListUsingTwoPointer(Node head1, Node head2) {
        Node p = head1, q = head2;
        while (p != q) {
            if (p.next == null)
                p = head2;
            if (q.next == null)
                q = head1;
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
