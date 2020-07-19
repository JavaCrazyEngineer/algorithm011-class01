package week03_2;
import java.util.ArrayList;
import java.util.List;
/**
 * 生成有效的括号
 */
public class GenerateParenthesis {

    /**
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n){

        List<String> generates=new ArrayList<>();

        generateParenthesis(generates,0,0,"",n);

        return generates;
    }

    /**
     *
     * @param generates
     * @param left
     * @param right
     * @param generateVal
     * @param n
     */
    private void generateParenthesis(List<String> generates, int left, int right, String generateVal, int n) {

        if(left==n&&right==n){
            generates.add(generateVal);
            return;
        }

        if(left<n){
            generateParenthesis(generates,left+1,right,generateVal+"(",n);
        }

        if(left>right){
            generateParenthesis(generates,left,right+1,generateVal+")",n);
        }
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(new GenerateParenthesis().generateParenthesis(n));
    }
}
