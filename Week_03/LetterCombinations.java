import java.util.*;

/**
 * ClassName: LetterCombinations
 * Description: 电话号码的字母组合
 * 题解：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 * @author G20200343080265
 * @date 2020/07/11
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {

        if(digits==null||digits.length()==0){
            return Collections.emptyList();
        }

        Map<Character,String> map=new HashMap<>(8);
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        List<String> res=new LinkedList<>();
        search("",digits,0,res,map);
        return res;
    }

    /**
     *
     * @param s
     * @param digits
     * @param level
     * @param res
     * @param map
     */
    private void search(String s, String digits, int level, List<String> res, Map<Character, String> map) {

        if(level==digits.length()){
            res.add(s);
            return;
        }

        String letters=map.get(digits.charAt(level));

        for(int j=0;j<letters.length();j++){
            search(s+letters.charAt(j),digits,level+1,res,map);
        }
    }
}
