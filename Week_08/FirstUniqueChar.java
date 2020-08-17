import java.util.HashMap;
import java.util.Map;

/**
 * 第一个不重复的数字
 */
public class FirstUniqueChar {

    public int findUniqueChar(String s){
        int[] charArr=new int[256];

        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            charArr[temp]=charArr[temp]+1;
        }

        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            if(charArr[temp]==1){
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param s
     * @return
     */
    public int findUniqueCharI(String s){
        Map<Character,Integer> count=new HashMap<>();

       char[] charArr=s.toCharArray();
        for(char c :charArr){
            count.put(c,count.getOrDefault(c,0)+1);
        }

        for(int i=0;i<s.length();i++){
            if(count.get(s.charAt(i))==1) return 1;
        }

        return -1;
    }
}
