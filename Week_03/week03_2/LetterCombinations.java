package week03_2;

import java.util.*;

/**
 * 电话号码的字母组合
 * 题解：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 */
public class LetterCombinations {

    /**
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        Map<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> result = new LinkedList<>();
        letterCombination(digits, map, 0, result, "");
        return result;
    }

    /**
     * @param digits
     * @param map
     * @param level
     * @param result
     * @param val
     */
    private void letterCombination(String digits, Map<Character, String> map, int level, List<String> result, String val) {
        if (level == digits.length()) {
            result.add(val);
            return;
        }

        String letter = map.get(digits.charAt(level));

        for (int i = 0; i < letter.length(); i++) {
            letterCombination(digits, map, level + 1, result, val + letter.charAt(i));
        }
    }

    public static void main(String[] args) {
        String digits="369";
        System.out.println(new LetterCombinations().letterCombinations(digits));
    }
}
