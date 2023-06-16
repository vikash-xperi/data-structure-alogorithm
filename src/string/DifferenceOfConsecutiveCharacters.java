package string;

public class DifferenceOfConsecutiveCharacters {
    public static void main(String[] args) {
        System.out.println(solution("pepCODinG"));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder("");

        if (str.length() == 1) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (i + 1 < str.length()) {
                sb.append(str.charAt(i + 1) - str.charAt(i));
            }
        }

        return sb.toString();
    }
}
