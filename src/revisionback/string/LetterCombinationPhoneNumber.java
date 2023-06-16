package revisionback.string;

import java.util.*;

public class LetterCombinationPhoneNumber {
    static List<String> res = new ArrayList<String>();
    static Map<Character, List<Character>> map = new HashMap();
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    private static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        //Add all the characters linked to a number to a HashMap
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        backtrack(digits, 0, "");
        return res;
    }

    public static void backtrack(String digits, int idx, String curr) {
        //If idx reaches to the final element of digits then the result should be added
        if(idx == digits.length()) {
            res.add(curr);
            return;
        }
        //Get the list of all characters
        List<Character> l = map.get(digits.charAt(idx));
        //Iterating over the list of all charcaters
        for(int i=0; i<l.size(); i++) {
            char ch = l.get(i);
            //Add the character to current string
            curr += ch;
            //Recursive call with increased index so that the next element of digits is now considered
            backtrack(digits, idx+1, curr);
            //Control comes here after returning from base case of this function. Removing the last element to try other permutations in the next iteration of loop.
            curr = curr.substring(0, curr.length()-1);
        }
    }
}
