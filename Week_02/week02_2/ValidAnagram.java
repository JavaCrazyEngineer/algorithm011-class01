package week02_2;

import java.util.Arrays;

/**
 *有效的字母异位词
 */
public class ValidAnagram {

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(null!=s&&null!=t&&s.length()!=t.length()){
            int[] anagrams=new int[26];
            Arrays.fill(anagrams,0);

            char[] sArray= s.toCharArray();
            char[] tArray= t.toCharArray();
            for(int i=0;i<sArray.length;i++){
                anagrams[sArray[i]-'a']++;
                anagrams[tArray[i]-'a']++;
            }

            for(int i=0;i<anagrams.length;i++){
                if(anagrams[i]!=0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
