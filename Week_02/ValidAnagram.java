import java.util.Arrays;

/**
 * ClassName: ValidAnagram
 * Description:
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/07/04
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (null != s && null != t && s.length() != t.length()) {
            int[] anagramArray = new int[26];
            Arrays.fill(anagramArray, 0);
            char[] sourceArray = s.toCharArray();
            char[] targetArray = t.toCharArray();

            for (int i = 0; i < sourceArray.length; i++) {
                ++anagramArray[sourceArray[i] - 'a'];
                --anagramArray[targetArray[i] - 'a'];
            }

            for (int i = 0; i < anagramArray.length; i++) {
                if (anagramArray[i] != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
