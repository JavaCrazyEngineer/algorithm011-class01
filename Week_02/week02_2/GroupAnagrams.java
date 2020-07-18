package week02_2;

import java.util.*;

/**
 * 异位词
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 */
public class GroupAnagrams {

    /**
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result=new ArrayList<>();

        Map<String,List<String>> mapping=new HashMap<String,List<String>>();
        int[] charASCII=new int[26];
        for(String str:strs){
            Arrays.fill(charASCII,0);
            for(char charVal:str.toCharArray()){
                charASCII[charVal-'a']=charASCII[charVal-'a']+1;
            }

            StringBuilder sb=new StringBuilder();
            for(int ascii:charASCII){
                sb.append(ascii).append(":");
            }
            String key=sb.toString();
            mapping.computeIfAbsent(key,t->new ArrayList<String>()).add(str);
        }

        mapping.values().forEach(value->{
            result.add(value);
        });
        return result;
    }


    public static void main(String[] args) {
        String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
}
