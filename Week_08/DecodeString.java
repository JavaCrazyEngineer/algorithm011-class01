import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 *
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 *
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 *
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class DecodeString {

    /**
     *
     * @param s
     * @return
     */
    public String decodeString(String s){
        Stack<Integer> count=new Stack<>();
        Stack<String> result=new Stack<>();
        int i=0;
        result.push("");
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch>='0'&&ch<='9'){
                int start=i;
                while(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9'){
                    i++;
                }
               count.push(Integer.parseInt(s.substring(start, i + 1)));
            }else if(i=='['){
                result.push("");
            }else if(i==']'){
                String str=result.pop();
                StringBuilder sb=new StringBuilder();
                int times=count.pop();
                for(int j=0;i<times;j++){
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            }else{
                result.push(result.pop() + ch);
            }
            i++;
        }
        return result.pop();
    }

    /**
     *
     * @param s
     * @return
     */
    public String decodeStringII(String s){

        String res="";
        Stack<Integer> countStack=new Stack<>();
        Stack<String> resStack=new Stack<>();

        int idx=0;
        while(idx<s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int count=0;
                while(Character.isDigit(idx)){
                    count=10*count+(s.charAt(idx)-'0');
                    idx++;
                }
                countStack.push(count);
            }else if(s.charAt(idx)=='['){
                resStack.push("");
                res="";
                idx++;
            }else if(s.charAt(idx)==']'){

                StringBuilder sb=new StringBuilder(resStack.pop());
                int times=countStack.pop();
                for(int i=0;i<times;i++){
                    sb.append(res);
                }
                idx++;
            }else{
               res+=s.charAt(idx++);
            }
        }
        return res;
    }
}
