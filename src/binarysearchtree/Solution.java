package binarysearchtree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node {
    int data;
    Node next;
    Node (int data){
        this.data = data;
    }
}
public class Solution {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node7.next = node6;
        node6.next = node2;

        System.out.println(getIntersectionPoint(node1, node7).data);
//        System.out.println(getIntersectionNode(node1, node7).data);
    }
    public static Node getIntersectionPoint(Node l1, Node l2) {
        Node p = l1, q = l2;

        int len1 = 0, len2 = 0;
        while (p != null) {
            p = p.next;
            len1++;
        }
        while (q != null) {
            q = q.next;
            len2++;
        }
        p = l1; q = l2;
        int diff = 0;
        if (len1 > len2) {
            diff = len1 - len2;
            while (diff-- > 0) {
                p = p.next;
            }
        }
        else if (len2 > len1) {
            diff = len2 - len1;
            while (diff-- > 0) {
                q = q.next;
            }
        }
        while (p != q) {
            p = p.next;
            q = q.next;
            if (p == null || q == null) {
                return null;
            }
        }
        return p;
    }

    public static Node getIntersectionNode(Node head1, Node head2) {
        Node p = head1, q = head2;
        int count = 0;
        while (p != q) {
            count++;
            if (p.next == null) {
                p = head2;
            }
            if (q.next == null) {
                q = head1;
            }
            p = p.next;
            q = q.next;
        }
        System.out.println(count);
        return p;
    }
}

//O(max(n,m) + abs(n, m)) -> O(n)
