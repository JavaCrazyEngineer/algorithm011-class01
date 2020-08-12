import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> generateList=new ArrayList<>();
        generate(0,0,n,"",generateList);
        return generateList;
    }

    /**
     *
     * @param i
     * @param j
     * @param n
     * @param s
     * @param generateList
     */
    private void generate(int i, int j, int n, String s, List<String> generateList) {
        if(i==n&&j==n){
            generateList.add(s);
        }
        if(i<n){
            generate(i+1,j,n,s+"(",generateList);
        }
        if(i>j){
            generate(i,j+1,n,s+")",generateList);
        }
    }
}
