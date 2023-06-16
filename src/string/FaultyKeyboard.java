package string;

public class FaultyKeyboard {
    public static void main(String[] args) {
        System.out.println(solution("a", "b"));
    }

    public static boolean solution(String name, String typed) {
        int i = 0, j = 0;
        for (i = 0, j = 0; j < typed.length();) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        if (i < name.length() && j == typed.length()) {
            return false;
        }
        return true;
    }
}
