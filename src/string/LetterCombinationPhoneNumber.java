package string;

import java.util.*;

public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationPhoneNumber letterCombinationPhoneNumber = new LetterCombinationPhoneNumber();
        System.out.println(letterCombinationPhoneNumber.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> result = new ArrayList<>();
        if(len == 0) return result;

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        findCombinations(digits, result, new StringBuilder(), len, 0, map);
        return result;
    }

    public void findCombinations(String digits, List<String> result,
                                 StringBuilder sb, int len, int start, Map<Integer, String> map){
        if(sb.length() == len)
            result.add(sb.toString());

        if(start < len){
            String letter = map.get(Integer.parseInt(String.valueOf(digits.charAt(start))));
            int letterLen = letter.length();

            for(int i = 0; i < letterLen; i++){
                sb.append(letter.charAt(i));
                findCombinations(digits, result, sb, len, start+1, map);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
