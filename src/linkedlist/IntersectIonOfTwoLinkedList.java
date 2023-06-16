package linkedlist;
import static linkedlist.Insertion.*;

public class IntersectIonOfTwoLinkedList {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {2,4,6,8};
        Node head = new Node(arr1[0]);
        Node head2 = new Node(arr2[0]);
        int i = 1;
        Node prev = head;
        while (i < arr1.length) {
            prev = insert(arr1[i], prev);
            i++;
        }
        i = 1;
        prev = head2;
        while (i < arr2.length) {
            prev = insert(arr2[i], prev);
            i++;
        }
//        printNode(intersectionOfTwoSortedLinkedList(head, head2));
        printNode(addTwoNumbers(head, head2));
    }
    public static Node intersectionOfTwoSortedLinkedList(Node head1, Node head2) {
        Node head = null, p = head1, q = head2, tmp = null;
        while (p != null && q != null) {
            if (p.data < q.data)
                p = p.next;
            else if (p.data > q.data)
                q = q.next;
            else {
                if (head == null) {
                    head = new Node(p.data);
                    tmp = head;
                }
                else
                    tmp = insert(p.data, tmp);
                p = p.next;
                q = q.next;
            }
        }
        return head;
    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node tmp = null;
        int carry = 0;
        int sum = 0;
        while (true) {
            int first = 0, second = 0;
            if (l1 == null && l2 == null && carry == 0) {
                break;
            }
            if (l1 == null && l2 == null && carry != 0) {
                tmp = new Node(1, tmp);
                break;
            }
            if (l1 != null) {
                first = l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                second = l2.data;
                l2 = l2.next;
            }
            sum = first + second + carry;
            carry = sum >= 10 ? 1:0;
            sum = sum >= 10 ? sum - 10 : sum;
            tmp = new Node(sum, tmp);
        }

        return reverse(tmp);
    }
}
