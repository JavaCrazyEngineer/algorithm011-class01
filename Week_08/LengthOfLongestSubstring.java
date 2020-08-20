import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char ch = s.charAt(right++);
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            while (window.get(ch) > 1) {
                char lCh = s.charAt(left++);
                window.put(lCh, window.get(lCh) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
