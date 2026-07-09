// Last updated: 7/9/2026, 3:20:08 PM
import java.util.*;

class Solution {
    String[] map = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    void backtrack(String digits, int index, StringBuilder path, List<String> res) {
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            path.append(ch);
            backtrack(digits, index + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}