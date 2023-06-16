package revision.binarysearch.easy;

public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

    public static int firstBadVersion(int val) {
        int l = 1, r = val;
        int first = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid - 1;
                first = mid;
            } else {
                l = mid + 1;
            }
        }
        return first;
    }

    private static boolean isBadVersion(int n) {
        if (n >= 1702766719) return true;
        return false;
    }
}
