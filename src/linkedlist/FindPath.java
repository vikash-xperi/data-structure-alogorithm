package linkedlist;

class PathNode {
    String data;
    PathNode next;
    PathNode prev;

    public PathNode(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class FindPath {
    public static void main(String[] args) throws Exception {
        getPath("/home/vikash/fl1/../fl2/./fl3//////fl4");

    }
    public static void getPath(String input) throws Exception {
        String[] element = input.split("/");
        PathNode head = new PathNode("");
        PathNode curr = head;
        for (String str : element) {
            if (str.equals("") || str.equals(".")) {
                continue;
            }
            else if (str.equals("..")) {
                curr = deleteNode(curr);
            }
            else {
                curr = addNode(str, curr);
            }
        }
        displayPath(head.next);
    }

    private static PathNode deleteNode(PathNode node) throws Exception {
        PathNode tmp = node.prev;
        if (tmp == null) {
            System.out.println("Wrong Path");
            throw new Exception();
        }
        tmp.next = null;
        return tmp;
    }

    public static PathNode addNode(String data, PathNode parent) {
        PathNode p = new PathNode(data);
        parent.next = p;
        p.prev = parent;
        return p;
    }

    private static void displayPath(PathNode head) {
        if (head == null)
            System.out.println("No path available");
        else {
            while (head != null) {
                System.out.print("/" + head.data);
                head = head.next;
            }
        }
    }
}
