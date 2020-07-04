import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: GroupAnagrams
 * Description:
 *
 * @author mingxiufeng@cloudwalk.cn
 * @version 1.5.3
 * @date 2020/07/04
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groupAnagrams = new HashMap<>();

        int[] anagrams = new int[26];
        for (String item : strs) {
            Arrays.fill(anagrams, 0);
            for (char val : item.toCharArray()) {
                ++anagrams[val - 'a'];
            }
            StringBuilder stringBuilder = new StringBuilder(26);
            String anagramValue = null;
            for (int i = 0; i < anagrams.length; i++) {
                stringBuilder.append(anagrams[i]).append(":");
            }
            anagramValue = stringBuilder.toString();
            groupAnagrams.computeIfAbsent(anagramValue, t -> new ArrayList<>()).add(item);
        }

        return groupAnagrams.values().stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
}
