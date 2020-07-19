package bfsdfs;
import java.util.ArrayList;
import java.util.List;
/**
 * 有效的括号 DFS
 */
public class GenerateParenthesis {

    /**
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n){
        List<String> result=new ArrayList<>();

        generateParenthesis(result,n,0,0,"");

        return result;
    }

    /**
     *
     * @param result
     * @param n
     * @param left
     * @param right
     * @param s
     */
    private void generateParenthesis(List<String> result, int n, int left, int right, String s) {
        if(left==n||right==n){
            result.add(s);
            return;
        }

        if(left<n){
            generateParenthesis(result,n,left+1,right,s+"(");
        }
        if(left>right){
            generateParenthesis(result,n,left,right+1,s+")");
        }
    }
}
